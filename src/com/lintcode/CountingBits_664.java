/*
 *  Copyright@2019 清云智通（北京）科技有限公司 保留所有权利
 */
package com.lintcode;

/**
 * 给出一个 非负 整数 num，对所有满足 0 ≤ i ≤ num 条件的数字 i 均需要计算其二进制表示中数字 1 的个数并以数组的形式返回。
 * Example
 * 样例1
 * 输入： 5
 * 输出： [0,1,1,2,1,2]
 * 解释：
 * 0~5的二进制表示分别是：
 * 000
 * 001
 * 010
 * 011
 * 100
 * 101
 * 每个数字中1的个数为： 0,1,1,2,1,2
 * 样例2
 * 输入： 3
 * 输出： [0,1,1,2]
 * Challenge
 * 1.时间复杂度为 O(n * sizeof(integer))的解法很容易想到, 尝试挑战线性的时间复杂度 O(n) (只遍历一遍)。
 * 2.空间复杂度应为 O(n).
 * 3.你能完成这项挑战吗? 不借助任何内嵌的函数, 比如C++ 中的 __builtin_popcount 亦或是任何其他语言中的方法
 * @author fanjf@tsingyun.net
 * @date 2020/7/9 13:45
 */
public class CountingBits_664 {
    /**
     * @param num: a non negative integer number
     * @return: an array represent the number of 1's in their binary
     */
    public int[] countBits(int num) {
        // write your code here
        // 动态规划
        // 状态
        int [] dp = new int[num+1];
        dp[0] = 0;
        // 状态转移
        for(int i=1;i<=num;i++){
            dp[i] = dp[i>>1] + (i&1);
        }
        return dp;

    }

    public static void main(String[] args) {
        int[] ints = new CountingBits_664().countBits(5);
        for (int anInt : ints) {
            System.out.println(anInt);

        }
        System.out.println();
        int i = 3;
        int k = i>>1;
        int j = i&1;
        System.out.println(i);
    }
}
