package com.fjf.timeAndSpaceBalance;

import java.util.ArrayList;
import java.util.List;

public class GetUglyNumberSolutionClass {
    public int GetUglyNumber_Solution(int index) {
        if(index < 7)
            return index;
        List<Integer> arr = new ArrayList<Integer>();
        int p2=0,p3=0,p5 = 0, newNum = 1;
        arr.add(newNum);
        while(arr.size()<index){
            newNum = getMin(arr.get(p2)*2,arr.get(p3)*3,arr.get(p5)*5);
            if(newNum == arr.get(p2)*2) p2++;
            if(newNum == arr.get(p3)*3) p3++;
            if(newNum == arr.get(p5)*5) p5++;
            arr.add(newNum);
        }
        return newNum;
    }
    private int getMin(int a,int b ,int c){
        return Math.min(Math.min(a,b),c);
    }

    public static void main(String[] args) {
        GetUglyNumberSolutionClass getUglyNumberSolutionClass = new GetUglyNumberSolutionClass();
        int i = getUglyNumberSolutionClass.GetUglyNumber_Solution(8);
        System.out.println(i);
    }
}
