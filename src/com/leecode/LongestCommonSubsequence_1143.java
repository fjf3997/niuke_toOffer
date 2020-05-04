package com.leecode;

import java.util.Arrays;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * 若这两个字符串没有公共子序列，则返回 0。
 * 示例 1:
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 * 提示:
 *
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonSubsequence_1143 {
    private String s1,s2;
    private int [][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        s1 = text1;
        s2 = text2;
        int n = text1.length();
        int m = text2.length();
        //动态规划
        if(n==0||m==0)
            return 0;
        memo = new int [n+1][m+1];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],0);
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    memo[i][j]=1+memo[i-1][j-1];
                else{
                    memo[i][j]=Math.max(memo[i][j-1],memo[i-1][j]);
                }
            }
        }
        return memo[n][m];
        //记忆搜索法
        /*for(int i=0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
        return lcs(n-1,m-1);*/
    }

    private int lcs(int n, int m) {


        if(n==-1||m==-1)
            return 0;
        if(memo[n][m]!=-1)
            return memo[n][m];
        if(s1.charAt(n)==s2.charAt(m))
            memo[n][m] = 1+lcs(n-1,m-1);
        else
            memo[n][m] = Math.max(lcs(n,m-1),lcs(n-1,m));
        return memo[n][m];
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        System.out.println(new LongestCommonSubsequence_1143().longestCommonSubsequence(s1,s2));
    }
}
