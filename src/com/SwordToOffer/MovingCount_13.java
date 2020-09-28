package com.SwordToOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MovingCount_13 {
    private int count;
    private boolean [][]visited;
    private int m,n,k;
    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        count = 0;
        visited = new boolean[m][n];
        this.m = m;
        this.n = n;
        this.k = k;
        return dfs(0,0,0);
    }

    private int dfs(int i, int j, int sum) {
        if(i>=m||j>=n||sum>k||visited[i][j])
            return 0;
        visited[i][j]=true;
        return 1+dfs(i+1,j,getSum(i+1,j))+dfs(i,j+1,getSum(i,j+1));
    }

    private int getSum(int i, int j) {
        int sum = 0;
        while (i!=0){
            sum+=i%10;
            i = i/10;
        }
        while (j!=0){
            sum+=j%10;
            j=j/10;
        }
        return sum;

    }
    // bfs
    private int getNumSum(int num){
        int sum = 0;
        while(num!=0){
            sum += num%10;
            num = num/10;
        }
        return sum;
    }
    private int getSum(Pair pair){
        return getNumSum(pair.x)+getNumSum(pair.y);
    }
    public int movingCount2(int threshold, int rows, int cols)
    {
        if(rows==0||cols==0){
            return 0;
        }
        int res = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0,0));
        boolean [][]flag = new boolean[rows][cols];
        flag[0][0] = true;
        int [][]direct = {
                {-1,0},{0,1},{1,0},{0,-1}
        };
        while(!queue.isEmpty()){
            res++;
            Pair pair = queue.poll();
            for(int k=0;k<4;k++){
                int newx = pair.x + direct[k][0];
                int newy = pair.y + direct[k][1];
                Pair p = new Pair(newx,newy);
                if(newx>=0&&newx<rows&&newy>=0&&newy<cols&&getSum(p)<=threshold&&!flag[newx][newy]){
                    flag[newx][newy] = true;
                    queue.add(p);
                }
            }

        }
        return res;

    }
    static class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {
        System.out.println(new MovingCount_13().movingCount2(7,4,5));
    }
}
