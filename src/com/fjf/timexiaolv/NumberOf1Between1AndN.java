package com.fjf.timexiaolv;
/*
求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class NumberOf1Between1AndN {
    public static int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        if(n>0){
            //个位
            count = n/10 * 1+(n%10!=0 ? 1 : 0);
        }
        if(n>=10){
            //十位上1的数目
            int k = n%100;
            int num = 0;
            if(k>19){
                num = 10;
            }else if(k<10){
                num = 0;
            }else{
                num = k -10 +1;
            }
            count += (n / 100) * 10 + num;
        }
        if(n>=100){
            //百位上1的数目
            int k = n%1000;
            int num = 0;
            if(k>199){
                num = 100;
            }else if(k<100){
                num = 0;
            }else{
                num = k-100+1;
            }
            count += (n/1000)*100+num;

        }
        if(n>=1000){
            int k = n%10000;
            int num = 0;
            if(k>1999){
                num = 1000;
            }else if(k<1999){
                num =0;
            }else {
                num = k - 1000+1;
            }
            count += (n/10000)*1000 +num;
        }
        //千位上1的个数
        if(n/10000>0){
            count +=1;
        }

        return count;
    }

    public static void main(String[] args) {
        int i = NumberOf1Between1AndN_Solution(10);
        System.out.println(i);
        /*int i=1;
        for (;i<10000;){
            for (int j=0;j<10;j++)
            System.out.print(i+++"  ");
            System.out.println();
        }*/

    }

}
