package com.SwordToOffer;

import java.util.Stack;

public class MinStack_30 {
    private Stack<Integer> stack;
    private Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack_30() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(min.isEmpty()){
            min.push(x);
        }else if(x<=min.peek()){
            min.push(x);
        }
    }

    public void pop() {
        int x = stack.pop();
        if(x==min.peek()){
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
