package com.leecode;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *  
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *。
 */
public class Merge_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] nums = new int[nums1.length];
        int l1=0,l2=0,i=0;
        for(;(l1<m)&&(l2<n);i++){
            if(nums1[l1]<nums2[l2]){
                nums[i]=nums1[l1];
                l1++;
            }else {
                nums[i]=nums2[l2];
                l2++;
            }
        }
        if(l1<m){
            while (l1<m){
                nums[i++]=nums1[l1++];
            }
        }else {
            while (l2<n){
                nums[i++]=nums2[l2++];
            }
        }
        for(int j=0;j<nums.length;j++){
            nums1[j]=nums[j];
        }
    }

    public static void main(String[] args) {
        int [] nums1 = {1,2,3,0,0,0};
        int [] nums2 = {2,5,6};
        new Merge_88().merge(nums1,3,nums2,3);
        for (int i : nums1) {
            System.out.print(i+"  ");

        }


    }
}
