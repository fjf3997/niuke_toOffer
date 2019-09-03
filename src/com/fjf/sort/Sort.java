package com.fjf.sort;

public class Sort {
    public static void quick_sort(int []array,int left, int right){
        if(left>right)
            return;
        int i = left;
        int j = right;
        int temp = array[left];
        while (i!=j){
            while(i<j&&array[j]>=temp){
                j--;
            }
            while(i<j&&array[i]<=temp)
                i++;
            if(i<j) {
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
            }

        }
        int t = array[left];
        array[left] = array[i];
        array[i] = t;
        quick_sort(array,left,i-1);
        quick_sort(array,j+1,right);
    }
}
