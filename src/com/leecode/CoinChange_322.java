package com.leecode;

import java.util.*;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CoinChange_322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            dp [i] = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0&&dp[i-coins[j]]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        if(dp[amount]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount];

    }
    private int[]memo;
    public int coinChange2(int[] coins, int amount) {
        memo = new int[amount+1];
        return recursion(coins,amount);
    }

    private int recursion(int[] coins, int amount) {
        if(amount<0){
            return -1;
        }
        if(amount==0){
            return 0;
        }
        if(memo[amount]!=0){
            return memo[amount];
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int res = recursion(coins,amount-coins[i]);
            if(res>=0&&res<min){
                min = res+1;
            }
        }
        memo[amount] = min==Integer.MAX_VALUE?-1:min;
        return memo[amount];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange_322().coinChange2(new int[]{1,2,5},9));
        System.out.println(new CoinChange_322().coinChange2(new int[]{2},3));
    }
}
