package com.leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {

        Command command = new Command(1,root);
        List<Integer> list = new ArrayList<>();
        if(root==null)
            return list;
        Stack<Command> stack = new Stack<>();
        stack.push(command);
        while (!stack.empty()){
            Command com = stack.pop();
            if(com.command==2){
                list.add(com.node.val);
            }else {
                if(com.node.right!=null){
                    stack.push(new Command(1,com.node.right));
                }
                if(com.node.left!=null){
                    stack.push(new Command(1,com.node.left));
                }
                stack.push(new Command(2,com.node));
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
class Command{
    int command;//1->go,2->print
    TreeNode node;
    public Command(int command,TreeNode node){
        this.command=command;
        this.node=node;
    }
}
