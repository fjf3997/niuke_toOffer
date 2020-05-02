package com.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 上图为 8 皇后问题的一种解法。

 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

 示例:

 输入: 4
 输出: [
 [".Q..",  // 解法 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // 解法 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 解释: 4 皇后问题存在两个不同的解法。

 提示：

 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步，可进可退。（引用自 百度百科 - 皇后 ）
 */
public class SolveNQueens_51 {
    private boolean [] col;
    private boolean [] dia1;
    private boolean [] dia2;
    private ArrayList<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if(n==0)
            return res;
        col = new boolean[n];
        dia1 = new boolean[2*n-1];
        dia2 = new boolean[2*n-1];
        LinkedList<Integer> arr = new LinkedList<>();
        putQueen(n,0,arr);
        return res;

    }

    private void putQueen(int n, int index, LinkedList<Integer> arr) {
        if(index==n){
            res.add(generateString(n,arr));
            return;
        }
        for(int i=0;i<n;i++){
            if(!col[i]&&!dia1[index+i]&&!dia2[index-i+n-1]){
                arr.addLast(i);
                col[i]=true;
                dia1[index+i]=true;
                dia2[index-i+n-1]=true;
                putQueen(n,index+1,arr);
                col[i]=false;
                dia1[index+i]=false;
                dia2[index-i+n-1]=false;
                arr.removeLast();
            }
        }

    }

    private List<String> generateString(int n, LinkedList<Integer> arr) {
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            char [] chars = new char[n];
            Arrays.fill(chars,'.');
            chars[arr.get(i)]='Q';
            String s = new String(chars);
            list.add(s);
        }
        return list;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(0);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);
        List<String> strings = new SolveNQueens_51().generateString(4, list);
//        System.out.println(strings);
        List<List<String>> lists = new SolveNQueens_51().solveNQueens(4);
        System.out.println(lists);
    }

}
