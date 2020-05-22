package com.SwordToOffer;

import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 限制：
 * 0 <= 节点个数 <= 5000
 * 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/solution/mian-shi-ti-07-zhong-jian-er-cha-shu-di-gui-fa-qin/
public class BuildTree_07 {
    private HashMap<Integer,Integer> map;
    private int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return recursion(0,0,inorder.length-1);

    }

    private TreeNode recursion(int pre_root, int in_left, int in_right) {
        if(in_left>in_right)
            return null;
        TreeNode root = new TreeNode(this.preorder[pre_root]);
        int in_root = map.get(root.val);
        root.left = recursion(pre_root+1,in_left,in_root-1);
        root.right = recursion(pre_root+in_root-in_left+1,in_root+1,in_right);//右子树跟的节点索引
        return root;
    }

    public static void main(String[] args) {
        int [] pre = {3,9,20,15,7};
        int [] in = {9,3,15,20,7};
        TreeNode head = new BuildTree_07().buildTree(pre,in);
        System.out.println(head.val);
        System.out.println(head.left.val);
        System.out.println(head.right.val);
    }
}
