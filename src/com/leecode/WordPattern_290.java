package com.leecode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordPattern_290 {
    public boolean wordPattern(String pattern, String str) {
        HashMap<String,Character> map = new HashMap<>();
        HashSet<String> strset = new HashSet<>();
        HashSet<Character> charset = new HashSet<>();
        char[] chars = pattern.toCharArray();
        String[] strings = str.split(" ");
        if(chars.length!=strings.length)
            return false;
        for (char aChar : chars) {
            charset.add(aChar);

        }
        for (String string : strings) {
            strset.add(string);
        }
        if(strset.size()!=charset.size())
            return false;
        int index = 0;
        for (String string : strings) {
            if(!map.containsKey(string))
                map.put(string,chars[index++]);
            else {
                if(map.get(string)!=chars[index++])
                    return false;
            }

        }
        return true;
        /*HashMap<Character,String> map = new HashMap<>();
        char[] chars = pattern.toCharArray();
        String[] strings = str.split(" ");
        if(chars.length!=strings.length)
            return false;
        int index = 0;
        for (char c : chars) {
            if(!map.containsKey(c))
                map.put(c,strings[index++]);
            else {
                if(!map.get(c).equals(strings[index++]))
                    return false;
            }
        }

        return true;*/
    }

    public static void main(String[] args) {
        System.out.println(new WordPattern_290().wordPattern("abba","dog cat cat dog"));
    }
}
