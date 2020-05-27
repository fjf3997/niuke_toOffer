package com.leecode;

/**
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 * 示例：
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * 提示：
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sums-divisible-by-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubarraysDivByK_974 {
    public int subarraysDivByK(int[] A, int K) {
        int count = 0;
        for(int i=0;i<A.length;i++){
            int sum = 0;
            for(int j = i;j<A.length;j++){
                sum+=A[j];
                if(sum%K==0){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int [] arr = {4,5,0,-2,-3,1};
        int [] arr2 = {0,-5};
        System.out.println(new SubarraysDivByK_974().subarraysDivByK(arr,5));
        System.out.println(new SubarraysDivByK_974().subarraysDivByK(arr2,10));
    }
}
