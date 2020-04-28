package com.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permute_46 {
    private List<List<Integer>> lists;
    private boolean [] visited;
    public List<List<Integer>> permute(int[] nums) {
        lists = new ArrayList<>();
        visited = new boolean[nums.length];
        generatePermute(nums,0,new LinkedList<>());
        return lists;

    }
    private void generatePermute(int [] nums, int index, LinkedList<Integer> list){
        if(index==nums.length){
            lists.add((List<Integer>) list.clone());
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                visited[i]=true;
                list.addLast(nums[i]);
                generatePermute(nums,index+1,list);
                list.removeLast();
                visited[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3};
        List<List<Integer>> lists = new Permute_46().permute(arr);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
        System.out.println("hello");
    }
}
