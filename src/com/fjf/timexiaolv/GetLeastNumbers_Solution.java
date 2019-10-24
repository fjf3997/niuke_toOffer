package com.fjf.timexiaolv;

import java.util.ArrayList;
import java.util.Arrays;

public class GetLeastNumbers_Solution {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k>input.length||input==null){
            return new ArrayList<Integer>();
        }
        Arrays.sort(input);
        ArrayList<Integer> array = new ArrayList<>();
        for(int i=0;i<k;i++){
            array.add(input[i]);
        }
        return array;
    }

    public static void main(String[] args) {
        int [] input={3,5,6,3,6,3,2,8,12};
        ArrayList<Integer> array = GetLeastNumbers_Solution(input,4);
        for(int i:array){
            System.out.println(i);
        }
    }
}
