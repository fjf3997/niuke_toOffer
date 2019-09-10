package com.fjf.fenjie;

/**
 * 输入一个复杂链表（每个节点中有节点值，
 * 以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，
 * 否则判题程序会直接返回空）
 */
public class Clone {
    /**
     *解题思路：
     *1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
     *2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
     *3、拆分链表，将链表拆分为原链表和复制后的链表
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead==null){
            return null;
        }
        RandomListNode current = pHead;
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while(current!=null){
            RandomListNode cloneNode = new RandomListNode(current.label);
            RandomListNode next = current.next;
            current.next=cloneNode;
            cloneNode.next=next;
            current = next;
        }
        current=pHead;
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while(current!=null){
            current.next.random=current.random==null?null:current.random.next;
            current = current.next.next;
        }
        current = pHead;
        RandomListNode cloneHead = current.next;
        //3、拆分链表，将链表拆分为原链表和复制后的链表
        while(current!=null){
            RandomListNode clone = current.next;
            current.next=clone.next;
            clone.next=clone.next==null?null:clone.next.next;
            current=current.next;
        }
       return cloneHead;
    }
    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
