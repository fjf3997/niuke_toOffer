package com.SwordToOffer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinArray_11 {
    public int minArray(int[] numbers) {
        if(numbers.length==0){
            return -1;
        }
        int n = numbers.length-1;
        while(n>0&&numbers[n]==numbers[0])n--;
        int l =0,r = n;
        while(l<r){
            int mid = l+r+1>>>1;
            if(numbers[mid]>=numbers[0])l = mid;
            else{
                r = mid-1;
            }
        }
        if(l==n){
            return numbers[0];
        }
        return numbers[l+1];
    }

    public static void main(String[] args) {
        int [] arr = {4, 7, 7, 9, 10, 10, 10, 11, 13, 15, 16, 16, 17, 18, 1, 1, 2, 3, 4, 4};
        int [] arr2 = {4, 7, 7, 9, 10, 10, 10, 11, 13, 15, 16, 16, 17, 18};
        System.out.println(new MinArray_11().minArray(arr));
        System.out.println(new MinArray_11().minArray(arr2));
    }
}
