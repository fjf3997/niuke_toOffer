package com.leecode;

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * 示例 1:
 * 给定的树 s:
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *    4
 *   / \
 *  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 * 示例 2:
 * 给定的树 s：
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * 给定的树 t：
 *    4
 *   / \
 *  1   2
 * 返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsSubtree_572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null)
            return false;
        if(isSub(s,t))
            return true;
        return isSubtree(s.left,t)||isSubtree(s.right,t);
    }
    private boolean isSub(TreeNode s,TreeNode t){
        if(s==null&&t==null)
            return true;
        if(s==null&&t!=null||s!=null&&t==null)
            return false;

        if(s.left==null&&s.right==null&&t.left==null&&t.right==null)
            if(s.val==t.val)
                return true;
        return s.val==t.val&&isSub(s.left,t.left)&&isSub(s.right,t.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node6;
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(1);
        TreeNode node9 = new TreeNode(2);
        node7.left = node8;
        node7.right = node9;
        System.out.println(new IsSubtree_572().isSubtree(node1,node7));
    }
}
