package com.leecode;

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 */
public class Intersection_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        Set<Integer> setRes = new TreeSet<>();
        for(int i=0;i<nums2.length;i++){
            if(set.contains(nums2[i]))
                setRes.add(nums2[i]);
        }
        int [] res = new int[setRes.size()];
        int i=0;
        for (Integer setRe : setRes) {
            res[i++]=setRe;
        }
        return res;

    }

    public static void main(String[] args) {
        int [] nums1 = {4,9,5};
        int [] nums2 = {9,4,9,8,4};
        int [] res = new Intersection_349().intersection(nums1,nums2);
        for (int re : res) {
            System.out.print(re+"  ");
        }
    }
}
