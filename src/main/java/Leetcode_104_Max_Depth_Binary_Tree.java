/*


Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

    1
   / \
  2  3
 / \
4   5

return its depth = 3.




 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode_104_Max_Depth_Binary_Tree {


    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    static class Solution {

        public int maxDepth(TreeNode root) {

            //recursive(root, 0);
            iterater(root);
            return 0;

        }

        public void recursive(TreeNode node, int index) {

            if (node == null) {
                return;
            }
            index++;
            recursive(node.left, index);
            System.out.println(node.val + " " + index);
            recursive(node.right, index);
        }


        public int maxDepth_1(TreeNode root) {
            if(root==null){
                return 0;
            }
            return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
        }

        public void iterater(TreeNode root) {

            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            while (curr != null || !stack.isEmpty()) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                System.out.println(curr.val);
                res.add(curr.val);
                curr = curr.right;
            }

        }

    }

    private static void doAction() {

        TreeNode tn = new TreeNode(3);
        tn.left = new TreeNode(9);
        tn.right = new TreeNode(20);
        tn.right.left = new TreeNode(15);
        tn.right.right = new TreeNode(7);
        new Solution().maxDepth(tn);
    }

    public static void main(String[] args) {

        doAction();

    }
}
