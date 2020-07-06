package com.lintcode;

/**
 * 这里有n个房子在一列直线上，现在我们需要给房屋染色，分别有红色蓝色和绿色。每个房屋染不同的颜色费用也不同，
 * 你需要设计一种染色方案使得相邻的房屋颜色不同，并且费用最小，返回最小的费用。
 * 费用通过一个nx3 的矩阵给出，比如cost[0][0]表示房屋0染红色的费用，cost[1][2]表示房屋1染绿色的费用。
 * Example
 * 样例 1:
 *
 * 输入: [[14,2,11],[11,14,5],[14,3,10]]
 * 输出: 10
 * 解释: 第一个屋子染蓝色，第二个染绿色，第三个染蓝色，最小花费：2 + 5 + 3 = 10.
 * 样例 2:
 *
 * 输入: [[1,2,3],[1,4,6]]
 * 输出: 3
 */
public class PaintHouse_515 {
    public int minCost(int[][] costs) {
        // write your code here
        // 状态 求油漆前i栋房子并且房子i-1是红色、蓝色、绿色的最小花费
        int dp[][] = new int[costs.length+1][3];
        dp[0][0] = dp[0][1] = dp[0][2] = 0;
        // 状态转移 f[i][0] = min({f[i-1][1] + cost[i-1][0], f[i-1][2] + cost[i-1][0]}
        for(int i=1;i<=costs.length;i++){
            dp[i][0] = Math.min(dp[i-1][1] + costs[i-1][0] ,dp[i-1][2] + costs[i-1][0]);
            dp[i][1] = Math.min(dp[i-1][0] + costs[i-1][1] ,dp[i-1][2] + costs[i-1][1]);
            dp[i][2] = Math.min(dp[i-1][0] + costs[i-1][2] ,dp[i-1][1] + costs[i-1][2]);
        }
        return Math.min(dp[costs.length][0],Math.min(dp[costs.length][1],dp[costs.length][2]));
    }

    public static void main(String[] args) {
        int [][] arr = new int[][]{
            {14,2,11},
            {11,14,5},
            {14,3,10}
        };
        System.out.println(new PaintHouse_515().minCost(arr));
    }
}
