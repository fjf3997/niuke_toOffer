package com.SwordToOffer;

/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 * 示例 1：
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 * 输入：n = 11
 * 输出：0
 * 限制：
 * 0 <= n < 2^31
 * 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindNthDigit_44 {
    public int findNthDigit(int n) {
        if(n<0)
            return -1;
        int digits = 1;
        while (true){
            int numbers = numbersOfNum(digits);
            if(n<numbers*digits){
                return indexInDigist(n,digits);
            }
            n -= numbers*digits;
            digits++;

        }
    }

    private int indexInDigist(int n, int digits) {
        long number = beginDigits(digits) + n/digits;
        int indexFromRight = digits - n%digits;
        for(int i=1;i<indexFromRight;i++){
            number/=10;
        }
        return (int)number%10;
    }

    private long beginDigits(int digits) {
        if(digits==1)
            return 0;
        return (long) Math.pow(10,digits-1);
    }

    private int numbersOfNum(int digits) {
        if(digits==1)
            return 10;
        int count = (int) Math.pow(10,digits-1);
        return 9*count;
    }

    public static void main(String[] args) {
        System.out.println(new FindNthDigit_44().findNthDigit(1000000000));
    }
}
