package com.SwordToOffer;

import java.util.HashSet;
import java.util.LinkedList;


/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * 限制：
 * 1 <= s 的长度 <= 8
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permutation_38 {
    //https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/solution/mian-shi-ti-38-zi-fu-chuan-de-pai-lie-hui-su-fa-by/
    private LinkedList<String> res;
    char [] c;
    public String[] permutation(String s) {
        res = new LinkedList<>();
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);

    }

    private void dfs(int x) {
        if(x==c.length-1){
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x;i<c.length;i++){
            if(set.contains(c[i]))continue;
            else set.add(c[i]);
            swap(i,x);
            dfs(x+1);
            swap(x,i);
        }

    }
    private void swap(int i,int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

}
