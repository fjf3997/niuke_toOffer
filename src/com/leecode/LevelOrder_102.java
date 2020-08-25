package com.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LevelOrder_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        Pair<TreeNode,Integer> pair = new Pair<>(root,0);
        queue.add(pair);
        while (!queue.isEmpty()){
            Pair<TreeNode, Integer> p = queue.poll();
            TreeNode cur = p.first;
            int level = p.second;
            if(level==res.size()){
                res.add(new ArrayList<>());
            }
            res.get(level).add(cur.val);
            if(cur.left!=null){
                queue.add(new Pair<>(cur.left,level+1));
            }
            if(cur.right!=null){
                queue.add(new Pair<>(cur.right,level+1));
            }

        }
        return res;
    }
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        recursion(root,list,0);
        return list;
    }

    private void recursion(TreeNode root, List<List<Integer>> list, int depth) {
        if(root==null){
            return;
        }
        if(list.size()<=depth){
            List<Integer> arrayList = new ArrayList<>();
            list.add(arrayList);
        }
        list.get(depth).add(root.val);
        recursion(root.left,list,depth+1);
        recursion(root.right,list,depth+1);
    }
}

