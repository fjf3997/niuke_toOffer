package com.leecode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumSquares_279 {
    //动态规划求解
    public int numSquares2(int n){
        int []memo = new int[n+1];
        Arrays.fill(memo,Integer.MAX_VALUE);
        for(int i=1;i<=n;i++){
            for(int j=1;j<=Math.ceil(Math.sqrt(i));j++){
                if(i-j*j>0)
                    memo[i]=Math.min(memo[i],memo[i-j*j]+1);
                else if(i==j*j)
                    memo[i]=1;
                else
                    break;
            }
        }
        return memo[n];
    }
    public int numSquares(int n) {
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        Pair<Integer,Integer> pair = new Pair<>(n,0);
        queue.add(pair);
        boolean [] visited = new boolean[n+1];
        visited[n] = true;
        while (!queue.isEmpty()){
            Pair<Integer,Integer> p = queue.poll();
            int num = p.first;
            int step = p.second;
            if(num==0){
                return step;
            }
            for(int i=1;;i++){
                int a = num-i*i;
                if(a<0){
                    break;
                }
                if(!visited[a]){
                    if(a==0)return step+1;
                    visited[a] = true;
                    queue.add(new Pair<>(a,step+1));
                }
            }

        }
        return 0;
    }
    private int [] memo;
    public int numSquares3(int n) {
        memo = new int[n+1];
        int res = recursion(n);
        return res;
    }

    private int recursion(int n) {
        int res = Integer.MAX_VALUE;
        if(memo[n]!=0){
            return memo[n];
        }
        for(int i=1;;i++){
            if(i*i==n){
                return 1;
            }else if(i*i>n){
                break;
            }else {
                res = Math.min(res,recursion(n-i*i)+1);
            }
        }
        memo[n] = res;
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new NumSquares_279().numSquares3(2));
    }
}
