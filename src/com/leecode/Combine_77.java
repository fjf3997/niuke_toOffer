package com.leecode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Combine_77 {
    private List<List<Integer>> lists;
    public List<List<Integer>> combine(int n, int k) {
        lists = new LinkedList<>();
        if(n<=0||k<=0||n<k)
            return lists;
        LinkedList<Integer> p = new LinkedList<>();
        generateCombination(n,k,1,p);
        return lists;

    }

    private void generateCombination(int n, int k, int start, LinkedList<Integer> p) {
        if(p.size()==k){
            lists.add((List<Integer>) p.clone());
            return;
        }
        for(int i = start;i<=n;i++){
            p.addLast(i);
            generateCombination(n,k,i+1,p);
            p.removeLast();
        }
    }
}
