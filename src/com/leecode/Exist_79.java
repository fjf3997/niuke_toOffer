package com.leecode;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Exist_79 {
    private int [][] direct = {
        {-1,0},{0,1},{1,0},{0,-1}
    };
    private int r,c;
    private boolean [][] visited;
    public boolean exist(char[][] board, String word) {
        r = board.length;
        c = board[0].length;
        visited = new boolean[r][c];
        for(int i=0;i<r;i++)
            for (int j=0;j<c;j++)
                if(searchWord(board,word,0,i,j))
                    return true;
        return false;
    }

    private boolean searchWord(char[][] board, String word, int index, int startx, int starty) {
        if(index==word.length()-1){
            return board[startx][starty]==word.charAt(index);
        }
        if(board[startx][starty]==word.charAt(index)){
            visited[startx][starty]=true;
            for(int i=0;i<direct.length;i++){
                int newX = startx+direct[i][0];
                int newY = starty+direct[i][1];
                if(isInArea(newX,newY)&&!visited[newX][newY]&&searchWord(board,word,index+1,newX,newY))
                    return true;
            }
            visited[startx][starty]=false;
        }
        return false;
    }

    private boolean isInArea(int newX, int newY) {
        return newX>=0&&newX<r&&newY>=0&&newY<c;
    }
    public static void main(String args[]){

        char[][] b1 = { {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}};

        String words[] = {"ABCCED", "SEE", "ABCB" };
        for(int i = 0 ; i < words.length ; i ++)
            if((new Exist_79()).exist(b1, words[i]))
                System.out.println("found " + words[i]);
            else
                System.out.println("can not found " + words[i]);

        // ---

        char[][] b2 = {{'A'}};
        if((new Exist_79()).exist(b2,"AB"))
            System.out.println("found AB");
        else
            System.out.println("can not found AB");
    }
}
