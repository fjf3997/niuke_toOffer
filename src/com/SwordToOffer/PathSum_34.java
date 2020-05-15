package com.SwordToOffer;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * 提示：
 * 节点总数 <= 10000
 * 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSum_34 {
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recursion(root,sum);
        return res;
    }
    private void recursion(TreeNode root,int tar){
        if(root==null)
            return;
        list.addLast(root.val);
        if(root.val==tar&&root.left==null&&root.right==null)
            res.add(new LinkedList<>(list));
        recursion(root.left,tar-root.val);
        recursion(root.right,tar-root.val);
        list.removeLast();
    }

}
