package com.fjf.knowledgeTransform;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class FindNumbersWithSumClass {
    /**
     * 数列满足递增，设两个头尾两个指针i和j，
     * 若ai + aj == sum，就是答案（相差越远乘积越小）
     * 若ai + aj > sum，aj肯定不是答案之一（前面已得出 i 前面的数已是不可能），j -= 1
     * 若ai + aj < sum，ai肯定不是答案之一（前面已得出 j 后面的数已是不可能），i += 1
     * O(n)
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int i=0,j=array.length-1;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (i<j){
            if(array[i]+array[j]==sum){
                arrayList.add(array[i]);
                arrayList.add(array[j]);
                break;
            }
            while (i<j&&(array[i]+array[j]<sum))++i;
            while (i<j&&(array[i]+array[j]>sum))--j;
        }

        return arrayList;

    }
}
