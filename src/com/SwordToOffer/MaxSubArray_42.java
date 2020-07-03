/*
 *  Copyright@2019 清云智通（北京）科技有限公司 保留所有权利
 */
package com.SwordToOffer;

/**
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *  
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author fanjf@tsingyun.net
 * @date 2020/7/3 16:58
 */
public class MaxSubArray_42 {
    public int maxSubArray(int[] nums) {
        // dp表示代表以元素 nums[i]nums[i] 为结尾的连续子数组最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(nums[i],nums[i]+dp[i-1]);
        }
        int max = 0;
        for(int i=1;i<dp.length;i++){
            if(dp[i]>dp[max]){
                max = i;
            }
        }
        return dp[max];
    }

    public static void main(String[] args) {
        int[] num = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaxSubArray_42().maxSubArray(num));
    }

}
