package com.SwordToOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * 示例: 
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Codec_37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node==null){
                sb.append(",").append("null");
            }else {
                sb.append(",").append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }

        }
        while (sb.length()>5&&",null".equals(sb.substring(sb.length()-5,sb.length()))){
            sb.delete(sb.length()-5,sb.length());
        }
        if(sb.length()>1){
            sb.deleteCharAt(1);
        }
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()<=2){
            return null;
        }
        String subStr = data.substring(1, data.length() - 1);
        String[] split = subStr.split(",");
        TreeNode root = null;
        Queue<TreeNode> queue = new LinkedList<>();
        if(split.length>0){
            root = new TreeNode(Integer.valueOf(split[0]));
        }
        queue.add(root);
        int i=1;
        while (!queue.isEmpty()&&i<split.length){
            TreeNode node = queue.poll();
            if(!"null".equals(split[i])){
                node.left = new TreeNode(Integer.valueOf(split[i]));
                queue.add(node.left);
            }
            i++;
            if(i>=split.length){
                break;
            }
            if(!"null".equals(split[i])){
                node.right = new TreeNode(Integer.valueOf(split[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        String str = "[1,2,3,null,null,4,5]";
        Codec_37 codec = new Codec_37();
        TreeNode root = codec.deserialize(str);
        printTreeNode(root);
        String serialize = codec.serialize(root);
        System.out.println(serialize);
        root = null;
        System.out.println(codec.serialize(root));
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(codec.serialize(root));
        TreeNode node1 = codec.deserialize("[1,2]");
        printTreeNode(node1);

    }

    private static void printTreeNode(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
            System.out.print(node.val+" ");
        }
        System.out.println();
    }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
