package com.SwordToOffer;

import java.util.PriorityQueue;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *  
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetLeastNumbers_40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            minHeap.add(arr[i]);
        }
        int [] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = minHeap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int [] arr = {3,2,1};
        int [] arr2 = {0,1,2,1};
        GetLeastNumbers_40 getLeastNumbers_40 = new GetLeastNumbers_40();
        int [] res = getLeastNumbers_40.getLeastNumbers(arr2,2);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
