package com.leecode;


/**
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle
 * 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StrStr_28 {
    private int BASE = 1000000;
    public int strStr(String haystack, String needle) {
        // Rabin-Karp
        int m = haystack.length();
        int n = needle.length();
        if(n==0){
            return 0;
        }
        int power = 1;
        for(int i=0;i<n;i++){
            power = (power*31)%BASE;
        }
        int needleHash = 0;
        for(int i=0;i<n;i++){
            needleHash = (needleHash*31 + needle.charAt(i))%BASE;
        }
        int haystackHash = 0;
        for(int i=0;i<m;i++){
            // abc+d
            haystackHash = (haystackHash*31 + haystack.charAt(i))%BASE;
            if(i<n-1){
                continue;
            }
            // abcd -a
            if(i>=n){
                haystackHash = haystackHash - (haystack.charAt(i-n)*power)%BASE;
                if(haystackHash<0){
                    haystackHash += BASE;
                }
            }
            // 双层检测,防止hash值一致,但实际不相等情况
            if(needleHash==haystackHash){
                if(haystack.substring(i-n+1,i+1).equals(needle)){
                    return i-n+1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new StrStr_28().strStr("hello","ll"));
    }
}
