/*
 *  Copyright@2019 清云智通（北京）科技有限公司 保留所有权利
 */
package com.leecode;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author fanjf@tsingyun.net
 * @date 2020/7/6 15:45
 */
public class MaxProfit_121 {
    public int maxProfit(int[] prices) {
        // 动态规划
        // 状态转移
//        dp[i][0] 怎样转移？
//        dp[i - 1][0] ：当然可以从昨天不持股转移过来，表示从昨天到今天什么都不操作，这一点是显然的；
//        dp[i - 1][1] + prices[i]：昨天持股，就在下标为 i 的这一天，我卖出了股票，状态由 1 变成了 0，此时卖出股票，因此加上这一天的股价。
//        综上：dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//        dp[i][1] 怎样转移？
//        dp[i - 1][1] ：昨天持股，今天什么都不操作，当然可以从昨天持股转移过来，这一点是显然的；
//        -prices[i]：注意：状态 1 不能由状态 0 来，因为事实上，状态 0 特指：「卖出股票以后不持有股票的状态」，请注意这个状态和「没有进行过任何一次交易的不持有股票的状态」的区别。
//        因此，-prices[i] 就表示，在下标为 i 的这一天，执行买入操作得到的收益。注意：因为题目只允许一次交易，因此不能加上 dp[i - 1][0]。
//        综上：dp[i][1] = max(dp[i - 1][1], -prices[i]);
        // 状态
//        dp[i][j] 表示：在下标为 i 的这一天，用户手上持股状态为 j 所获得的最大利润。
//        说明：
//        1)j 只有 2 个值：0 表示不持股（特指卖出股票以后的不持股状态），1 表示持股。
//        2) 用户手上不持股」不代表用户一定在下标为 i 的这一天把股票抛售了；
        if(prices.length==0){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        // 状态转移
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        int max = dp[0][0];
        for (int i = 1; i < dp.length; i++) {
            if (max < dp[i][0]) {
                max = dp[i][0];
            }
        }
        return max;
    }
    public int maxProfit2(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int res = 0;
        int curMin = prices[0];
        for(int i=1;i<prices.length;i++){
            curMin = Math.min(curMin,prices[i]);
            res = Math.max(res,prices[i]-curMin);
        }
        return res;

    }

    public static void main(String[] args) {
        int [] arr = new int[]{7,1,5,3,6,4};
        int [] arr2 = new int[]{7,6,4,3,1};
        System.out.println(new MaxProfit_121().maxProfit(arr));
        System.out.println(new MaxProfit_121().maxProfit(arr2));
    }
}
