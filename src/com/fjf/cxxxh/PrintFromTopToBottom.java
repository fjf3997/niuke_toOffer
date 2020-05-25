package com.fjf.cxxxh;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
       LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode node=null;
        ArrayList<Integer> list = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            node = queue.poll();
            list.add(node.val);
            if(node.left!=null)
                queue.offer(node.left);
            if(node.right!=null)
                queue.offer(node.right);
        }
        return list;
    }
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
