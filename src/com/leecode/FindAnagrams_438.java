package com.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 */
public class FindAnagrams_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int num = p.length();
        int [] window = new int[123];
        int [] target = new int[123];
        int match = 0;
        for(int i=0;i<num;i++){
            target[p.charAt(i)]++;
        }
        int left = 0,right = 0;
        while (right<s.length()){
            char c1 = s.charAt(right);
            if(target[c1]!=0){
                window[c1]++;
                if(window[c1]<=target[c1]){
                    match++;
                }
            }
            right++;
            while (match==num){
                char c2 = s.charAt(left);
                if(right-left==num){
                    ans.add(left);
                }
                if(target[c2]!=0){
                    window[c2]--;
                    if(window[c2]<target[c2]){
                        match--;
                    }
                }
                left++;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        List<Integer> list = new FindAnagrams_438().findAnagrams("baa","aa");
        for (Integer integer : list) {
            System.out.print(integer+"  ");
        }
    }
}
