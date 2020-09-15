package com.SwordToOffer;

/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * 示例 1：
 * 输入：n = 12
 * 输出：5
 * 示例 2：
 * 输入：n = 13
 * 输出：6
 * 限制：
 * 1 <= n < 2^31
 * 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountDigitOne_43 {
    public int countDigitOne(int n) {
        int res=0,high = n/10,cur = n%10,low =0,digit=1;
        while (high!=0||cur!=0){
            if(cur==0)
                res+=high*digit;
            else if(cur==1)
                res+=high*digit+low+1;
            else
                res+=(high+1)*digit;
            low += cur*digit;
            cur = high%10;
            high = high/10;
            digit*=10;
        }
        return res;
    }

    /**
     * 【1，n】
     * n = 345[y]78
     * 求y位出现1的次数
     * （1）
     * 000  00
     * 001  01
     * ... ..
     * 344  99
     * count += 345*100
     * (2.1) digit>1
     * count += 1*100
     * (2.2) digit ==1
     * count += 78
     * (2.3) digit == 0
     * count +=0
     * 所以y位出现1的次数位count
     * @param n
     * @return
     */
    public int countDigitOne2(int n) {
        String str = String.valueOf(n);
        int num = str.length();
        int count = 0;
        // 求i位上1出现的次数
        for(int i=0;i<num;i++){
            // 高位，即【0-i）位上的值
            int high = 0;
            String highStr = str.substring(0, i);
            if(highStr.length()!=0){
                high = Integer.parseInt(highStr);
            }
            // 低位，即【i+，num）位上的值
            String lowStr = str.substring(i+1,num);
            int value = 1;
            for(int j=0;j<lowStr.length();j++){
                value*=10;
            }
            int low = 0;
            if(lowStr.length()!=0){
                low = Integer.parseInt(lowStr);
            }
            count += high*value;
            // 当前位
            int digit = str.charAt(i) - '0';
            if(digit>1){
                count+=value;
            }else if(digit==1){
                count+=low+1;
            }
        }
        return count;


    }

    public static void main(String[] args) {
        System.out.println(new CountDigitOne_43().countDigitOne2(1));
    }
}
