package com.fjf.abstractModeling;

public class LastRemainingClass {
    public int LastRemaining_Solution(int n, int m) {
        boolean[] arr = new boolean[n];
        for(int i=0;i<n;i++){
            arr[i]=true;
        }
        int num=n;int p=0,current=0;
        while(num>0){
            if(current==m-1){
                arr[p]=false;
                p++;
            }

        }
        return 0;
    }
}
