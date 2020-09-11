package com.test;

import java.util.Scanner;

/**
 * 6
 * 6 5 4 3 2 1
 * 5
 * 6 5 3 2 1
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode list1 = null,pre = null,list2 = null;
        for(int i = 0; i < n; i++){
            int num = sc.nextInt();
            ListNode node = new ListNode(num);
            if(i==0){
                list1 = new ListNode(num);
                pre = list1;
            }else{
                pre.next = node;
                pre = node;
            }

        }
        int m = sc.nextInt();
        for(int i = 0; i <m; i++){
            int num = sc.nextInt();
            ListNode node = new ListNode(num);
            if(i==0){
                list2 = new ListNode(num);
                pre = list2;
            }else {
                pre.next = node;
                pre = node;
            }

        }
        ListNode node1 = list1,node2 = list2;
        ListNode ans = null,cur=null;
        while (node1!=null&&node2!=null){
            if(node1.val==node2.val){
                if(ans==null){
                    ans = new ListNode(node1.val);
                    pre = ans;
                }else {
                    cur = new ListNode(node1.val);
                    pre.next = cur;
                    pre = cur;
                }
                node1 = node1.next;
                node2 = node2.next;
            }else if(node1.val<node2.val){
                node2 = node2.next;
            }else {
                node1 = node1.next;
            }
        }
        while (list1!=null){
            System.out.print(list1.val+" ");
            list1 = list1.next;
        }
        System.out.println();
        while (list2!=null){
            System.out.print(list2.val+" ");
            list2 = list2.next;
        }
        System.out.println();
        while (ans!=null){
            System.out.print(ans.val+" ");
            ans = ans.next;
        }

    }
}
class ListNode {

    public int val;
    public ListNode next = null;

    public ListNode(int x) {
        val = x;
    }

    // 根据n个元素的数组arr创建一个链表
    // 使用arr为参数，创建另外一个ListNode的构造函数
    public ListNode (int[] arr){

        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty");

        this.val = arr[0];
        ListNode curNode = this;
        for(int i = 1 ; i < arr.length ; i ++){
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
    }

    // 返回以当前ListNode为头结点的链表信息字符串
    @Override
    public String toString(){

        StringBuilder s = new StringBuilder("");
        ListNode curNode = this;
        while(curNode != null){
            s.append(Integer.toString(curNode.val));
            s.append(" -> ");
            curNode = curNode.next;
        }
        s.append("NULL");
        return s.toString();
    }
}
