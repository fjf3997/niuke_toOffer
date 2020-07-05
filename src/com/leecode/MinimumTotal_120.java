package com.leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumTotal_120 {
    private int row;
    private List<List<Integer>> lists;
    private int count=0;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        this.row = n;
        this.lists = triangle;
        /*for(int i=n-2;i>=0;i--){
            for(int j=0;j<=triangle.get(i).size()-1;j++){
                triangle.get(i).set(j,triangle.get(i).get(j)+Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);*/
        // 递归
        return recursion(0,0);
    }
    private int recursion(int level,int index){
        count++;
        if(level == row-1){
            return lists.get(level).get(index);
        }
        return lists.get(level).get(index)+Math.min(recursion(level+1,index),recursion(level+1,index+1));
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        list1.add(2);
        list2.add(3);
        list2.add(4);
        list3.add(6);
        list3.add(5);
        list3.add(7);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        MinimumTotal_120 min = new MinimumTotal_120();
        System.out.println(min.minimumTotal(lists));
        System.out.println(min.count);


    }
}
