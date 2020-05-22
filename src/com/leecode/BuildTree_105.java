package com.leecode;

import com.SwordToOffer.BuildTree_07;

import java.util.HashMap;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTree_105 {
    private HashMap<Integer,Integer> map;
    private int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return recursion(0,0, inorder.length-1);


    }

    private TreeNode recursion(int pre_index, int in_left, int in_right) {
        if(in_left>in_right)
            return null;
        TreeNode root = new TreeNode(preorder[pre_index]);
        int in_index = map.get(preorder[pre_index]);
        root.left = recursion(pre_index+1,in_left,in_index-1);
        root.right = recursion(pre_index+in_index-in_left+1,in_index+1,in_right);
        return root;

    }
    public static void main(String[] args) {
        int [] pre = {3,9,20,15,7};
        int [] in = {9,3,15,20,7};
        TreeNode head = new BuildTree_105().buildTree(pre,in);
        System.out.println(head.val);
        System.out.println(head.left.val);
        System.out.println(head.right.val);
    }
}
