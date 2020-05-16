package com.SwordToOffer;

import java.util.HashMap;

public class CopyRandomList_35 {
    private HashMap<Node,Node> map;
    public Node copyRandomList(Node head) {
        map = new HashMap<>();
        return dfs(head);
    }
    private Node dfs(Node head){
        if(head==null)
            return null;
        if(map.containsKey(head))
            return map.get(head);
        Node copy = new Node(head.val);
        map.put(head,copy);
        copy.next = dfs(head.next);
        copy.random = dfs(head.random);
        return copy;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
