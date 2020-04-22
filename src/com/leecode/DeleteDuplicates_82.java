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
    /**
     * 定义一个 dummy 头结点，链接上原链表，cur 指向原链表头部
     * ① 当前结点value ！= 当前结点的下一结点value。那么让pre指针来到当前结点，
     * 这样就链接了前一结点和当前结点。然后当前结点移至下一结点
     * ② 当前结点value == 当前结点的下一结点value。那么就让 cur 一直往下走直到
     * 当前结点value ！= 当前结点的下一结点value，然后此时是不能动 pre 指针的，
     * 要避免后面还有重复的，所以让 pre->next = cur->next。然后当前结点移至下一结点。
     * 循环结束的条件结合例子即可，如[1,1]
     * > - 时间复杂度：O(n) > - 空间复杂度：O(1)
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode cur = head;
        while (cur.next!=null){
            if(cur.val!=cur.next.val){
                p=cur;
            }else {
                while (cur.next!=null&&cur.val==cur.next.val){
                    cur=cur.next;
                }
                if(cur.next==null){
                    p.next = null;
                    break;
                }
                p.next = cur.next;

            }
            cur = cur.next;


        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int [] arr = {1,1,2,3,3,4,4,5};
        int [] arr2 = {1,1};
        ListNode head = new ListNode(arr2);
        ListNode ret = new DeleteDuplicates_82().deleteDuplicates(head);
        System.out.println(ret);
    }

}
