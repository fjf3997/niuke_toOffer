package com.SwordToOffer;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * 限制：
 * 0 <= s 的长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReplaceSpace_05 {
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int i=0;
        while (i<=s.length()){
            if(s.charAt(i)!=' ')
                stringBuilder.append(s.charAt(i));
            else
                stringBuilder.append("%20");
            i++;
        }
        return stringBuilder.toString();

    }
}
