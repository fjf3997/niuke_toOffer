package com.SwordToOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumArrange {
    private List<List<Integer>> res;
    private Integer [] path;
    public List<List<Integer>> permutation(int[] nums) {
        res = new ArrayList<>();
        path = new Integer[nums.length];
        // y总思路
        //先排序
        Arrays.sort(nums);
        // 数组，已经放好位置的数字个数， 前一个数字的索引位置start，用一个int类型表示排好的位置，0表示没有，1表示有数字
        dfs(nums,0,0,0);
        return res;
    }
    private void dfs(int[]nums,int a,int start,int state){
        // 个数等于数组的长度，说明排好序了
        if(a==nums.length){
            res.add(new ArrayList<>(Arrays.asList(path)));
            return;
        }
        // 当前的数组与前一个数组不等，start从0开始即可
        if(a==0||nums[a]!=nums[a-1]){
            start = 0;
        }
        for(int i=start;i<nums.length;i++){
            // i位置上已经有数字了
            if(((state>>>i)&1)==1){
                continue;
            }
            path[i] = nums[a];
            dfs(nums,a+1,i+1,state+(1<<i));
        }

    }

    public static void main(String[] args) {
        int [] arr = {1,2,3};
        int [] arr2 = {1,1,2};
        NumArrange numArrange = new NumArrange();
        List<List<Integer>> permutation = numArrange.permutation(arr2);
        for (List<Integer> integers : permutation) {
            for (Integer integer : integers) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }


    }
}
