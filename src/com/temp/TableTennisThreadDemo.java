package com.temp;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TableTennisThreadDemo {
    public static void main(String args[]) {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        double rate = 0.75; //设置选手赢的概率
        int sendNum = 6; //每个选手发球次数
        //两个队的名字
        String team1_Name = TeamController.getTeamName()[0];
        String team2_Name = TeamController.getTeamName()[1];
        //四个选手名字
        String team1_memName1 = TeamController.getTeamMems(team1_Name)[0];
        String team1_memName2 = TeamController.getTeamMems(team1_Name)[1];
        String team2_memName1 = TeamController.getTeamMems(team2_Name)[0];
        String team2_memName2 = TeamController.getTeamMems(team2_Name)[1];
        //创建两个队
        Team team1 = new Team(team1_Name);
        Team team2 = new Team(team2_Name);
        //设置对手
        TeamController.setTeamRival(team2, team1);
        //设置比赛场数
        TeamController.setMatchTimes(sendNum * 4); //参数为选手数*每个选手的发球数
        //创建乒乓球对象
        Tennis tableTennis = new Tennis(rate);
        //创建四个线程类
        Thread thread1 = new Thread(new Member(team1_memName1, sendNum, team1, tableTennis, countDownLatch));
        Thread thread2 = new Thread(new Member(team1_memName2, sendNum, team1, tableTennis, countDownLatch));
        Thread thread3 = new Thread(new Member(team2_memName1, sendNum, team2, tableTennis, countDownLatch));
        Thread thread4 = new Thread(new Member(team2_memName2, sendNum, team2, tableTennis, countDownLatch));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TableTennisThreadDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        //等待四个选手运行完
        try {
            countDownLatch.await();
            System.out.println("team1得分：" + team1.getScore());
            System.out.println("team2得分：" + team2.getScore());
            if (team1.getScore() > team2.getScore()) {
                System.out.println("恭喜team1队赢!");
            } else if (team1.getScore() < team2.getScore()) {
                System.out.println("恭喜team2队赢！");
            } else {
                System.out.println("平局了！");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableTennisThreadDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
