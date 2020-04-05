package com.fjf.knowledgeTransform;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class IsBalancedClass {
    public boolean IsBalanced_Solution(TreeNode root) {
//        System.out.println(getDepth(root));
        if(root==null){
            return true;
        }

        return Math.abs(getDepth(root.left)-getDepth(root.right))>1?false:true;
    }
    private int getDepth(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        return 1+Math.max(getDepth(treeNode.left),getDepth(treeNode.right));
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(1);
        treeNode1.left=treeNode2;
        treeNode2.left=treeNode3;
        treeNode3.left=treeNode4;
        treeNode4.left=treeNode5;
        IsBalancedClass isBalancedClass = new IsBalancedClass();
        isBalancedClass.IsBalanced_Solution(treeNode1);

    }
}
