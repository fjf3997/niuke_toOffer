package com.leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
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
