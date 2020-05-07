package com.SwordToOffer;

/**
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyPow_16 {
    public double myPow(double x, int n) {
        if(n==1||n==-1)
            return n<0?1/n:n;
        double res=x;
        int nn = n<0?-n:n;
        int i=1;
        for(;i<=nn;i*=2){
            res*=res;
        }
        int k = nn-i;
        for(int j=1;j<=k;j++){
            res*=x;
        }
        return n<0?1/res:res;
    }

    public static void main(String[] args) {
        System.out.println(new MyPow_16().myPow(2.0,10));
    }
}
