package com.temp;

public class Tennis{
    int rate; //赢的频率
    volatile int state = 0; //球的状态,0代表发球,1代表传球,默认是发球状态
    String trail = "team1"; //传球的轨迹
    String teamTrail = "team1"; //发球的轨迹
    volatile boolean isEnd = false; //判断比赛有没有结束
    volatile int totalSendNum = 0; //总共发球次数



    public int getTotalSendNum() {
        return totalSendNum;
    }



    public void addTotalSendNum() {
        this.totalSendNum = ++totalSendNum;
    }



    public boolean isIsEnd() {
        return isEnd;
    }



    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public String getTeamTrail() {
        return teamTrail;
    }



    public void setTeamTrail(String teamTrail) {
        this.teamTrail = teamTrail;
    }



    public Tennis(double rate) {
        this.rate = (int) (rate * 100);
    }



    /**
     * 判断输赢
     *
     * @return
     */
    public final String shot() {
        int randRate = (int) (Math.random() * 100);
        if (((100 - randRate) > (this.rate))) {
            return "out";
        } else {
            return "in";
        }
    }



    public int getRate() {
        return rate;
    }



    public void setRate(int rate) {
        this.rate = rate;
    }



    public int getState() {
        return state;
    }



    public void setState(int state) {
        this.state = state;
    }



    public String getTrail() {
        return trail;
    }



    public void setTrail(String trail) {
        this.trail = trail;
    }
}
