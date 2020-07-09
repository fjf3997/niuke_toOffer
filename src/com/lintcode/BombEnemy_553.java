/*
 *  Copyright@2019 清云智通（北京）科技有限公司 保留所有权利
 */
package com.lintcode;


/**
 * 给定一个二维矩阵, 每一个格子可能是一堵墙 W,或者 一个敌人 E 或者空 0 (数字 '0'),
 * 返回你可以用一个炸弹杀死的最大敌人数. 炸弹会杀死所有在同一行和同一列没有墙阻隔的敌人。 由于墙比较坚固，所以墙不会被摧毁.
 * Example
 * 样例1
 *
 * 输入:
 * grid =[
 *      '0E00',
 *      'E0WE',
 *      '0E00'
 * ]
 * 输出: 3
 * 解释:
 * 把炸弹放在 (1,1) 能杀3个敌人
 * 样例2
 * 输入:
 * grid =[
 *      '0E00',
 *      'EEWE',
 *      '0E00'
 * ]
 * 输出: 2
 * 解释:
 * P把炸弹放在 (0,0) 或 (0,3) 或 (2,0) 或 (2,3) 能杀2个敌人
 * Notice
 * 你只能在空的地方放置炸弹.
 * @author fanjf@tsingyun.net
 * @date 2020/7/9 10:33
 */
public class BombEnemy_553 {
    /**
     * @param grid: Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return: an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid) {
        // write your code here
        // 动态规划
        int m = grid.length;
        if(m==0){
            return 0;
        }
        int n = grid[0].length;
        if(n==0){
            return 0;
        }
        // 状态
        int [][] up = new int[m][n];
        int [][] down = new int[m][n];
        int [][] left = new int[m][n];
        int [][] right = new int[m][n];
        // up和left的状态转移
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(i==0){
                    if(grid[i][j]=='E'){
                        up[i][j] = 1;
                    }else {
                        up[i][j] = 0;
                    }
                    continue;
                }
                if(grid[i][j]=='E'){
                    up[i][j] = up[i-1][j]+1;
                }
                if(grid[i][j] == '0'){
                    up[i][j] = up[i-1][j];
                }
                if(grid[i][j]=='W'){
                    up[i][j] = 0;
                }
            }
        }
        for(int j=0;j<n;j++){
            for (int i=0;i<m;i++){
                if(j==0){
                    if(grid[i][j]=='E'){
                        left[i][j] = 1;
                    }else {
                        left[i][j] = 0;
                    }
                    continue;
                }
                if(grid[i][j]=='E'){
                    left[i][j] = left[i][j-1]+1;
                }
                if(grid[i][j] == '0'){
                    left[i][j] = left[i][j-1];
                }
                if(grid[i][j]=='W'){
                    left[i][j] = 0;
                }
            }
        }
        for(int i=m-1;i>=0;i--){
            for(int j=0;j<n;j++){
                if(i==m-1){
                    if(grid[i][j]=='E'){
                        down[i][j] = 1;
                    }else {
                        down[i][j] = 0;
                    }
                    continue;
                }
                if(grid[i][j]=='E'){
                    down[i][j] = down[i+1][j]+1;
                }
                if(grid[i][j] == '0'){
                    down[i][j] = down[i+1][j];
                }
                if(grid[i][j]=='W'){
                    down[i][j] = 0;
                }

            }
        }
        for(int j=n-1;j>=0;j--){
            for (int i=0;i<m;i++){
                if(j==n-1){
                    if(grid[i][j]=='E'){
                        right[i][j] = 1;
                    }else {
                        right[i][j] = 0;
                    }
                    continue;
                }
                if(grid[i][j]=='E'){
                    right[i][j] = right[i][j+1]+1;
                }
                if(grid[i][j] == '0'){
                    right[i][j] = right[i][j+1];
                }
                if(grid[i][j]=='W'){
                    right[i][j] = 0;
                }
            }
        }
        int max = 0;
        if(m==1){
            for(int i=0;i<n;i++){
                if(grid[0][i]=='0'){
                    max = Math.max(max,left[0][i]+right[0][i]);
                }
            }
            return max;
        }
        if(n==1){
            for(int i=0;i<m;i++){
                if(grid[i][0]=='0')
                    max = Math.max(max,up[i][0]+down[i][0]);
            }
            return max;
        }
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(grid[i][j]=='0'){
                    max = Math.max(max,up[i][j]+left[i][j]+down[i][j]+right[i][j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        char [][] arr = new char[][]{
                {'0','E','0','0'},
                {'E','0','W','E'},
                {'0','E','0','0'}
        };
       /* char[][] arr2 = new String[]{
                '0E00','E0WE','0E00'
        };*/
        char [][] arr2 = new char[][]{{'E'}};
        char [][] arr3 = new char[][]{
                {'0','0','0','0','0','E','E','E','E','E','E','E','E','0','0','0','0','0','0','W','W','W','0','W','W','W','0','0','W','0','W','0','W','E','E','E','E','0','0','0','0','E','W','0','0','W'}
        };
        char [][] arr4 = new char[][]{
                {'E'},
                {'0'},
                {'W'},
                {'E'},
                {'E'}
        };


        System.out.println(new BombEnemy_553().maxKilledEnemies(arr2));
    }
}
