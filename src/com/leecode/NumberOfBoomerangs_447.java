package com.leecode;

import java.util.HashMap;

/**
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 *
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 *
 * 示例:
 *
 * 输入:
 * [[0,0],[1,0],[2,0]]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-boomerangs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberOfBoomerangs_447 {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for(int i=0;i<points.length;i++){
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int j=0;j<points.length;j++){
                if(i!=j){
                    int dis = getDis(points[i],points[j]);
                    if(!map.containsKey(dis))
                        map.put(dis,1);
                    else
                        map.replace(dis,map.get(dis)+1);
                }
            }
            for (Integer integer : map.keySet()) {
                int temp = map.get(integer);
                res += temp*(temp-1);
            }
        }
        return res;
    }

    private int getDis(int[] point1, int[] point2) {
        return (point1[0]-point2[0])*(point1[0]-point2[0])+(point1[1]-point2[1])*(point1[1]-point2[1]);

    }

    public static void main(String[] args) {
        //[0,0],[1,0],[2,0]
        int [][] points = {{0,0},{1,0},{2,0}};
        System.out.println(new NumberOfBoomerangs_447().numberOfBoomerangs(points));
    }
}
