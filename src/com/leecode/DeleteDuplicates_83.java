package com.leecode;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteDuplicates_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        ListNode cur = head.next,pre=head;
        int val = head.val;
        while (cur!=null){
            ListNode next = cur.next;
            if(val==cur.val){
                pre.next=next;
                cur.next=null;
                cur = next;
                continue;
            }
            pre = cur;
            val = pre.val;
            cur = next;
        }
        return head;
    }

    public static void main(String[] args) {
        int [] arr = {1,1,2,3,3};
        ListNode head = new ListNode(arr);
        ListNode new_head = new DeleteDuplicates_83().deleteDuplicates(head);
        System.out.println(new_head);
    }
}
