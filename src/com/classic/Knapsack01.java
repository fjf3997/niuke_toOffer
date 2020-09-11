package com.classic;

import java.util.Arrays;

/**
 * 01背包问题
 */
public class Knapsack01 {
    private int[][] memo;
    // w代表物品种类，v代表物品价值，c代表背包容积
    public int knapsack01(int[] w, int[] v, int C) {
        int n = w.length;
        memo = new int[n][C+1];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
        recursion(w,v,C,n-1);
        return memo[n-1][C];
    }

    private int recursion(int[] w, int[] v, int c, int index) {
        if(index<0||c<=0){
            return 0;
        }
        if(memo[index][c]!=-1){
            return memo[index][c];
        }
        int res = recursion(w,v,c,index-1);
        if(c>=w[index]){
            res = Math.max(res,v[index]+recursion(w,v,c-w[index],index-1));
        }
        memo[index][c] = res;
        return res;
    }

    public static void main(String[] args) {
        int [] w = {1,2,3};
        int [] v = {6,10,12};
        System.out.println(new Knapsack01().knapsack01(w,v,5));
    }
}
