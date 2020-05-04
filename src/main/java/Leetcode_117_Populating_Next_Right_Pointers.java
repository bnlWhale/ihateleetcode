
/*

https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

                       1
                2             3
            4      5               7


Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,
"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}

Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":null,"right":null,"val":7},"right":null,"val":5},
"right":null,"val":4},"next":{"$id":"6","left":null,"next":null,"right":{"$ref":"5"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"6"},"val":1}

Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B.

 */

import java.util.*;

public class Leetcode_117_Populating_Next_Right_Pointers {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    static class Solution {

        public Node connect(Node root) {

            if(root == null){
                return root;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while(queue.size()>0){
                int size = queue.size();
                Node cur = null;
                for(int i=0;i<size;i++){

                    Node node = queue.poll();
                    if(i==0){
                        cur = node;
                    }else {
                        cur.next = node;
                        cur = node;
                    }


                    if(node.left != null){
                        queue.offer(node.left);
                    }
                    if(node.right != null){
                        queue.offer(node.right);
                    }
                }

            }
            return root;

        }

        // 迭代
        public void connect2(Node root) {
            Node start = root;
            // start类似于层序遍历中的每层的最左节点
            while (start != null) {
                Node cur = start;
                // cur类似于层序遍历中的一层中的各个节点
                while (cur != null) {
                    if (cur.left != null) {
                        cur.left.next = cur.right;
                    }
                    if (cur.right != null && cur.next != null) {
                        cur.right.next = cur.next.left;
                    }
                    cur = cur.next;
                }
                start = start.left;
            }
        }

        public void connect3(Node root) {
            // head类似于层序遍历中每层的最左节点
            Node head = null;
            // prev是当前节点的前驱节点
            Node prev = null;
            // cur类似于层序遍历中的一层中的各个节点
            Node cur = root;
            while (cur != null) {
                while (cur != null) {
                    if (cur.left != null) {
                        if (prev != null) {
                            prev.next = cur.left;
                        } else {
                            head = cur.left;
                        }
                        prev = cur.left;
                    }
                    if (cur.right != null) {
                        if (prev != null) {
                            prev.next = cur.right;
                        } else {
                            head = cur.right;
                        }
                        prev = cur.right;
                    }
                    cur = cur.next;
                }
                cur = head;
                prev = null;
                head = null;
            }
        }
    }



    public static void main(String[] args){


        Node node_1 = new Node(1, null, null, null);
        Node node_2 = new Node(2, null, null, null);
        Node node_3 = new Node(3, null, null, null);
        Node node_4 = new Node(4, null, null, null);
        Node node_5 = new Node(5, null, null, null);
        Node node_7 = new Node(7, null, null, null);

        node_1.left = node_2;
        node_1.left.left = node_4;
        node_1.left.right = node_5;
        node_1.right = node_3;
        node_1.right.right = node_7;

        new Solution().connect2(node_1);

    }


}
