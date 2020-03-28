package com.fjf.timexiaolv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
 */
public class PrintMinNumberClass {
    public String PrintMinNumber(int [] numbers) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0;i<numbers.length;i++){
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                String str1 = t1 + "" + t2;
                String str2 = t2 + "" + t1;
                return str1.compareTo(str2);
            }
        });
        String str = "";
        for (Integer integer : list) {
            str += integer;
        }
        return str.toString();



    }

}
