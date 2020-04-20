package com.temp;

public class Team {
    String teamName; //球队的名称
    int score = 0; //球队的得分

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getScore() {
        return score;
    }

    public void addScore() {
        this.score = ++score;
    }
}
