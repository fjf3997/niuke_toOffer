package com.leecode;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 示例:
 * 输入:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 输出: 4
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximalSquare_221 {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if(row==0)
            return 0;
        int maxSide = 0;
        int col = matrix[0].length;
        int [][]dp = new int [row][col];
        for(int i=0;i<row;i++)
            for (int j=0;j<col;j++){
                if(matrix[i][j]=='1'){
                    if(i==0||j==0)
                        dp[i][j]=1;
                    else
                        dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                    maxSide = Math.max(maxSide,dp[i][j]);
                }

            }
        return maxSide*maxSide;
    }

    public static void main(String[] args) {
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'},
        };
        System.out.println(new MaximalSquare_221().maximalSquare(matrix));
    }
}
