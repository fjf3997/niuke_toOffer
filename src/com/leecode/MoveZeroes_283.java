package com.leecode;

import java.util.Vector;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 *  输入: [0,1,0,3,12]
 *  输出: [1,3,12,0,0]
 *  说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class MoveZeroes_283 {
    /*
    时间复杂度: O(n)
    空间复杂度: O(n)
     */
    public void moveZeroes(int[] nums) {
        Vector<Integer> vector = new Vector<>(nums.length);
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0)
                vector.add(nums[i]);

        }
        for(int i=0;i<vector.size();i++){
            nums[i]=vector.get(i);
        }
        for(int i=vector.size();i<nums.length;i++){
            nums[i]=0;
        }

    }
    /*
    时间复杂度: O(n)
    空间复杂度: O(1)
     */
    public void moveZeroes2(int[] nums) {
        /*int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0)
                swap(nums,k++,i);
        }*/
        int k = 0; // nums中, [0...k)的元素均为非0元素

        // 遍历到第i个元素后,保证[0...i]中所有非0元素
        // 都按照顺序排列在[0...k)中
        // 同时, [k...i] 为 0
        for(int i = 0 ; i < nums.length ; i ++)
            if(nums[i] != 0)
                if(k != i)
                    swap(nums, k++, i);
                else
                    k ++;
    }
    private void swap(int []nums,int i,int j){
        int t=nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int [] nums = {0,1,0,3,12};
        new MoveZeroes_283().moveZeroes2(nums);
        for (int num : nums) {
            System.out.print(num+"  ");

        }
    }
}
