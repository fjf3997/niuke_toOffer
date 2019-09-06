package com.fjf.robustne;

/**
 * 输入两棵二叉树A，B，
 * 判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {
    /**
     * 解答：
     * 第一步在树A中找到和B的根节点的值一样的结点R；
     * 第二步再判断树A中以R为根结点的子树是不是包含和树B一样的结构。
     * @param root1
     * @param root2
     * @return
     */
    public static boolean HasSubtree(TreeNode root1/*A*/,TreeNode root2/*B*/) {
        if(root1==null||root2==null)
            return false;
        return isSubtree(root1,root2)||HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
    }
    public static boolean isSubtree(TreeNode a,TreeNode b){
        if(b==null)
            return true;
        if(a==null)
            return false;
        if(a.val==b.val)
            return isSubtree(a.left,b.left)&&isSubtree(a.right,b.right);
        else
            return false;
    }

     public static class TreeNode {
         int val = 0;
         TreeNode left = null;
         TreeNode right = null;

         public TreeNode(int val) {
         this.val = val;

         }

     }

}
