package com.leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * 通过次数66,415提交次数121,125
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZigzagLevelOrder_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        zLevel(root,list,0);
        reverseOdd(list);
        return list;
    }

    private void reverseOdd(List<List<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            if(i%2==1){
                Collections.reverse(list.get(i));
            }
        }
    }

    private void zLevel(TreeNode root, List<List<Integer>> list,int depth) {
        if(root==null){
            return;
        }
        if(list.size()<=depth){
            List<Integer> arrayList = new ArrayList<>();
            list.add(arrayList);
        }
        list.get(depth).add(root.val);
        zLevel(root.left,list,depth+1);
        zLevel(root.right,list,depth+1);

    }
}
