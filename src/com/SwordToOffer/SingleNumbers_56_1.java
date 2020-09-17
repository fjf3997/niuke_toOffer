package com.SwordToOffer;

import java.util.HashSet;

public class SingleNumbers_56_1 {
    public int[] singleNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }
        int i = 0;
        int [] res = new int[2];
        for (Integer integer : set) {
            res[i++] = integer;
        }
        return res;
    }
}
