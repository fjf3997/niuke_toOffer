package com.SwordToOffer;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 * 限制：
 * 0 <= 数组长度 <= 50000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReversePairs_51 {
    private int num = 0;
    public int reversePairs(int[] nums) {
        // 归并排序思想
        mergeSort(nums,0,nums.length-1);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        return num;
    }

    // [l,r]归并排序
    private void mergeSort(int[] nums, int l, int r) {
        if(l>=r){
            return;
        }
        int mid = (l+r)/2;
        mergeSort(nums,l,mid);
        mergeSort(nums,mid+1,r);
        merge(nums,l,mid,r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int i = l,j = mid+1,k=0;
        int [] temp = new int[r-l+1];
        while(i<=mid&&j<=r){
            if(nums[i]<=nums[j]){
                temp[k++] = nums[i++];
            }else {
                num += mid-i+1;
                temp[k++] = nums[j++];
            }
        }
        while (i<=mid){
            temp[k++] = nums[i++];
        }
        while (j<=r){
            temp[k++] = nums[j++];
        }
        for(int m=0;m<temp.length;m++){
            nums[l+m] = temp[m];
        }
    }

    public static void main(String[] args) {
        System.out.println(new ReversePairs_51().reversePairs(new int[]{7,5,6,4}));
    }
}
