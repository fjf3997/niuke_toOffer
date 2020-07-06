/*
 *  Copyright@2019 清云智通（北京）科技有限公司 保留所有权利
 */
package com.leecode;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author fanjf@tsingyun.net
 * @date 2020/7/6 11:47
 */
public class MaxSubArray_53 {
    public int maxSubArray(int[] nums) {
        // 动态规划
        // 状态 表示包含nums[i]的最大子数组和
        if(nums.length==0){
            return 0;
        }
        int []dp = new int[nums.length];
        // 初始化
        dp[0] = nums[0];
        // 状态转移
        // dp[i] = max{nums[i],dp[i-1]+nums[i]}
        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int max = dp[0];
        for(int i=1;i<dp.length;i++){
            if(max<dp[i]){
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubArray_53().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
