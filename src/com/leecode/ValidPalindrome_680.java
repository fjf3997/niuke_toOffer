package com.leecode;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 示例 1:
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidPalindrome_680 {
    public boolean validPalindrome(String s) {
        int start = 0,end = s.length()-1;
        while (start<end){
            if(s.charAt(start)==s.charAt(end))
            {
                start++;
                end--;
            }else {
                return valid(s,start+1,end)||valid(s,start,end-1);
            }
        }
        return true;
    }

    private boolean valid(String s, int i, int end) {
        while (i<end){
            if(s.charAt(i)==s.charAt(end)){
                i++;
                end--;
            }else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome_680().validPalindrome("abdcca"));
    }
}
