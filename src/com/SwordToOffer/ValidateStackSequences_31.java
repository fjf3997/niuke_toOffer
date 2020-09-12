package com.SwordToOffer;

import java.util.Stack;

public class ValidateStackSequences_31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length!=popped.length){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int i=0,j=0;
        while(i<pushed.length||j<popped.length){
            if(i<pushed.length){
                if(pushed[i]!=popped[j]){
                    if(!stack.isEmpty()&&stack.peek()==popped[j]){
                        stack.pop();
                        j++;
                        continue;
                    }
                    stack.push(pushed[i]);
                    i++;
                }else {

                    i++;
                    j++;
                }
                continue;
            }
            if(!stack.isEmpty()){
                if(stack.pop()!=popped[j]){
                    return false;
                }
                j++;

            }

        }
        return true;
    }

    public static void main(String[] args) {
        int [] arr1 = {1,2,3,4,5};
        int [] arr2 = {4,3,5,1,2};
        System.out.println(new ValidateStackSequences_31().validateStackSequences(arr1,arr2));
    }
}
