package com.fjf.sort;

public class Sort {
    public static void quick_sort(int []array,int left, int right){
       /* //结束迭代
        if(left > right){
            return;
        }
        int i = left ;
        int j = right;

        int temp = a[left];//设置基准值，将最左端元素作为基准值

        while(i != j){
            //往左移位，直到大于temp
            while(i<j && a[j]>=temp){
                j--;
            }
            //往右移位，直到小于temp
            while(i<j && a[i]<=temp){
                i++;
            }
            if(i < j){
                //交换彼此的数据
                int tt = a[i];
                a[i] = a[j];
                a[j] = tt;
            }

        }

        //交换基位数据
        int kk = a[i];
        a[i] = temp;
        a[left] = kk;

        //下一次迭代
        quick_sort(a,left,i-1);//左半边
        quick_sort(a,j+1,right);//右半边*/
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
