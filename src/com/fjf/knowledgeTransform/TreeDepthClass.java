package com.fjf.knowledgeTransform;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点
 * （含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class TreeDepthClass {
    public int TreeDepth(TreeNode root) {
        //使用递归
        /*if(root==null){
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        return (left>right?left:right)+1;*/
        //使用队列
        /**
         * 利用队列，count是当前的节点，currentFloor。
         * 【总是要遍历到当前深度的最后一个节点，深度才加1】
         */
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count =0,d=0,currentFloor=queue.size();
        while (queue.size()>0){
            TreeNode temp = queue.poll();
            count++;
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
            if(count==currentFloor){
                d++;
                count=0;
                currentFloor=queue.size();
            }
        }

        return d;
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
