package com.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 */
public class IntersectClass {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums1) {
            if(!map.containsKey(i))
                map.put(i,1);
            else{
                map.replace(i,map.get(i),map.get(i)+1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if(map.containsKey(i)&&map.get(i)>0){
                list.add(i);
                map.replace(i,map.get(i),map.get(i)-1);
            }
        }
        int [] res = new int[list.size()];
        int index=0;
        for (Integer integer : list) {
            res[index++]=integer;

        }

        return res;

    }

    public static void main(String[] args) {
        int [] nums1 = {4,9,5};
        int [] nums2 = {9,4,9,8,4};
        int [] res = new IntersectClass().intersect(nums1,nums2);
        for (int re : res) {
            System.out.print(re+"  ");
        }
    }
}
