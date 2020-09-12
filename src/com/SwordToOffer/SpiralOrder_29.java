package com.SwordToOffer;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * 限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SpiralOrder_29 {
    public int[] spiralOrder(int[][] matrix) {
        int row = matrix.length;
        if(row ==0){
            return new int[0];
        }
        int col = matrix[0].length;
        int l = 0,r = col-1,t=0,b=row-1,index=0;
        int []res = new int[row*col];
        while(true){
            // left -> right
            for(int i=l;i<=r;i++){
                res[index++]=matrix[t][i];
            }
            if(++t>b)break;
            // top -> bottom
            for(int i=t;i<=b;i++){
                res[index++] = matrix[i][r];
            }
            if(--r<l)break;
            // right -> left
            for(int i=r;i>=l;i--){
                res[index++]=matrix[b][i];
            }
            if(--b<t)break;
            // bottom -> top
            for(int i=b;i>=t;i--){
                res[index++] = matrix[i][l];
            }
            if(++l>r)break;
        }
        return res;
    }

    public static void main(String[] args) {
        int [][] matrix={
                {1,2,3},{4,5,6},{7,8,9}
        };
        int[] ints = new SpiralOrder_29().spiralOrder(matrix);
        for(int i=0;i<ints.length;i++){
            System.out.print(ints[i]+" ");
        }
        System.out.println();
    }
}
