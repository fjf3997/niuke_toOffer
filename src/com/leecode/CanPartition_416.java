package com.leecode;

import java.util.Arrays;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanPartition_416 {
    private int [][]memo;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2!=0)
            return false;
        memo = new int[n][sum/2+1];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
        return partition(nums,n-1,sum/2);

    }
    private boolean partition(int []nums,int index,int c){
        if(c==0)
            return true;
        if(c<0||index<0)
            return false;
        if(memo[index][c]!=-1){
            return memo[index][c]==1;
        }
        memo[index][c] = (partition(nums,index-1,c)||partition(nums,index-1,c-nums[index]))==true?1:0;
        return memo[index][c]==1;
    }

    public static void main(String[] args) {
        int [] arr = {1, 5, 11, 5};
        System.out.println(new CanPartition_416().canPartition(arr));
    }
}
