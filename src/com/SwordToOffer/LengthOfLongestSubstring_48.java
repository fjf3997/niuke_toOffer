/*
 *  Copyright@2019 清云智通（北京）科技有限公司 保留所有权利
 */
package com.SwordToOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fanjf@tsingyun.net
 * @date 2020/5/27 20:55
 */
public class LengthOfLongestSubstring_48 {
    public int lengthOfLongestSubstring(String s) {
        //todo
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            // 获取索引 i
            int i = dic.getOrDefault(s.charAt(j), -1);
            // 更新哈希表
            dic.put(s.charAt(j), j);
            // dp[j - 1] -> dp[j]
            tmp = tmp < j - i ? tmp + 1 : j - i;
            // max(dp[j - 1], dp[j])
            res = Math.max(res, tmp);
        }
        return res;
    }
    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        int l = 0,r = 0;
        int[] arr = new int[256];
        while(r<s.length()){
            char c = s.charAt(r);
            if(arr[c]!=0){
                while (arr[c]!=0){
                    char ch = s.charAt(l);
                    arr[ch]--;
                    l++;
                }
            }
            arr[c] = 1;
            r++;
            max = Math.max(max,r-l);
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "pwwkew";
        String str2 = "bbbbbb";
        String str3 = "dvdf";
        System.out.println(new LengthOfLongestSubstring_48().lengthOfLongestSubstring2(str3));
        System.out.println(new LengthOfLongestSubstring_48().lengthOfLongestSubstring2(str2));
        System.out.println(new LengthOfLongestSubstring_48().lengthOfLongestSubstring2(str));
    }
}
