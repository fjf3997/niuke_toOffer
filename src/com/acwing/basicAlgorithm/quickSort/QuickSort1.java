package com.acwing.basicAlgorithm.quickSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

//        int num = Integer.parseInt(br.readLine());

        String[] res = br.readLine().split(" ");
        int num = res.length;
        int[] arr = new int[num];
        System.out.println(num);
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(res[i]);
        }

        quickSort(arr, 0, num - 1);

        for (int i = 0; i < num; i++) {
            System.out.print(arr[i] + " ");
        }
        br.close();

    }
    private static void quickSort(int[] arr,int l,int r){
        if(l>=r){
            return;
        }
        int p = partition(arr,l,r);
        quickSort(arr,l,p-1);
        quickSort(arr,p+1,r);
    }
    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(int []arr,int l,int r){
        // arr[l+1...j] < v ; arr[j+1...i) > v
        // 使用随机数作为比较数，避免快速排序退化位O(n^2)
        swap(arr,l,(int)(Math.random()*(r-l+1))+l);
        int compare = arr[l];
        int j = l;
        for(int i=l+1;i<=r;i++){
            if(arr[i]<compare){
                swap(arr,i,j+1);
                j++;
            }
        }
        swap(arr,l,j);
        return j;
    }
    private static void swap(int[]arr,int a,int b){
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }
}
