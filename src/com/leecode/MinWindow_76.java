package com.leecode;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinWindow_76 {
    public String minWindow(String s, String t) {
        int res = Integer.MAX_VALUE;
        String minStr = "";
        int [] sourceHash = new int[256];
        int [] targetHash = new int[256];
        initTargetHash(targetHash,t);
        int i=0,j=0;
        for(;i<s.length();i++){
            while (j<s.length()&&!valid(sourceHash,targetHash)){
                sourceHash[s.charAt(j)]++;
                j++;
            }
            if(valid(sourceHash,targetHash)){
                if(res>j-i){
                    res = j-i;
                    minStr = s.substring(i,j);
                }
            }
            sourceHash[s.charAt(i)]--;
        }
        return minStr;
    }

    public static void main(String[] args) {
        System.out.println(new MinWindow_76().minWindow("ADOBECODEBANC","ABC"));
    }

    private boolean valid(int[] sourceHash, int[] targetHash) {
        for(int i=0;i<256;i++){
            if(targetHash[i]>sourceHash[i]){
                return false;
            }
        }
        return true;
    }

    private void initTargetHash(int[] targetHash, String t) {
        for (int i=0;i<t.length();i++){
            targetHash[t.charAt(i)]++;
        }
    }
}
