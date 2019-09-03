package com.fjf.IterationAndRecursion;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，
 * 总共有多少种方法？
 */
public class RectCover {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/72a5a919508a4251859fb2cfb987a0e6?answerType=1&f=discussion
     * 来源：牛客网
     *
     * n = 1 的时候
     * 只能横着覆盖，一种
     * n = 2 的时候
     * 可以横着和竖着覆盖，两种
     * n = 3 的时候
     * 第三级横着覆盖，用了一级，剩下 n = 2，有两种覆盖方法
     * 第三季竖着覆盖，用了两级，剩下 n = 1，有一种覆盖方法
     * 总共有 3 种
     * n = 4 的时候
     * 第 4 级横着覆盖，用了一级，剩下 n = 3，有三种覆盖方法
     * 第 4 级竖着覆盖，用了两级，剩下 n = 2，有两种覆盖方法
     * 总共有 5 种方法
     * n = n 的时候
     * 第 n 级横着覆盖，用了一级，剩下 n = n - 1，所以关注第 n - 1 种有几种覆盖方法
     * 第 n 级竖着覆盖，用了两级，剩下 n = n - 2，所以关注第 n - 2 种有几种覆盖方法
     * 总和为两种情况的总和
     * 递归实现
     * @param target
     * @return
     */
    public static int RectCover(int target) {
        if(target<=2)
            return target;
        return RectCover(target-1)+RectCover(target-2);
    }
    public static int RectCoverIteration(int target) {
        if(target<=2)
            return target;
        int pre1 = 1;
        int pre2 = 2;
        for(int i=3;i<=target;i++){
            pre2 = pre1+pre2;
            pre1 = pre2-pre1;
        }
        return pre2;
    }
}
