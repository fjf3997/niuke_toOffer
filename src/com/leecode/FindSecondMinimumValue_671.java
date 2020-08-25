package com.leecode;

/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，
 * 那么该节点的值等于两个子节点中较小的一个。
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 * 输出: 5
 * 说明: 最小的值是 2 ，第二小的值是 5 。
 * 示例 2:
 * 输入:
 *     2
 *    / \
 *   2   2
 * 输出: -1
 * 说明: 最小的值是 2, 但是不存在第二小的值。
 * 通过次数15,211提交次数32,462
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindSecondMinimumValue_671 {
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null){
            return -1;
        }
        return recursion(root,root.val);
    }

    private int recursion(TreeNode root, int val) {
        if(root.val!=val){
            return root.val;
        }else {
            if(root.left==null){
                return -1;
            }else {
                int leftmin = recursion(root.left,root.val);
                int rightmin = recursion(root.right,root.val);
                if(leftmin==-1)
                    return rightmin;
                if(rightmin==-1)
                    return leftmin;
                return Math.min(leftmin,rightmin);
            }
        }
    }
}
