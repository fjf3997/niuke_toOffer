package com.leecode;

import java.util.TreeSet;

/**
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContainsNearbyAlmostDuplicate_220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length <= 1)
            return false;
        if(k <= 0)
            return false;
        TreeSet<Long> record = new TreeSet<>();
        for(int i = 0 ; i < nums.length; i ++){
            if(record.floor((long)nums[i]+(long)t)!=null&&(record.floor((long)nums[i]+(long)t)>=((long)nums[i]-(long)t)))
                return true;
            record.add((long)nums[i]);
            if(record.size() == k + 1)
                record.remove((long)nums[i-k]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-2147483648, -2147483647};
        int k = 3;
        int t = 3;
        System.out.println(new ContainsNearbyAlmostDuplicate_220().containsNearbyAlmostDuplicate(nums,k,t));
    }
}
