package com.test;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int[] newArr = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            newArr[i] = arr[i];
        }
        Arrays.sort(arr);
        int mid1 = arr[arr.length/2-1];
        int mid2 = arr[arr.length/2];
        for(int i=0;i<newArr.length;i++){
            if(newArr[i]<mid2){
                System.out.println(mid2);
            }else {
                System.out.println(mid1);
            }
        }


    }
}