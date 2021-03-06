package com.leecode;


/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 示例:
 * 给定 nums = [3,2,2,3], val = 3,
 *
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 */
public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        int k=0;// nums中, [0...k)的元素均为非val元素
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                if(k!=i)
                    swap(nums,k++,i);
                else
                    k++;
            }
        }

        return k;

    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int [] nums  = {0,1,2,2,3,0,4,2};
        System.out.println(new RemoveElement_27().removeElement(nums,2));
        for (int num : nums) {
            System.out.print(num+"  ");

        }
    }
}
