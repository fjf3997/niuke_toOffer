package com.leecode;

/**
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度。
 * 示例 1:
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * 示例 2:
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindLengthOfLCIS_674 {
    public int findLengthOfLCIS(int[] nums) {
        // 动态规划
        // 状态
        if(nums.length<=1){
            return nums.length;
        }
        int [] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                dp[i] = 1+dp[i-1];
            }else {
                dp[i] = 1;
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{1,3,5,4,7};
        int [] arr2 = new int[]{2,2,2,2,2};
        System.out.println(new FindLengthOfLCIS_674().findLengthOfLCIS(arr));
        System.out.println(new FindLengthOfLCIS_674().findLengthOfLCIS(arr2));
    }
}
