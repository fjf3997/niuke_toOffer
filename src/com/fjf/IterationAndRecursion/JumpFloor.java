package com.fjf.IterationAndRecursion;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class JumpFloor {
    /**
     * 思路：跳n级台阶相当于n-1和n-2级台阶的和
     * 原因：n级台阶就相当于n-1级再跳一次一阶的和n-2级再跳一次2阶的
     * 利用递归解决
     * @param target
     * @return
     */
    public static int JumpFloor(int target) {
        if(target==0)
            return 0;
        if(target == 1)
            return 1;
        if(target ==2)
            return 2;
        if(target == 3)
            return 3;
        return JumpFloor(target-1) + JumpFloor(target -2);
    }

    /**
     * 通过迭代解决
     * @param target
     * @return
     */
    public static int JumpFloorIteration(int target){
        if(target <= 2)
            return target;
        int pre1 = 1;
        int pre2 = 2;
        for(int i=3;i<=target;i++){
            pre2 = pre1 + pre2;
            pre1 = pre2 - pre1;
        }

        return pre2;
    }
}
