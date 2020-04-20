package com.leecode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseBetween_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode m_pre = null,m_node = null;
        ListNode n_next = null,n_node = null;

        int count = 0;
        while (count <= n){

            count++;
            ListNode next = cur.next;
            if(count==m){
                m_pre = pre;
                n_node = cur;
            }
            if(count>m&&count<=n){
                cur.next = pre;
            }
            if(count==n+1){
                m_node = pre;
                n_next = cur;
                break;
            }
            pre = cur;
            cur = next;
        }
        m_pre.next = m_node;
        n_node .next= n_next;
        return head;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode res = new ReverseBetween_92().reverseBetween(node1,1,4);
        ListNode node = res;
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
