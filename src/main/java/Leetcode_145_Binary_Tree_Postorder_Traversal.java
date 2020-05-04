/*


Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]


 */

import java.util.*;

public class Leetcode_145_Binary_Tree_Postorder_Traversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    static class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {

            LinkedList<Integer> results = new LinkedList<>();
            if (root == null) return results;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                results.addFirst(node.val);
                if (node.left!=null) stack.push(node.left);
                if (node.right!=null) stack.push(node.right);
            }
            System.out.println(Arrays.toString(results.toArray()));
            return results;
        }

        public int countNodeNum(TreeNode node){

            if(node == null){
                return 0;
            }
            return 1+countNodeNum(node.left)+countNodeNum(node.right);
        }
    }



    public static void main(String[] arg){

        TreeNode root;
        root = new TreeNode(1);
        //root.left = new TreeNode(2);
        //root.left.left = new TreeNode(1);
        //root.left.right = new TreeNode(3);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        //root.right.right = new TreeNode(9);

        new Solution().postorderTraversal(root);

        System.out.println("num of node:"+new Solution().countNodeNum(root));
    }
}
