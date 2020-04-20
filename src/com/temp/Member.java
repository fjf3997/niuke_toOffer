package com.temp;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Member implements Runnable {
    Team team; //球员所在的球队
    Tennis tableTennis; //每个队员所传的球
    String memName; //球员名称
    int sendNum; //每个队员传球的次数
    CountDownLatch countDownLatch; //保证每个球员发球次数
    public Member(String memName, int sendNum, Team team, Tennis tableTennis, CountDownLatch countDownLatch) {
        this.team = team;
        this.tableTennis = tableTennis;
        this.memName = memName;
        this.sendNum = sendNum;
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        while (!this.tableTennis.isIsEnd()) { //当在发球此数内
            sendBall();
        }
        countDownLatch.countDown();
    }
    /**
     * 发球的逻辑注意这里的synchronized,并发控制
     */
    private void sendBall() {
        synchronized (tableTennis) {

            while (!(this.tableTennis.getTrail().equals(this.team.getTeamName()))) { //判断是否是该队传球
                if (this.tableTennis.isIsEnd()) {
                    return;
                }

                try {
                    tableTennis.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Tennis.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (this.tableTennis.isIsEnd()) { //判断比赛有没有结束，结束直接返回
                return;
            }
            if (this.tableTennis.getState() == 0) { //判断是不是发球状态
                this.sendNum--; //将发球次数减一
            }

            //发球的时候判断在界内还是界外
            if (this.tableTennis.shot().equals("in")) { //发球表示球在界内
                this.tableTennis.setTrail(TeamController.getRivalTeam(this.team.getTeamName()).getTeamName()); //对手接球
                this.tableTennis.setState(1); //如果发球在界内，将发球状态改为传球状态
                System.out.print(this.memName + "-in-");
            } else { //如果在界外，此时还是发球状态
                TeamController.getRivalTeam(this.team.getTeamName()).addScore(); //对方队加上一分
                System.out.print(this.memName + "-out\n");
                this.tableTennis.setTeamTrail(TeamController.getRivalTeam(this.tableTennis.getTeamTrail()).getTeamName());
                this.tableTennis.setTrail(this.tableTennis.getTeamTrail());
                this.tableTennis.setState(0);
                this.tableTennis.addTotalSendNum(); //将发球次数加一
                if (this.tableTennis.getTotalSendNum() == TeamController.getMatchTimes()) {
                    this.tableTennis.setIsEnd(true);
                }
            }

            //执行完唤醒对手线程
            tableTennis.notifyAll();
        }
    }

}
