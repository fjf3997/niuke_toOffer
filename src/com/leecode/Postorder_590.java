package com.leecode;

import java.util.ArrayList;
import java.util.List;

public class Postorder_590 {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        post(root,list);
        return list;
    }

    private void post(Node root, List<Integer> list) {
        if(root==null){
            return;
        }
        if(iterable(root.children)){
            for (Node node : root.children) {
                post(node,list);
            }
        }
        list.add(root.val);

    }
    private <T> boolean  iterable(List<T> list){
        return list!=null&&!list.isEmpty();
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};