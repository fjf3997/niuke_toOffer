package com.leecode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * 进阶：
 * 你能在线性时间复杂度内解决此题吗？
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
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSlidingWindow_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int [] ans = new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            if(i<k-1){
                addQueue(deque,nums[i]);
            }else {
                addQueue(deque,nums[i]);
                ans[i-k+1] = deque.peekFirst();
                if(deque.peekFirst()==nums[i-k+1])
                    deque.poll();
            }
        }

        return ans;
    }

    private void addQueue(Deque<Integer> deque, int num) {
        while (!deque.isEmpty()&&deque.peekLast()<num){
            deque.pollLast();
        }
        deque.offerLast(num);
    }

    public static void main(String[] args) {
        int [] arg = new int[]{9,10,9,-7,-4,-8,2,-6};
        System.out.println(new MaxSlidingWindow_239().maxSlidingWindow(arg,5));
    }

}
