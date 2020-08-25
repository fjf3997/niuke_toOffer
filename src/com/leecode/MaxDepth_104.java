package com.leecode;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxDepth_104 {
    private int max = 0;
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        return Math.max(maxLeft,maxRight)+1;
    }
    public int maxDepth2(TreeNode root) {
        if(root==null){
            return 0;
        }
        recursion(root,1);
        return max;

    }

    private void recursion(TreeNode root, int i) {
        if(root==null){
            return;
        }
        if(i>max){
            max = i;
        }
        recursion(root.left,i+1);
        recursion(root.right,i+1);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        node1.left = node2;
        node1.right = node3;
        System.out.println(new MaxDepth_104().maxDepth2(node1));
    }

}
