/*


Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.

Example:
Input:
         1
       /   \
      2     3
Output: 1
Explanation:
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1


 */


import java.util.*;

public class Leetcode_563_Binary_Tree_Tilt {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {

        private int res = 0;
        public int findTilt(TreeNode root) {
            if (root == null) return 0;
            helper(root);
            System.out.println("findTilt "+res);
            return res;
        }

        private int helper(TreeNode root) {
            if (root == null) return 0;
            int left = helper(root.left);
            int right = helper(root.right);
            // 左右子树的差的绝对值
            res += Math.abs(left - right);
            System.out.println(left+"  "+right+" "+root.val);//+"  "+res+"  "+(left + right + root.val));
            // 函数的返回值是当前根节点的值加上左右子树的和
            return    left + right + root.val;
        }
    }

    /*

                 1
             2       3
          4        5


     */

    public static void main(String[] arg){

        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);

        new Solution().findTilt(root);

    }

}
