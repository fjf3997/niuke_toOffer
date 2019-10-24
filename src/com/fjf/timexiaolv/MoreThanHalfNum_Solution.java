package com.fjf.timexiaolv;

import java.util.HashMap;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 */
public class MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer,Integer> map =  new HashMap();
        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i])){
                int value = map.get(array[i])+1;
                map.replace(array[i],value);
            }else{
                map.put(array[i],1);
            }

        }
        for(int key:map.keySet()){
            if(map.get(key)>(array.length/2)){
                return key;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MoreThanHalfNum_Solution more = new MoreThanHalfNum_Solution();
        int [] array = {1,2,3,2,2,2,5,4,2};
        int ret = more.MoreThanHalfNum_Solution(array);
        System.out.println(ret);
    }
}
