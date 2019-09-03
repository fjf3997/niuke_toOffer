package com.fjf.bit_operation;

public class NumberOf1 {
    public static int NumberOf1(int n) {
        String n_str = Integer.toBinaryString(n);
        int length = n_str.length();
        int count =0;
        int index=0;
        while(index<=length-1){
            int r_index = n_str.indexOf('1',index);
            if(r_index<0) {
                index++;
                continue;
            }
            index = r_index+1;
            count++;
        }
        return count;
        //以下可行
       /* int count = 0;
        while(n!=0){
            count+=n&1;
            n>>>=1;
        }
        return count;*/
        //以下只能求正数
        /*int count = 0;
        if(n>0) {
            while (n > 0) {
                n &= (n - 1);
                count++;
            }
        }
        if(n<0){

        }
        return count;*/
    }
}
