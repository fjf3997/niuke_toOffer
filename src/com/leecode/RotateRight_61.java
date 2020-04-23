package com.leecode;

/**
 *
 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 示例 1:
 输入: 1->2->3->4->5->NULL, k = 2
 输出: 4->5->1->2->3->NULL
 解释:
 向右旋转 1 步: 5->1->2->3->4->NULL
 向右旋转 2 步: 4->5->1->2->3->NULL
 示例 2:
 输入: 0->1->2->NULL, k = 4
 输出: 2->0->1->NULL
 解释:
 向右旋转 1 步: 2->0->1->NULL
 向右旋转 2 步: 1->2->0->NULL
 向右旋转 3 步: 0->1->2->NULL
 向右旋转 4 步: 2->0->1->NULL
 */
public class RotateRight_61 {
    public ListNode rotateRight(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;
        while (temp!=null){
            count++;
            temp=temp.next;
        }
        if(count==0)
            return head;
        k = k%count;
        if(k==0)
            return head;
        ListNode p = head;
        ListNode q = head;
        for(int i=0;i<k;i++){
            q=q.next;
        }
        while (q.next!=null){
            p=p.next;
            q=q.next;
        }
        ListNode ret = p.next;
        p.next = null;
        q.next = head;

        return ret;
    }

    public static void main(String[] args) {
        int [] arr = {0,1,2};
        int [] arr2 = {1,2,3,4,5};
        ListNode head = new ListNode(arr2);
        ListNode ret = new RotateRight_61().rotateRight(head, 2);
        System.out.println(ret);
    }
}
