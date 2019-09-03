package com.fjf.integrality;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    public static void reOrderArray(int [] array) {
        int length = array.length;
        int k = 0;
        for(int i=0;i<length;i++){
            if(array[i]%2!=0){
                int j = i;
                while (j>k){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    j--;
                }
                k++;
            }

        }
        //使用两个数组存放奇偶数
       /* int length = array.length;
        int [] even = new int[length];
        int [] odd = new int[length];
        int even_length=0,odd_length=0;
        for(int i=0;i<length;i++){
            if(array[i]%2==0)
                even[even_length++] = array[i];
            else
                odd[odd_length++] = array[i];
        }
        for(int i=0;i<odd_length;i++){
            array[i] = odd[i];
        }
        for(int i=0,j=odd_length;i<even_length;i++,j++){
            array[j] = even[i];
        }*/

    }
}
