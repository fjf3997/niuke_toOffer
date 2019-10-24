package com.fjf.timexiaolv;

import java.util.Arrays;

public class FindGreatestSumOfSubArray {
    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array.length==0){
            return 0;
        }
        int sum=0;
        int len = array.length;
        int [] temp = new int[len];
        for(int i=0;i<len;i++){
            sum+=array[i];
            temp[i]=sum;
        }
        Arrays.sort(temp);
        return temp[len-1];
    }

    public static void main(String[] args) {
        int [] array = {1,-2,3,10,-4,7,2,-5};
        int max = FindGreatestSumOfSubArray(array);
        System.out.println(max);
    }

}
