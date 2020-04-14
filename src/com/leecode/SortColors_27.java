package com.leecode;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * 示例:
 *输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */
public class SortColors_27 {
    public void sortColors(int[] nums) {
        int zero= -1;
        int two = nums.length;
        for(int i=0;i<two;){
            if(nums[i]==1)
                i++;
            else if(nums[i]==0){
                zero++;
                swap(nums,zero,i);
                i++;
            }else {
                assert (nums[i]==2);
                two--;
                swap(nums,i,two);
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int [] nums = {2,0,2,1,1,0};
        new SortColors_27().sortColors(nums);
        for (int num : nums) {
            System.out.print(num+"  ");

        }
    }
}
