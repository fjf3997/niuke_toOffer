package com.fjf.robustne;

import java.util.Stack;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {
    public static ListNode ReverseList(ListNode head) {
        if(head==null)
            return null;
         /*
        1.保存当前节点的next节点
        2.修改当前节点next节点为pre（初值为null，因为反转后第一个节点的next节点为null）
        3.将当前节点存进pre
        4.进入next节点并循环
        注意：循环结束后，还需要再赋一次值，因为在倒数第二个节点的next修改后，循环就终止了，还需将最后一个节点next修改。
         */
        ListNode next=null,pre=null;
        while(head.next!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        head.next=pre;
        return head;


        //使用栈先进后出
        /*Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while(p!=null){
            stack.push(p);
            p=p.next;
        }
        ListNode new_head = stack.pop();
        p = new_head;
        while(!stack.isEmpty()){
            p.next=stack.pop();
            p=p.next;
        }
        p.next=null;
        return new_head;*/
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
        ListNode head = ReverseList(node1);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }

    }
}
