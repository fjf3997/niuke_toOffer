package com.designPattern.structual;

import java.util.ArrayList;

public class MyStack<T> {
    private ArrayList<T> list;
    private int count;
    public MyStack(){
        list = new ArrayList<>();
        count = -1;
    }
    public boolean empty(){
        return count==-1;
    }
    T peek(){
        return list.get(count);
    }
    T pop(){
        T t = list.get(count);
        list.remove(count);
        count--;
        return t;
    }
    void push(T t){
        list.add(++count,t);
    }

    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.pop();
        myStack.push(4);
        myStack.push(5);
        while (!myStack.empty()){
            System.out.println(myStack.pop());
        }
    }

}
