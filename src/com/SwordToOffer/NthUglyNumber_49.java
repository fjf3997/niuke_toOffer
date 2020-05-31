package com.SwordToOffer;

/**
 * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 * 1 是丑数。
 * n 不超过1690。
 * 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chou-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NthUglyNumber_49 {
    public int nthUglyNumber(int n) {
        if(n<=0)
            return 0;
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int nextUgly =  1;
        int index2 = 0, index3 = 0, index5 = 0;
        while (nextUgly<n){
            int min = Max3(uglyNumbers[index2]*2,uglyNumbers[index3]*3,uglyNumbers[index5]*5);
            uglyNumbers[nextUgly] = min;
            while (uglyNumbers[index2]*2<=min){
                index2++;
            }
            while (uglyNumbers[index3]*3<=min){
                index3++;
            }
            while (uglyNumbers[index5]*5<=min){
                index5++;
            }
            nextUgly++;
        }
        return uglyNumbers[nextUgly-1];
    }
    private int Max3(int a,int b,int c){
        return Math.min(Math.min(a,b),c);
    }

    public static void main(String[] args) {
        System.out.println(new NthUglyNumber_49().nthUglyNumber(10));
    }
}
