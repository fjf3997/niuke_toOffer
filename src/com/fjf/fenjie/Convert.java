package com.fjf.fenjie;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Convert {
    public static void main(String[] args) {
        //{10,6,14,4,8,12,16}
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(14);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(8);
        TreeNode t6 = new TreeNode(12);
        TreeNode t7 = new TreeNode(16);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;
        t4.left=null;
        t4.right=null;
        t5.left=null;
        t5.right=null;
        t6.left=null;
        t6.right=null;
        t7.left=null;
        t7.right=null;
        Convert convert = new Convert();
        TreeNode t = convert.Convert(t1);
        TreeNode tt = t;
        while(t!=null){
            System.out.print(t.val+"  ");
            t=t.right;
        }
        while(tt.right!=null)tt=tt.right;
        System.out.println();
        while(tt!=null){
            System.out.print(tt.val+"  ");
            tt=tt.left;
        }


    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null)
            return null;
        //中序遍历bfs即为有序遍历
//        ArrayList<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRootOfTree;
        TreeNode pre = null;
        TreeNode root = null;
        boolean isFirst = true;
        while(cur!=null||!stack.empty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur = stack.pop();
            if(isFirst){
                root = cur;
                pre = cur;
                isFirst = false;
            }else{
                cur.left=pre;
                pre.right=cur;
                pre=cur;
            }
            cur=cur.right;
        }
        return root;
        /*int size = list.size()-1;
        TreeNode l = null;
        TreeNode r = null;
        for(int i=0;i<size - 1;i++){
            l = list.get(i);
            r = list.get(i+1);
            l.right=r;
            r.left=l;
        }
        l = list.get(0);
        r = list.get(size);
        l.left=null;
        r.right=null;
        r.left=list.get(size-1);
        return l;*/
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
