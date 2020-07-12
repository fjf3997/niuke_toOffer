package com.leecode;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class MinSubArrayLen_209 {
    public int minSubArrayLen2(int s, int[] nums){
        // 优化,时间复杂度为O(n)
        // 因为j不用回退,总的时间复杂度为O(2n)
        int i = 0;
        int j = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for(;i<nums.length;i++){
            while (j<nums.length&&sum<s){
                sum += nums[j];
                j++;
            }
            if(sum>=s){
                res = Math.min(res,j-i);
            }
            sum -= nums[i];
        }
        if(res==Integer.MAX_VALUE){
            res = 0;
        }
        return res;

    }
    public int minSubArrayLen(int s, int[] nums) {
        int l=0,r=-1;
        int sum=0;
        int res = nums.length+1;
        while (l<nums.length){
            if(r+1<nums.length&&sum<s){
                r++;
                sum=sum+nums[r];
            }else {
                sum=sum-nums[l];
                l++;
            }
            if(sum>=s)
                res = Math.min(res,r-l+1);
        }
        if(res==nums.length+1)
            return 0;
        return res;

    }

    public static void main(String[] args) {
        int [] nums = {2,3,1,2,4,3};
        System.out.println(new MinSubArrayLen_209().minSubArrayLen2(7,nums));
    }
}
