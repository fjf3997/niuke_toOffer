package com.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreePaths_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root==null)
            return list;
        if(root.left==null&&root.right==null){
            list.add(Integer.toString(root.val));
            return list;
        }
        List<String> leftS = binaryTreePaths(root.left);
        for (String left : leftS) {
            StringBuilder stringBuilder = new StringBuilder(Integer.toString(root.val));
            stringBuilder.append("->");
            stringBuilder.append(left);
            list.add(stringBuilder.toString());

        }
        List<String> rightS = binaryTreePaths(root.right);
        for (String right : rightS) {
            StringBuilder stringBuilder = new StringBuilder(Integer.toString(root.val));
            stringBuilder.append("->");
            stringBuilder.append(right);
            list.add(stringBuilder.toString());

        }
        return list;

    }
}
