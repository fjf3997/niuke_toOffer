package com.leecode;

import java.util.Arrays;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntegerBreak_343 {
    private int [] memo;

    public int integerBreak(int n) {
        if(n<2)
            throw new IllegalArgumentException("参数错误");
        memo = new int[n+1];
        Arrays.fill(memo,-1);
        //法一
       /* int res = breakNum(n);
        return res;*/
       //法二
        memo[1]=1;
        for(int i=2;i<=n;i++){
            //求解memo[i]
            for(int j=1;j<=i-1;j++){
                memo[i] = max3(memo[i],j*(i-j),j*memo[i-j]);
            }
        }
        return memo[n];
    }

    private int breakNum(int n) {
        if(n==1)
            return 1;
        int res = -1;
        if(memo[n]!=-1)
            return memo[n];
        for(int i=1;i<=n-1;i++){
            res = max3(res,i*(n-i),i*breakNum(n-i));
        }
        memo[n] = res;
        return res;
    }

    private int max3(int res, int i, int breakNum) {
        return Math.max(res,Math.max(i,breakNum));
    }

    public static void main(String[] args) {
        System.out.println(new IntegerBreak_343().integerBreak(10));
    }
}
