package com.leecode;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * 示例 1 :
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubarraySum_560 {
    public int subarraySum(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int count = 0;
        int temp = nums[0];
        while (i<nums.length&&j<nums.length){
            if(temp==k){
                count++;
                temp-=nums[i];
                i++;
            }else if(temp<k){
                j++;
                if(j>=nums.length)
                    break;
                temp+=nums[j];
            }else if(temp>k){
                temp-=nums[i];
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int [] nums ={1,1,1,1,1,1,1,1};
        int k = 2;
        int [] nums2 = {1};
        int k2 = 0;

        System.out.println(new SubarraySum_560().subarraySum(nums2,k2));
        System.out.println(new SubarraySum_560().subarraySum(nums,k));
    }
}
