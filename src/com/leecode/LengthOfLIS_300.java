package com.leecode;

import java.util.Arrays;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLIS_300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n==0)
            return 0;
        int [] memo = new int [n];
        Arrays.fill(memo,1);
        for(int i=1;i<n;i++)
            for (int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    memo[i]=Math.max(memo[i],1+memo[j]);
                }
            }
        int res= 1;
        for(int i=1;i<n;i++)
            res = Math.max(res,memo[i]);
        return res;
    }

    public static void main(String[] args) {
        int [] arr = {10,9,2,5,3,7,101,18};
        System.out.println(new LengthOfLIS_300().lengthOfLIS(arr));
    }
}
