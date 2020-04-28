package com.leecode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum2_40 {
    private List<List<Integer>> lists;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        lists = new LinkedList<>();
        if(candidates.length==0)
            return lists;
        Arrays.sort(candidates);
        generateCombinationSum(candidates,0,target,new LinkedList());
        return lists;

    }
    private void generateCombinationSum(int []candidates,int start,int sum,LinkedList list){
        if(sum < 0)
            return;
        if(sum == 0){
            lists.add((List<Integer>) list.clone());
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i>start&&candidates[i]==candidates[i-1])
            {
                continue;
            }
            list.addLast(candidates[i]);
            generateCombinationSum(candidates,i+1,sum-candidates[i],list);
            list.removeLast();
        }

    }

    public static void main(String[] args) {
        int [] arr = {2,5,2,1,2};
        int [] arr2 = {10,1,2,7,6,1,5};
        List<List<Integer>> lists = new CombinationSum2_40().combinationSum2(arr2, 8);
        for (List<Integer> list : lists) {
            System.out.println(list);

        }
    }
}
