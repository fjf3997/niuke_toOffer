package com.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 * 示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * 提示：
 * 0 <= s.length <= 3000
 * s 仅由数字组成
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RestoreIpAddresses_93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s.length()<4){
            return res;
        }
        generatorIp(s,0,0,"",res);
        return res;
    }

    private void generatorIp(String s, int index, int start, String str, List<String> res) {
        if(index==4){
            if(start==s.length()){
                res.add(str);
            }
            return;
        }
        for(int i=1;i<=3;i++){
            if(start+i<=s.length()){
                String sub = s.substring(start, start + i);
                String string = str==""?sub:str+"."+sub;
                switch (i){
                    case 1:
                        generatorIp(s,index+1,start+i,string,res);
                        break;
                    case 2:
                        if(!sub.startsWith("0")){
                            generatorIp(s,index+1,start+i,string,res);
                        }
                        break;
                    case 3:
                        if(!sub.startsWith("0")&&sub.compareTo("255")<1){
                            generatorIp(s,index+1,start+i,string,res);
                        }
                }
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new RestoreIpAddresses_93().restoreIpAddresses("25525511135"));
        System.out.println(new RestoreIpAddresses_93().restoreIpAddresses("101023"));
        System.out.println(new RestoreIpAddresses_93().restoreIpAddresses("1111"));
        System.out.println(new RestoreIpAddresses_93().restoreIpAddresses("010010"));
    }
}
