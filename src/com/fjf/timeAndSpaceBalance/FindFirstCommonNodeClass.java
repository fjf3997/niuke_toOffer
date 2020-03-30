package com.fjf.timeAndSpaceBalance;

import java.util.HashMap;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class FindFirstCommonNodeClass {
    //用HasnMap的特性
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashMap<ListNode,Integer> map = new HashMap<>();
        while (pHead1!=null){
            map.put(pHead1,1);
            pHead1 = pHead1.next;
        }
        while (pHead2!=null){
            if(map.containsKey(pHead2)){
                return pHead2;
            }
            pHead2 = pHead2.next;

        }
        return null;
        /*ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1!=p2){
            p1 = (p1==null?pHead2:p1.next);
            p2 = (p2==null?pHead1:p2.next);
        }
        return p1;*/

    }

    public static void main(String[] args) {
        ListNode fNode1 = new ListNode(1);
        ListNode fNode2 = new ListNode(3);
        ListNode fNode3 = new ListNode(4);
        ListNode fNode4 = new ListNode(5);
        fNode1.next = fNode2;
        fNode2.next = fNode3;
        fNode3.next = fNode4;
        ListNode sNode1 = new ListNode(2);
        ListNode sNode2 = new ListNode(4);
        ListNode sNode3 = new ListNode(6);
        ListNode sNode4 = new ListNode(8);
        ListNode sNode5 = new ListNode(10);
//        sNode1.next = fNode3;
//        fNode3.next = sNode3;
        sNode1.next = sNode2;
        sNode2.next = sNode3;
        sNode3.next = sNode4;
        ListNode listNode = FindFirstCommonNode(fNode1, sNode1);
        System.out.println(listNode.val);
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

