package com.SwordToOffer;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
 * 注意：本题与主站 65 题相同：https://leetcode-cn.com/problems/valid-number/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsNumber_20 {
    public boolean isNumber(String s) {
        if(s==null||s.length()==0)
            return false;
        boolean numAppeared = false;
        boolean dotAppeared = false;
        boolean eAppeared = false;
        char[] chars = s.trim().toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]>='0'&&chars[i]<='9'){
                numAppeared = true;
            }else if(chars[i]=='.'){
                //.之前不能出现.或者e
                if(dotAppeared||eAppeared)
                    return false;
                dotAppeared = true;
            }else if(chars[i]=='e'||chars[i]=='E'){
                //e之前不能出现e，必须出现数
                if(eAppeared||!numAppeared)
                    return false;
                eAppeared = true;
                numAppeared = false;//重置numSeen，排除123e或者123e+的情况,确保e之后也出现数
            }else if(chars[i] == '-' || chars[i] == '+'){
                //+-出现在0位置或者e/E的后面第一个位置才是合法的
                if(i != 0 && chars[i-1] != 'e' && chars[i-1] != 'E'){
                    return false;
                }
            } else {
                return false;
            }
        }
        return numAppeared;

    }
    public boolean isNumber2(String s) {
        s = s.trim();
        if(s.length()==0){
            return false;
        }
        if(s.charAt(0)=='+'||s.charAt(0)=='-'){
            s = s.substring(1);
            if(s.length()==0)return false;// "+" "-"
        }

        int dot = 0,e = 0,length = s.length();
        boolean num = false;
        for(int i=0;i<length;i++){
            char c = s.charAt(i);
            if(c<='9'&&c>='0'){
                num = true;
                continue;
            }else if(c=='.'){
                dot++;
                // 123.123.123 123. 123e1.1
                if(dot>1||i==length-1||e>=1){
                    return false;
                }
            }else if(c=='e'||c=='E'){
                e++;
                // 123e123e123 e123 123e .e
                if(e>1||!num||i==length-1||i==0||s.charAt(i-1)=='.'){
                    return false;
                }
            }else if(c=='+'||c=='-'){
                if(i==0||s.charAt(i-1)!='e'||i==length-1)
                    return false;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsNumber_20().isNumber("1.2.3"));
        System.out.println(new IsNumber_20().isNumber2("12e"));
    }
}
