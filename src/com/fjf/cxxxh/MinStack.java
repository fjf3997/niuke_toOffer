package com.fjf.cxxxh;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 定义栈的数据结构，
 * 请在该类型中实现一个能够得到栈中所含最小元素的min函数
 * （时间复杂度应为O（1））。
 */
public class MinStack {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    public void push(int node) {
        stack1.push(node);
        if(stack2.isEmpty()){
            stack2.push(node);
        }else{
            if(node<=stack2.peek())
                stack2.push(node);
        }
    }

    public void pop() {
        if(stack1.empty()){
            return;
        }
        if(stack1.peek()==stack2.peek())
            stack2.pop();
        stack1.pop();

    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }

    public static void main(String[] args) {
        /**
         * ["PSH3","MIN","PSH4","MIN","PSH2","MIN","PSH3",---7
         * "MIN","POP","MIN","POP","MIN","POP","MIN","PSH0","MIN"]
         * 对应输出应该为:
         * 3,3,2,2,2,3,3,0
         */
        MinStack minStack = new MinStack();
        minStack.push(3);
        ArrayList<Integer> array = new ArrayList<>();
        array.add(minStack.min());
        minStack.push(4);
        array.add(minStack.min());
        minStack.push(2);
        array.add(minStack.min());
        minStack.push(3);
        array.add(minStack.min());
        minStack.pop();
        array.add(minStack.min());
        minStack.pop();
        array.add(minStack.min());
        minStack.pop();
        array.add(minStack.min());
        minStack.push(0);
        array.add(minStack.min());
        for(Integer i:array)
            System.out.println(i);

    }
}
