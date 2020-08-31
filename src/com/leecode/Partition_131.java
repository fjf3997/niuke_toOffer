package com.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 * 示例:
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Partition_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s.length()==0){
            return res;
        }
        generatepartition(s,0,new LinkedList<>(),res);
        return res;
    }

    private void generatepartition(String s, int index, LinkedList<String> strings, List<List<String>> res) {
        if(index==s.length()){
            res.add((List<String>) strings.clone());
        }
        for(int i=index+1;i<=s.length();i++){
            String sub = s.substring(index, i);
            if(palindrome(sub)){
                strings.addLast(sub);
                generatepartition(s,i,strings,res);
                strings.removeLast();
            }
        }

    }

    private boolean palindrome(String sub) {
        int start = 0;
        int end = sub.length()-1;
        while (start<end){
            if(sub.charAt(start)!=sub.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Partition_131().partition("aab"));
    }
}
