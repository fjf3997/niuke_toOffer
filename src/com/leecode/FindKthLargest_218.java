package com.leecode;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 */
public class FindKthLargest_218 {
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length-k;
        int l=0,r=nums.length-1;
        int p = partition(nums,l,r);
        while (p!=target){
            if(target<p){
                r=p-1;

            }else {
                l=p+1;
            }
            p=partition(nums,l,r);

        }
        return nums[p];

    }
    private int partition(int []nums,int l,int r){
        swap( nums, l , (int)(Math.random()*(r-l+1))+l );
        int v = nums[l];
        int j=l;// arr[l+1...j] < v ; arr[j+1...i) > v
        for(int i=l+1;i<=r;i++){
            if(nums[i]<v){
                j++;
                swap(nums,j,i);
            }

        }
        swap(nums,l,j);
        return j;

    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int [] nums = {3,2,1,5,6,4};
        System.out.println(new FindKthLargest_218().findKthLargest(nums,2));
    }
}
