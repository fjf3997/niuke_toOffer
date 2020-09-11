/*
 *  Copyright@2019 清云智通（北京）科技有限公司 保留所有权利
 */
package com.leecode;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 示例 1:
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author fanjf@tsingyun.net
 * @date 2020/7/6 8:56
 */
public class NumDecodings_91 {
    public int numDecodings(String s) {
        // 动态规划
        char[] chars = s.toCharArray();
        if(chars.length==0){
            return 0;
        }
        // 状态 dp[i] 代表以0-i字符串的解码数量
        int [] dp = new int[chars.length+1];
        // 初始化
        dp[0] = 1;
        // 状态转移
        for(int i=1;i<=chars.length;i++){
            dp[i] = 0;
            if(chars[i-1]<='9'&&chars[i-1]>='1'){
                dp[i] += dp[i-1];
            }
            if(i>1){
                int j = (chars[i-2]-'0')*10+chars[i-1]-'0';
                if(j<=26&&j>=10){
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[s.length()];
    }
    private int[] memo;
    public int numDecodings2(String s) {
        memo = new int[s.length()+1];
        int res = recursion(s);
        return res;
    }

    private int recursion(String s) {
        if(s.charAt(0)=='0'){
            return 0;
        }
        int j = 1;
        if(s.length()==2){
            if(s.endsWith("0")&&s.charAt(s.length()-2)>='3'){
                return 0;
            }
            j = (s.charAt(0)-'0')*10 + s.charAt(1)-'0';
            if(j<=26&&j%10!=0){
                return 2;
            }else {
                return 1;
            }
        }
        if(s.length()==1){
            return 1;
        }

        j = (s.charAt(0)-'0')*10 + s.charAt(1)-'0';
        if(j<=26&&j>10){
             memo[s.length()] = recursion(s.substring(1,s.length()))+recursion(s.substring(2,s.length()));
        }else if(j==10){
            memo[s.length()] = recursion(s.substring(2,s.length()));
        }else {
            memo[s.length()] = recursion(s.substring(1,s.length()));
        }
        return memo[s.length()];

    }

    public static void main(String[] args) {
//        System.out.println(new NumDecodings_91().numDecodings2("101"));
        System.out.println(new NumDecodings_91().numDecodings2("12120"));
        System.out.println(new NumDecodings_91().numDecodings2("7541387519572282368613553811323167125532172369624572591562685959575371877973171856836975137559677665"));
        System.out.println(new NumDecodings_91().numDecodings2("230"));
        System.out.println(new NumDecodings_91().numDecodings2("226"));
        System.out.println(new NumDecodings_91().numDecodings2("100"));
        System.out.println(new NumDecodings_91().numDecodings("100"));
    }
}
