package com.leecode;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumIslands_200 {
    private int count;
    private int [][] direct = {
        {-1,0},
        {0,1},
        {1,0},
        {0,-1}
    };
    private boolean [][] visited;
    private int r,c;
    public int numIslands(char[][] grid) {
        r=grid.length;
        if(r==0)
            return 0;
        c=grid[0].length;
        count=0;

        visited = new boolean[r][c];
        for(int i=0;i<r;i++)
            for (int j=0;j<c;j++){
                if(grid[i][j]=='1'&&!visited[i][j]){
                    count++;
                    dfs(grid,i,j);
                }
            }
        return count;


    }

    private void dfs(char[][] grid, int x, int y) {
        visited[x][y]=true;
        for( int i=0;i<direct.length;i++){
            int newx = x+direct[i][0];
            int newy = y+direct[i][1];
            if(isInArea(newx,newy)&&!visited[newx][newy]&&grid[newx][newy]=='1'){
                dfs(grid,newx,newy);
            }
        }
        return;
    }
    private boolean isInArea(int newX, int newY) {
        return newX>=0&&newX<r&&newY>=0&&newY<c;
    }
    public static void main(String[] args) {

        char grid1[][] = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        int res = new NumIslands_200().numIslands(grid1);
        System.out.println(res);
        // 1

        // ---

        char grid2[][] = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        System.out.println((new NumIslands_200()).numIslands(grid2));
        // 3
    }

}
