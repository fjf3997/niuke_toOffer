package com.leecode;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PermuteUnique_47 {
    private boolean[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        visited =new boolean[nums.length];
        if(nums.length==0){
            return res;
        }
        Arrays.sort(nums);
        generatePermuteUnique(nums,0,new LinkedList<Integer>(),res);
        return res;

    }

    private void generatePermuteUnique(int[] nums, int index, LinkedList<Integer> ints, List<List<Integer>> res) {
        if(index==nums.length){
            res.add((List<Integer>) ints.clone());
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                if(i>0&&nums[i]==nums[i-1]&&visited[i-1]==false){
                    continue;
                }
                ints.addLast(nums[i]);
                visited[i] = true;
                generatePermuteUnique(nums,index+1,ints,res);
                ints.removeLast();
                visited[i] = false;

            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermuteUnique_47().permuteUnique(new int[]{1,1,2}));
    }
}
