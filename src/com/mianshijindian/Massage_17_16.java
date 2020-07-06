/*
 *  Copyright@2019 清云智通（北京）科技有限公司 保留所有权利
 */
package com.mianshijindian;

/**
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
 * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 * 注意：本题相对原题稍作改动
 * 示例 1：
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * 示例 2：
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 * 示例 3：
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author fanjf@tsingyun.net
 * @date 2020/7/6 10:04
 */
public class Massage_17_16 {
    public int massage(int[] nums) {
        // 动态规划
        // dp[i] 表示前i个预约请求中总预约最长时间
        if(nums.length==0){
            return 0;
        }
        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            if(i==1){
                dp[i] = Math.max(dp[i-1],nums[i]);
            }else {
                dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
            }
        }
        return dp[nums.length-1];

    }

    public static void main(String[] args) {
        int [] arr = new int[]{2,1,4,5,3,1,1,3};
        System.out.println(new Massage_17_16().massage(arr));
    }
}
