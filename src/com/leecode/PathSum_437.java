package com.leecode;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSum_437 {
    public int pathSum(TreeNode root, int sum) {
        if(root==null)
            return 0;
        int res = 0;
        res += findPath(root,sum);
        res += pathSum(root.left,sum);
        res += pathSum(root.right,sum);
        return res;
    }
    //查找包含root节点的并且和为sum的值
    private int findPath(TreeNode root, int sum) {
        if(root==null)
            return 0;
        int res = 0;
        if(root.val==sum)
            res+=1;
        res += findPath(root.left,sum-root.val);
        res += findPath(root.right,sum-root.val);
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        int res = new PathSum_437().pathSum(node1,8);
        System.out.println(res);

    }
}
