package com.fjf.abstractModeling;

import java.util.Arrays;
import java.util.Set;
    import java.util.TreeSet;

/**
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,
 * 并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 */
public class IsContinuousClass {
    public boolean isContinuous(int [] numbers) {
        TreeSet<Integer> set = new TreeSet<>();
        int num=0;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==0)num++;
            else set.add(numbers[i]);
        }
        if(num+set.size()!=5){//每个数组的长度全都是5
            return false;
        }else{
            if(set.last()-set.first()<5){
                return true;
            }
        }
        return false;
        /*if(numbers.length<1){
            return true;
        }
        Arrays.sort(numbers);
        int num_0=0,blank=0;
        int s=-1;
        int e = numbers[numbers.length-1];
        boolean falg=true;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==0)num_0++;
            else {
                if(falg){
                    s=numbers[i];
                    falg=false;
                }
                if(s==numbers[i])s++;
                else {
                    s++;
                    blank++;
                }
            }

        }
        if(num_0>=blank)return true;
        return false;*/
    }

    public static void main(String[] args) {
        IsContinuousClass isContinuousClass = new IsContinuousClass();
        System.out.println(isContinuousClass.isContinuous(new int[]{1,3,0,7,0}));
    }
}
