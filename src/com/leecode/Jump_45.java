package com.leecode;

import java.util.Arrays;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Jump_45 {
    public int jump2(int[] nums) {
        /*
        题目说明：假设你总是可以到达数组的最后一个位置。
        即一定存在一条路线能够到达最后一个位置，而不是说中间没有 0 ，只是存在可以越过 0 的路线
        贪心算法：找能跳的最远的
        使用 k 记录目前能够跳到的最高位置
        使用 end 记录这次跳跃的边界，到达边界就跳跃次数 + 1
        过程解析：
        最开始遍历 i = 0, end = 0,因此 step 会进行 step ++，我们可以认为，这是开始起跳，因为必定会落下，因此跳跃次数 + 1
        而 nums[0] 这个数限制了你只能在落脚在某个范围内，假如 nums[0] = 4，那么你只能选择落脚在 [1, 4] 位置，而如果到了边界，那么肯定是一次新的起跳，因此次数需要再 + 1
        从 0 位置开始起跳，你落脚的必定是 [1, 4] 位置中能够跳得更远的，因为根据贪心思想，这样做能够尽可能的减少跳跃次数，因为更加接近最后一个位置
        而在这个过程遍历 [1, 4] 过程中一直记录着最远位置 k，而你落地在 [1, 4] 之间，落地的那个点也就是 [1, 4] 之间最能够跳得远的那个位置，因此当到达边界的时候，将 end 更新为 k
        注意：[1, 4] 跳得最远的位置必定不会在 [1, 4] ，因为如果在 [1, 4] ，那么表示根本就出不去 [1, 4] 这个圈
        当然不会是 [4,1,1,1,0,1,2] 这种的，因为如果是这种的，压根过不去这个 0，因此必定第一次起跳必定能够跳出 [1, 4] 这个范围，比如 [4,1,1,1,1,1,0]
        */
        int k = 0;
        //记录跳跃的次数
        int step = 0;
        int end = 0;
        //这里有个小细节，因为是起跳的时候就 + 1 了，如果最后一次跳跃刚好到达了最后一个位置，那么遍历到最后一个位置的时候就会再次起跳，这是不允许的，因此不能遍历最后一个位置
        for(int i = 0; i < nums.length - 1; i++){
            //一定跳得到，因此不存在 k < i

            k = Math.max(k, i + nums[i]);
            //第一次起跳 或 到达跳跃的边界
            if(i == end){
                //再次起跳
                step++;
                //更新边界
                end = k;
            }
        }

        return step;
    }
    private int [] memo;
    public int jump(int[] nums) {
        if(nums.length==1)
            return 0;
        memo = new int[nums.length];
        Arrays.fill(memo,Integer.MAX_VALUE);
        return startJump(nums,0,0);
    }

    private int startJump(int[] nums, int index, int num) {
        if(nums[index]>=nums.length-index-1)
            return num+1;
        if(index==nums.length-1)
            return num;
        if(memo[index]!=Integer.MAX_VALUE&&num+1>=memo[index])
            return memo[index];
        for(int i=1;i<=nums[index];i++){
            if(index+i>=nums.length)
                return Integer.MAX_VALUE;
            memo[index] = Math.min(memo[index],startJump(nums,index+i,num+1));
        }
        return memo[index];
    }

    public static void main(String[] args) {
        int [] arr = {2,3,1,1,4};
        int [] arr2 = {5,3,1,1,4};
        int [] arr3 = {2,1,1,1,1};
        System.out.println(new Jump_45().jump(arr3));
    }
}
