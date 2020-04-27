package com.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinations_17 {
  /*  private List<String> list = new ArrayList<>();
    private String letterMap[] = {
        " ",    //0
        "",     //1
        "abc",  //2
        "def",  //3
        "ghi",  //4
        "jkl",  //5
        "mno",  //6
        "pqrs", //7
        "tuv",  //8
        "wxyz"  //9
    };
    public List<String> letterCombinations(String digits) {
        if(digits.equals(""))
            return list;
        findCombination(digits,0,"");
        return list;
    }
    private void findCombination(String digits,int index,String s){
        if(index==digits.length()){
            list.add(s);
            return;
        }
        Character c = digits.charAt(index);
        String letter = letterMap[c-'0'];
        for(int i=0;i<letter.length();i++){
            findCombination(digits,index+1,s+letter.charAt(i));
        }
    }

    public static void main(String[] args) {
        List<String> list = new LetterCombinations_17().letterCombinations("23");
        for (String s : list) {
            System.out.print(s+" ");

        }
    }*/
  private String letterMap[] = {
      " ",    //0
      "",     //1
      "abc",  //2
      "def",  //3
      "ghi",  //4
      "jkl",  //5
      "mno",  //6
      "pqrs", //7
      "tuv",  //8
      "wxyz"  //9
  };

    private ArrayList<String> res;

    public List<String> letterCombinations(String digits) {

        res = new ArrayList<String>();
        if(digits.equals(""))
            return res;

        findCombination(digits, 0, "");
        return res;
    }

    // s中保存了此时从digits[0...index-1]翻译得到的一个字母字符串
    // 寻找和digits[index]匹配的字母, 获得digits[0...index]翻译得到的解
    private void findCombination(String digits, int index, String s){

        System.out.println(index + " : " + s);
        if(index == digits.length()){
            res.add(s);
            System.out.println("get " + s + " , return");
            return;
        }

        Character c = digits.charAt(index);
        assert  c.compareTo('0') >= 0 &&
            c.compareTo('9') <= 0 &&
            c.compareTo('1') != 0;
        String letters = letterMap[c - '0'];
        for(int i = 0 ; i < letters.length() ; i ++){
            System.out.println("digits[" + index + "] = " + c +
                " , use " + letters.charAt(i));
            findCombination(digits, index+1, s + letters.charAt(i));
        }

        System.out.println("digits[" + index + "] = " + c + " complete, return");

        return;
    }

    private static void printList(List<String> list){
        for(String s: list)
            System.out.println(s);
    }

    public static void main(String[] args) {

        printList((new LetterCombinations_17()).letterCombinations("234"));
    }
}
