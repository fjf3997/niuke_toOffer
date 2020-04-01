package com.fjf.knowledgeTransform;

/**
 * 统计一个数字在排序数组中出现的次数
 */
public class GetNumberOfKClass {
    /**
     * 因为data中都是整数，所以可以稍微变一下，不是搜索k的两个位置，而是搜索k-0.5和k+0.5
     * 这两个数应该插入的位置，然后相减即可。
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {
        return bitSearch(array,k+0.5)-bitSearch(array,k-0.5);

    }
    private int bitSearch(int []arr, double k){
        int s=0,e = arr.length-1;
        int mid = 0;
        while(s <= e){
            mid = (s+e)/2;
            if(arr[mid]<k){
                s = mid+1;
            }else {
                e = mid -1;
            }
        }
        return s;
    }
    public static void main(String[] args) {
        GetNumberOfKClass getNumberOfKClass = new GetNumberOfKClass();
        int i = getNumberOfKClass.GetNumberOfK(new int[]{1, 2, 3, 3,3, 4, 5,6}, 3);
        System.out.println(i);
    }
}
