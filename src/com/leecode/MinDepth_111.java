package com.leecode;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinDepth_111 {
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        /**
         * 在三目运算符左侧的条件下(left && right)，实际上1+left+right执行时该结点最多存在一个子树
         * (1 + left + 0 || 1 + right + 0)或者为叶子结点(1 + 0 + 0)。可以代入[1]、[1,null,2]两种树方便理解
         */
        return (left!=0&&right!=0)?1+Math.min(left,right):1+left+right;
    }
}
