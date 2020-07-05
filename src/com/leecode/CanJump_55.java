package com.leecode;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanJump_55 {
    /**
     * 动态规划存在性问题
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        // 状态
        boolean [] dp = new boolean[nums.length];
        // 初始值
        dp[0] = true;
        for(int i=1;i<nums.length;i++){
            dp[i] = false;
            for(int j=0;j<i;j++){
                // 状态转移方程 f[j] = OR(0<=i<j)(f[i] AND i + a[i] >= j)
                if(dp[j]&&j+nums[j]>=i){
                    dp[i] = true;
                }
            }
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        System.out.println(new CanJump_55().canJump(new int[]{2,3,1,1,4}));
    }
}
