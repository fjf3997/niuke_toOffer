package com.SwordToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * 限制：
 * 1 <= target <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindContinuousSequence_57_2 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        for(int l = 1,r=1,sum=0;r<=target/2+1;r++){
            sum+=r;
            while(sum>target){
                sum -=l++;
            }
            if(sum==target){
                int [] temp = new int[r-l+1];
                for(int i=0;i<temp.length;i++){
                    temp[i] = l+i;
                }
                res.add(temp);
            }
        }
        int [][] ret = new int[res.size()][];
        for(int i=0;i<res.size();i++){
            ret[i] = res.get(i);
        }
        return ret;

    }

    public static void main(String[] args) {
        System.out.println(new FindContinuousSequence_57_2().findContinuousSequence(9));
    }
}
