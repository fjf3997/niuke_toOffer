package com.leecode;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 示例:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinPathSum_64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m==0){
            return 0;
        }
        int n = grid[0].length;
        if(n==0){
            return 0;
        }
        int[][] dp = new int[2][n];
        // 使用滚动数组
        int now = 1;
        int old = now;
        dp[0][0] = grid[0][0];
        for(int i=0;i<m;i++){
            old = now;
            now = 1-now;
            for(int j=0;j<n;j++){
                if(i==0&&j>0){
                    dp[now][j] = dp[now][j-1] + grid[i][j];
                }
                if(j==0&&i>0){
                    dp[now][j] = dp[old][j] + grid[i][j];
                }
                if(i>0&&j>0){
                    dp[now][j] = Math.min(dp[now][j-1],dp[old][j]) + grid[i][j];
                }
            }
        }
        return dp[now][n-1];
       /* int row = grid.length;
        if(row==0) {
            return 0;
        }
        int col = grid[0].length;
        for(int i=col-1;i-1>=0;i--){
            grid[row-1][i-1]+=grid[row-1][i];
        }
        if(row==1) {
            return grid[0][0];
        }
        for(int i=row-2;i>=0;i--){
            grid[i][col-1]+=grid[i+1][col-1];
            for(int j=col-2;j>=0;j--){
                grid[i][j]+=Math.min(grid[i+1][j],grid[i][j+1]);
            }
        }
        return grid[0][0];*/
    }
    public int minPathSum2(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if(col==0){
            return 0;
        }
        for(int i=col-2;i>=0;i--){
            grid[row-1][i] += grid[row-1][i+1];
        }
        for(int i=row-2;i>=0;i--){
            grid[i][col-1] += grid[i+1][col-1];
            for(int j=col-2;j>=0;j--){
                grid[i][j] += Math.min(grid[i+1][j],grid[i][j+1]);
            }
        }
        return grid[0][0];
    }

    public static void main(String[] args) {
        int [][] arr={
            {1,3,1},
            {1,5,1},
            {4,2,1}
        };
        System.out.println(new MinPathSum_64().minPathSum2(arr));
    }
}
