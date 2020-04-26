package com.leecode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  提示：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TopKFrequent_347 {
    private class PairComparator implements Comparator<Pair<Integer, Integer>> {

        @Override
        public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2){
            if(p1.first != p2.first)
                return p1.first - p2.first;
            return p1.second - p2.second;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : nums) {
            if(!map.containsKey(i)){
                map.put(i,1);
            }else {
                map.replace(i,map.get(i)+1);
            }
        }
        PriorityQueue<Pair<Integer,Integer>> priorityQueue = new PriorityQueue<>(new PairComparator());
        for (Integer integer : map.keySet()) {
            if(priorityQueue.size()==k){
                Pair<Integer, Integer> peek = priorityQueue.peek();
                if(peek.first<map.get(integer)){
                    priorityQueue.poll();
                    priorityQueue.add(new Pair<>(map.get(integer),integer));
                }
            }else
                priorityQueue.add(new Pair<>(map.get(integer),integer));

        }
        int [] res = new int[k];
        int i=0;
        for (Pair<Integer, Integer> integerIntegerPair : priorityQueue) {
            res[i++]=integerIntegerPair.second;
        }
        return res;

    }

    public static void main(String[] args) {
        int [] arr = {1,1,1,2,2,3};
        int [] ret = new TopKFrequent_347().topKFrequent(arr,2);
        for (int i : ret) {
            System.out.println(i);

        }
    }
}
