package com.fjf.robustne;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {
    /**
     * 快慢指针 快指针先往前走k步，注意判断边界，
     * 然后快慢一起走，当快指针为none的时候，
     * 慢指针走到了倒数第k个节点
     * @param head
     * @param k
     * @return
     */
    public static ListNode FindKthToTail(ListNode head, int k) {
        if(head==null||k<=0)
            return null;
        ListNode fast=head,slow=head;
        for (int i = 1; i < k; i++) {
            fast=fast.next;
            if(fast==null)
                return null;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
       /* int total = 1;
        ListNode p = head;
        while(p.next!=null){
            total++;
            p = p.next;
        }
        int to = total - k;
        p = head;
        for(int i=1;i<=to;i++){
            p = p.next;
        }
        return p;*/
    }
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        ListNode target = FindKthToTail(node1,2);
        System.out.println(target.val);

    }
}
