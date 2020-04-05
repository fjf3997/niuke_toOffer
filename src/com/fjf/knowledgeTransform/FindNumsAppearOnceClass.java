package com.fjf.knowledgeTransform;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */

public class FindNumsAppearOnceClass {
    /**
     * num1,num2分别为长度为1的数组。传出参数
     * 将num1[0],num2[0]设置为返回结果
     * 首先：位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。
     * 当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，最后剩下的就是落单的数，
     * 因为成对儿出现的都抵消了。
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i])){
                map.put(array[i],map.get(array[i])+1);
            }else {
                map.put(array[i],1);
            }
        }
        int num=1;
        for (Integer integer : map.keySet()) {
            if(map.get(integer)==1){
                if(num==1){
                    num1[0] = integer;
                    num++;
                }else {
                    num2[0] = integer;
                }
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("hh");
    }
}
