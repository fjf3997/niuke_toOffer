package com.leecode;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *  
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 通过次数985,585提交次数2,046,613
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int index = 0;
        for (int num : nums) {
            int temp = target - nums[index];
            if(!map.containsKey(temp))
                map.put(num,index++);
            else {
                return new int[]{map.get(temp),index--};
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int [] nums = {2, 7, 11, 15};
        int res [] = new TwoSum_1().twoSum(nums,18);
        for (int re : res) {
            System.out.print(re+" ");

        }
    }
}
