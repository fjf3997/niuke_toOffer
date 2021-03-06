package com.leecode;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 说明：m 和 n 的值均不超过 100。
 * 示例 1:
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class UniquePathsWithObstacles_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m==0){
            return 0;
        }
        int n = obstacleGrid[0].length;
        if(n==0){
            return 0;
        }
        // 状态
        int [][] dp = new int[m][n];
        // 状态转移
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j] = 0;
                    continue;
                }
                if(i==0&&j==0){
                    dp[i][j] = 1;
                    continue;
                }
                if(j>0){
                    dp[i][j] += dp[i][j-1];
                }
                if(i>0){
                    dp[i][j] += dp[i-1][j];
                }

            }
        }
        return dp[m-1][n-1];
    }
    private int[][] memo;
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if(row==0||col==0){
            return 0;
        }
        memo = new int[row][col];
        recursion(obstacleGrid,row-1,col-1);
        return memo[row-1][col-1];
    }

    private int recursion(int[][] obstacleGrid, int row, int col) {
        if(row==0&&col==0){
            memo[row][col] = obstacleGrid[row][col]==0?1:0;
        }
        if(obstacleGrid[row][col]==1){
            memo[row][col]=0;
            return memo[row][col];
        }
        if(memo[row][col]!=0){
            return memo[row][col];
        }
        if(row==0){
            memo[row][col] = recursion(obstacleGrid,row,col-1);
            return memo[row][col];
        }
        if(col==0){
            memo[row][col] = recursion(obstacleGrid,row-1,col);
            return memo[row][col];
        }
        memo[row][col] = recursion(obstacleGrid,row-1,col)+recursion(obstacleGrid,row,col-1);
        return memo[row][col];

    }

    public static void main(String[] args) {
        int [][] arr = new int[][]{
            {1,0,0},
            {0,1,0},
            {0,0,0}
        };
        int [][] arr2 = new int[][]{
                {0,1}
        };
        System.out.println(new UniquePathsWithObstacles_63().uniquePathsWithObstacles2(arr2));

    }
}
