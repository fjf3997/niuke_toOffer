package com.SwordToOffer;

import java.util.Arrays;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 示例 1：
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：
 *
 * 2 <= n <= 58
 * 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CuttingRope_14_1 {
    private int [] memo;
    public int cuttingRope(int n) {
        memo = new int[n+1];
        Arrays.fill(memo,-1);
        memo[1] = memo[2] = 1;
        return cuttingRopeHelper(n);

    }

    private int cuttingRopeHelper(int n) {
        if(n==2)
            return 1;
        if(memo[n]!=-1)
            return memo[n];
        int res = -1;
        for(int i=1;i<=n-1;i++)
            res = Math.max(res,Math.max(i*cuttingRopeHelper(n-i),i*(n-i)));
        memo[n] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CuttingRope_14_1().cuttingRope(10));
    }
}
