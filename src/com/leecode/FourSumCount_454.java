package com.leecode;

import java.util.HashMap;

/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FourSumCount_454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : A) {
            for (int j : B) {
                int ab = i+j;
                if(map.containsKey(ab))
                    map.replace(ab,map.get(ab)+1);
                else
                    map.put(ab,1);
            }
        }
        for (int i : C) {
            for (int j : D) {
                int cd = -i-j;
                if(map.containsKey(cd))
                    res+=map.get(cd);

            }
        }
        return res;
    }

    public static void main(String[] args) {
        /**
         *  * A = [ 1, 2]
         *  * B = [-2,-1]
         *  * C = [-1, 2]
         *  * D = [ 0, 2]
         */
        int [] A = {1,2};
        int [] B = {-2,-1};
        int [] C = {-1,2};
        int [] D = {0,2};
        System.out.println(new FourSumCount_454().fourSumCount(A,B,C,D));
    }
}
