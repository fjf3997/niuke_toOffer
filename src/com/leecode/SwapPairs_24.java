package com.leecode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwapPairs_24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyListNode = new ListNode(0);
        dummyListNode.next = head;
        ListNode p = dummyListNode;
        while (p.next!=null&&p.next.next!=null){
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;
            p.next = node2;
            node2.next = node1;
            node1.next = next;
            p = node1;
        }
        return dummyListNode.next;
    }

    public static void main(String[] args) {
        int arr [] = {1,2,3,4};
        ListNode head = new ListNode(arr);
        ListNode ret = new SwapPairs_24().swapPairs(head);
        System.out.println(ret);
    }
}
