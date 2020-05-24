package com.leecode;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMedianSortedArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = -1,right =-1;
        int aStart = 0,bStart = 0;
        int len = m+n;
        for(int i=0;i<=len/2;i++){
            left = right;
            if (aStart<m&&bStart>=n||nums1[aStart]<nums2[bStart]){
                right = nums1[aStart++];
            }else {
                right = nums2[bStart++];
            }
        }
        if(len%2==0){
            return (left+right)/2.0;
        }
        return right;
    }
}
