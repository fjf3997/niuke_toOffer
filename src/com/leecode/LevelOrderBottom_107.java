package com.leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * 通过次数77,065提交次数116,166
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LevelOrderBottom_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        recursion(root,list,0);
        Collections.reverse(list);
        return list;
    }

    private void recursion(TreeNode root, List<List<Integer>> list, int depth) {
        if(root==null){
            return;
        }
        if(list.size()<=depth){
            List<Integer> arrayList = new ArrayList();
            list.add(arrayList);
        }
        list.get(depth).add(root.val);
        recursion(root.left,list,depth+1);
        recursion(root.right,list,depth+1);
    }
}
