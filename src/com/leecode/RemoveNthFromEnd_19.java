package com.leecode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next=head;
        ListNode p = dummyNode,q=dummyNode;
        for(int i=0;i<n+1;i++){
            assert q!=null;
            q = q.next;
        }
        while (q!=null){
            p=p.next;
            q=q.next;
        }
        ListNode delNode = p.next;
        p.next = delNode.next;
        delNode.next = null;
        return dummyNode.next;

    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        ListNode head = new ListNode(arr);
        ListNode ret = new RemoveNthFromEnd_19().removeNthFromEnd(head,2);
        System.out.println(ret);
    }
}
