package com.temp;

import java.util.HashMap;

public class TeamController {
    private static final String[] team = {"team1", "team2"}; //比赛队的名称
    private static final HashMap<String, String[]> map = new HashMap(); //用于存放各队的队员信息
    private static final HashMap<String, Team> rivalTeam = new HashMap(); //用于存放各队的对手
    private static int totalMatchTime; //默认0场比赛

    static {
        map.put(team[0], new String[]{"A1", "A2"}); //初始化team1队球员
        map.put(team[1], new String[]{"B1", "B2"}); //初始化team2队球员
    }

    //设置各队的对方队伍
    public static void setTeamRival(Team rivalTeam1, Team rivalTeam2) {
        rivalTeam.put(team[0], rivalTeam1);
        rivalTeam.put(team[1], rivalTeam2);
    }

    public static void setMatchTimes(int time) {
        totalMatchTime = time;
    }

    public static int getMatchTimes() {
        return totalMatchTime;
    }

    public static Team getRivalTeam(String teamName) {
        return rivalTeam.get(teamName);
    }

    public static String[] getTeamName() {
        return team;
    }

    public static String[] getTeamMems(String teamName) {
        return map.get(teamName);
    }
}
