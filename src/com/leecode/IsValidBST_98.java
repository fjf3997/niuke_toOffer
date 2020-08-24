package com.leecode;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValidBST_98 {
    private long pre;
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        pre = Long.MIN_VALUE;
        return isBST(root);
    }
    private boolean isValid(TreeNode root,TreeNode min,TreeNode max){
        if(root==null){
            return true;
        }
        if(min!=null&&root.val<=min.val){
            return false;
        }
        if(max!=null&&root.val>=max.val){
            return false;
        }
        return isValid(root.left,root,max)&&isValid(root.right,root,min);
    }
    private boolean isBST(TreeNode root){
        if(root==null)
            return true;
        if(!isBST(root.left))
            return false;
        if(root.val<=pre)
            return false;
        pre = root.val;
        if(!isBST(root.right))
            return false;
        return true;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        boolean validBST = new IsValidBST_98().isValidBST(node1);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(validBST);
    }
}
