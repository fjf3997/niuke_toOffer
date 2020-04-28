package com.leecode;

import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum3_216 {
    private List<List<Integer>> lists;
    public List<List<Integer>> combinationSum3(int k, int n) {
        lists = new LinkedList<>();
        if(k<=0||n<=0)
            return lists;
        generateCombinationSum3(k,1,n,new LinkedList());
        return lists;
    }
    private void generateCombinationSum3(int k,int start,int sum,LinkedList list){
        if(list.size()==k)
            if(sum==0)
                lists.add((List<Integer>) list.clone());
            else
                return;
        for(int i=start;i<=9;i++){
            list.addLast(i);
            generateCombinationSum3(k,i+1,sum-i,list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new CombinationSum3_216().combinationSum3(3, 9);
        for (List<Integer> list : lists) {
            System.out.println(list);

        }

    }
}
