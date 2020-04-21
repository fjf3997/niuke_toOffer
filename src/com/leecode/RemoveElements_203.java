package com.leecode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-linked-list-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveElements_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode virtualHead = new ListNode(0);
        virtualHead.next = head;
        ListNode cur = virtualHead;
        while (cur.next!=null){
            if(cur.next.val==val){
                ListNode delNode = cur.next;
                cur.next = delNode.next;
                delNode.next = null;
                continue;
            }
            cur = cur.next;
        }

        return virtualHead.next;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(arr);
        ListNode ret = new RemoveElements_203().removeElements(head,6);
        System.out.println(ret);
    }
}
