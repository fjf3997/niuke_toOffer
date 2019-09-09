package com.fjf.cxxxh;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {
    public static void main(String[] args) {
        int [][]matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int [][]matrix2 = {{1,2},{3,4}};
        int [][]matrix3 = {{1},{2},{3},{4},{5}};
        int [][]matrix4 = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
        List<Integer> list = printMatrix(matrix4);
        for(Integer i:list)
            System.out.println(i);
    }

    /**
     *
     * 左上和右下的坐标定位出一次要旋转打印的数据，一次旋转打印结束后，
     * 往对角分别前进和后退一个单位。
     * 提交代码时，主要的问题出在没有控制好后两个for循环，
     * 需要加入条件判断，防止出现单行或者单列的情况。
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        int left = 0;
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        ArrayList<Integer> array = new ArrayList<>();
        if(bottom==0) {
            for (int i = 0; i <= right; i++)
                array.add(matrix[top][i]);
            return array;
        }
        if(right==0) {
            for (int i = 0; i <= bottom; i++)
                array.add(matrix[i][left]);
            return array;
        }
        while(left<=right&&top<=bottom){
            for(int i=left;i<=right;i++)
                array.add(matrix[top][i]);
            for(int i = top+1;i<=bottom;i++)
                array.add(matrix[i][right]);
            if(top!=bottom)
                for(int i=right-1;i>=left;i--)
                    array.add(matrix[bottom][i]);
            if(left!=right)
                for(int i=bottom-1;i>top;i--)
                    array.add(matrix[i][left]);
            left++;right--;top++;bottom--;
        }
        return array;
    }
}
