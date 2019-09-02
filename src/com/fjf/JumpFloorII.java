package com.fjf;

/**
 * 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……
 * 它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloorII {
    /**
     * 易知 f(n)=f(n-1)+f(n-2)+……f(1)
     * f(n-1)=f(n-2)+……f(1)
     * 两式相减得f(n)=2f(n-1)
     * 利用递归解决
     */
    public static int JumpFloorIIRecursion(int target) {
        if(target<=2)
            return target;

        return 2*JumpFloorIIRecursion(target-1);
    }
    public static int JumpFloorIteration(int target){
        int n =1;
        for(int i=2;i<=target;i++)
            n*=2;
        return n;
    }
    /**
     *
     * 本质上是斐波那契数列的变种，普通跳台阶是一步与两步，问题规模缩小到分成最后要跳到第 n 阶可以跳两次或者一次去求解，所以，在普通跳台阶，设置两个临时变量存下跳一次或者两次时，前面会有多少种可能的结果
     *
     * 这里用同一个套路来分析一下
     *
     * 若楼梯阶级 n = 3
     *
     * 跳 3 步到 3：没有剩下步数没跳的，只有这样一种跳法
     * 跳 2 步到 3：剩下的是第一步没跳，起始跳到第一步只有一种
     * 跳 1 步到 3：剩下的是第二步没跳，起始跳到第二步有两种
     * 求得，n = 3 时，有 4 种跳法
     *
     * 若楼梯阶级 n = 4
     *
     * 跳 4 步到 4：没有剩下步数没跳的，只有这样一种跳法
     * 跳 3 步到 4：剩下的是第一步没跳，起始跳到第一步只有一种
     * 跳 2 步到 4：剩下的是第二步没跳，起始跳到第二步只有两种
     * 跳 1 步到 4：剩下的是第三步没跳，起始跳到第三步有四种
     * 求得，n = 4 时，有 8 种跳法
     *
     * 若楼梯阶级 n = n
     *
     * 跳 x 步到 n 有几种的和
     * 迭代解决
     * @param target
     * @return
     */
    public static int JumpFloorII(int target) {
        if(target <= 2)
            return target;
        int [] array = new int[target+1];
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        for(int i=3;i<=target;i++){
            for(int j=i-1;j>=1;j--){
                array[i]+=array[j];
            }
            array[i]++;
        }
        return array[target];
    }
}
