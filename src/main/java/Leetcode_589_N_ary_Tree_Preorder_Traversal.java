/*

Given an n-ary tree, return the preorder traversal of its nodes' values.

For example, given a 3-ary tree:


                      1

                3     2     4

             5     6




Return its preorder traversal as: [1,3,5,6,2,4].


 */

import java.util.*;

public class Leetcode_589_N_ary_Tree_Preorder_Traversal {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    static class Solution {
        public List<Integer> preorder(Node root) {

            List<Integer> list = new ArrayList<>();
            if (root == null) return list;

            Stack<Node> stack = new Stack<>();
            stack.add(root);

            while (!stack.empty()) {
                root = stack.pop();
                list.add(root.val);
                for (int i = root.children.size() - 1; i >= 0; i--)
                    stack.add(root.children.get(i));
            }
            System.out.println(Arrays.toString(list.toArray()));
            return list;

        }

    }

    public static void main(String[] args){

        Node node_1 = new Node(1,null);
        Node node_5 = new Node(5, null);
        Node node_6 = new Node(6, null);
        Node node_2 = new Node(2, null);
        Node node_4 = new Node(4,null);
        Node node_3 = new Node(3, null);
        List<Node> list = new ArrayList<>();
        list.add(node_3);
        list.add(node_2);
        list.add(node_4);
        node_1.children = list;

        list = new ArrayList<>();
        list.add(node_5);
        list.add(node_6);
        node_3.children = list;

        new Solution().preorder(node_1);
    }

}
