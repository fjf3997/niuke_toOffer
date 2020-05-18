package com.leecode;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProduct_152 {
    //https://leetcode-cn.com/problems/maximum-product-subarray/solution/cheng-ji-zui-da-zi-shu-zu-by-leetcode-solution/
    public int maxProduct(int[] nums) {
        int imax = nums[0],imin=nums[0],res = nums[0];
        for(int i =1;i<nums.length;i++){
            int min = imin;
            int max = imax;
            imax = max3(max*nums[i],min*nums[i],nums[i]);
            imin = min3(max*nums[i],min*nums[i],nums[i]);
            res = Math.max(imax,res);
        }
        return res;
    }
    private int max3(int a,int b,int c){
        return Math.max(a,Math.max(b,c));
    }
    private int min3(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }

}
