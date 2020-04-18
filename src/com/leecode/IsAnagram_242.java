package com.leecode;

import java.util.HashMap;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsAnagram_242 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        HashMap<Character,Integer> map = new HashMap<>();
        char [] chars = s.toCharArray();
        for (char c : chars) {
            if(!map.containsKey(c)){
                map.put(c,1);
            }else {
                map.replace(c,map.get(c)+1);
            }
        }
        char [] chars2 = t.toCharArray();
        for (char c : chars2) {
            if(map.containsKey(c)&&map.get(c)>0)
                map.replace(c,map.get(c)-1);
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsAnagram_242().isAnagram("anagram","nagaram"));
    }
}
