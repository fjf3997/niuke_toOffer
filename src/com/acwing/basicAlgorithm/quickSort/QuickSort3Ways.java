package com.acwing.basicAlgorithm.quickSort;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class QuickSort3Ways {
    public static void main(String[] args) {
        Scanner sc =new Scanner(new BufferedInputStream(System.in));
        int num = sc.nextInt();
        int [] arr = new int[num];
        for(int i=0;i<num;i++){
            arr[i] = sc.nextInt();
        }
        sort3Ways(arr,0,num-1);
        for(int i=0;i<num;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void sort3Ways(int[] arr, int l, int r) {
        if(l>=r){
            return;
        }
        swap(arr,l,(int)(Math.random()*(r-l+1))+l);
        int compare = arr[l];
        // arr[l+1...lt] < v | arr[gt...r] > v | arr[lt+1...i) == v
        int lt = l,i = lt+1,gt = r+1;
        while(i<gt){
            if(arr[i]>compare){
                swap(arr,i,--gt);
            }else if(arr[i]<compare){
                swap(arr,i,++lt);
                i++;
            }else{
                i++;
            }
        }
        swap(arr,l,lt);
        sort3Ways(arr,l,lt);
        sort3Ways(arr,gt,r);

    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[r];
        arr[r] = arr[l];
        arr[l] = temp;
    }

}


class CASE1 {
    /*
    30 30
179 21 70 5 22 192 278 61 156 177 126 160 215 236 62 12 270 58 89 4 113 99 130 185 296 47 173 289 244 300
     */
    public static void main(String[] args) {
        Scanner sc =new Scanner(new BufferedInputStream(System.in));
        int num = sc.nextInt();
        int k = sc.nextInt();
        int [] arr = new int[num];
        for(int i=0;i<num;i++){
            arr[i] = sc.nextInt();
        }
        for(int i=0;i<num;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        sort3Ways(arr,0,num-1,k-1);
    }

    private static void sort3Ways(int[] arr, int l, int r,int k) {
        if(l>r){
            return;
        }
        int p = partition(arr,l,r);
        if(p==k){
            System.out.println(arr[p]);
            return;
        }
        if(p<k){
            sort3Ways(arr,p+1,r,k);
        } else{
            sort3Ways(arr,l,p-1,k);
        }


    }
    private static int partition(int []arr,int l,int r){
        swap(arr,l,(int)(Math.random()*(r-l+1))+l);
        int compare = arr[l];
        // arr[l+1,i)<=compare
        // arr(j,r]>=compare
        int i = l+1,j=r;
        while(true){
            while(i<=r&&arr[i]<compare){
                i++;
            }
            while(j>=l+1&&arr[j]>compare){
                j--;
            }
            if(i>j){
                break;
            }
            swap(arr,i,j);
            i++;j--;
        }
        swap(arr,l,j);
        return j;
    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[r];
        arr[r] = arr[l];
        arr[l] = temp;
    }

}

