package com.SwordToOffer;


public class IsBalanced_55_2 {
    public boolean isBalanced(TreeNode root) {

        return recursion(root);

    }
    private boolean recursion(TreeNode root){
        if(root==null){
            return true;
        }
        return Math.abs(deepth(root.left)-deepth(root.right))<=1&&recursion(root.left)&&recursion(root.right);
    }
    private int deepth(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(deepth(root.left),deepth(root.right))+1;
    }

    public static void main(String[] args) {
        TreeNode node15 = new TreeNode(15);
        TreeNode node17 = new TreeNode(17);
        TreeNode node16 = new TreeNode(16);

    }
}
