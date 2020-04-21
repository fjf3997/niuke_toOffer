package com.leecode;

/**
 *
 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

 示例 1:

 输入: 1->2->3->3->4->4->5
 输出: 1->2->5
 示例 2:

 输入: 1->1->1->2->3
 输出: 2->3
 */
//TODO
public class DeleteDuplicates_82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        int val = head.val;
        while (cur.next.next!=null){
            if(cur.next.next.val==val){
                ListNode delNode = cur.next;
                cur.next = delNode.next;
                delNode.next = null;
            }else {
                cur = cur.next;
                val = cur.next.val;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,3,4,4,5};
        ListNode head = new ListNode(arr);
        ListNode ret = new DeleteDuplicates_82().deleteDuplicates(head);
        System.out.println(ret);
    }

}
