package com.leecode;

import java.util.Arrays;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class
Rob_198 {
    private int [] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length+1];
        int n = nums.length;
        if(n<=0){
            return 0;
        }
        Arrays.fill(memo,-1);
        // 记忆化搜索
       /* return startRob(nums,0);*/
        //从后往前
       /* memo[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            for(int j=i;j<n;j++){
                memo[i]=Math.max(memo[i],nums[j]+(j+2<n?memo[j+2]:0));
            }
        }
        return memo[0];*/
        // 从前往后
        memo[0] = 0;
        memo[1] = nums[0];
        for(int i = 2; i <= n;i++){
            memo[i] = Math.max(memo[i-1],memo[i-2]+nums[i]);
        }
        return memo[n];

    }
    private int startRob(int []nums,int index){
        if(index>=nums.length){
            return 0;
        }
        if(memo[index]!=-1){
            return memo[index];
        }
        int res=-1;
        for(int i=index;i<nums.length;i++){
            res=Math.max(res,nums[i]+startRob(nums,i+2));
        }
        memo[index]=res;
        return res;
    }
    private int []memo2;
    public int rob2(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        memo2 = new int[nums.length];
        Arrays.fill(memo2,-1);
        // memo2[i]表示准备偷取[i,nums.length)的房子
        recursion(nums,0);
        return memo2[0];
    }

    private int recursion(int[] nums, int index) {
        if(index>=nums.length){
            return 0;
        }
        if(memo2[index]!=-1){
            return memo2[index];
        }
        int res = 0;
        for(int j=index;j<nums.length;j++){
            res = Math.max(res,nums[j]+recursion(nums,j+2));
        }
        memo2[index] = res;
        return res;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,1};
        int [] arr2 = {2,7,9,3,1};
        System.out.println(new Rob_198().rob2(arr2));
//        System.out.println(new Rob_198().rob(arr2));
    }
}
