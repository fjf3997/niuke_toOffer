package com.SwordToOffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 提示：
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSlidingWindow_59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int [] res = new int[nums.length-k+1];
        int l =0,r = 0;
        Deque<Integer> deque = new LinkedList<>();
        while(r<nums.length){
            if(r<k-1){
                queueAdd(deque,nums[r++]);
            }else{
                queueAdd(deque,nums[r++]);
                res[l] = deque.peek();
                queueRemove(deque,nums[l++]);
            }
        }

        return res;
    }
    private void queueAdd(Deque<Integer> queue,int value){
        while(!queue.isEmpty()&&queue.peekLast()<value){
            queue.pollLast();
        }
        queue.add(value);
    }
    private void queueRemove(Deque<Integer> queue,int value){
        if(!queue.isEmpty()&&queue.peek()==value){
            queue.poll();
        }
    }

    public static void main(String[] args) {
        int [] arr = {1,3,-1,-3,5,3,6,7};
        int [] arr2 = {1,3,1,2,0,5};
        System.out.println(new MaxSlidingWindow_59_1().maxSlidingWindow(arr2,3));
    }
}
