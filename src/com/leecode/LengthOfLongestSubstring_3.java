package com.leecode;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class LengthOfLongestSubstring_3 {
    public int lengthOfLongestSubstring2(String s) {
        // 时间复杂度为O(n)
        // 同209题,j不用回退,实际时间复杂度为O(2n)
        /**
         * 模板代码为:
         * for(i=0;i<s.length();i++){
         *             while (j<s.length()&&map[s.charAt(j)]==0){}
         * 根据题目条件&& 后的代码不同
         */
        int i = 0;
        int j = 0;
        int res = 0;
        int [] map = new int[256];
        for(i=0;i<s.length();i++){
            while (j<s.length()&&map[s.charAt(j)]==0){
                map[s.charAt(j)]=1;
                res = Math.max(res,j-i+1);
                j++;
            }
            map[s.charAt(i)]=0;
        }
        return res;
    }
    public int lengthOfLongestSubstring(String s) {
        int l=0,r=-1;
        int res=0;
        int [] freq=new int[256];
        while (l<s.length()){
            if(r+1<s.length()&&freq[s.charAt(r+1)]==0){
                r++;
                freq[s.charAt(r)]++;
            }else {
                freq[s.charAt(l)]--;
                l++;
            }
            res = Math.max(res,r-l+1);

        }
        return res;

    }
    public int lengthOfLongestSubstring3(String s) {
        int [] map = new int[256];
        int l = 0,r=0;
        int max = 0;
        while (r<s.length()){
            char c = s.charAt(r);
            map[c] ++;
            r++;
            while (map[c]==2){
                map[s.charAt(l)]--;
                l++;
            }
            max = Math.max(max,r-l);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring_3().lengthOfLongestSubstring2("abcabcbb"));
    }
}
