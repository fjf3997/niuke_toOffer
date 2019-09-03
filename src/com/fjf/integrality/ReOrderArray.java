package com.fjf.integrality;

public class ReOrderArray {
    public static void reOrderArray(int [] array) {
        int length = array.length;
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
        }

    }
}
