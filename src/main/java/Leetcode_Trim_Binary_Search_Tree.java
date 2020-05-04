/*

Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree,
so the result should return the new root of the trimmed binary search tree.

Example 1:
Input:
    1
   / \
  0   2

  L = 1
  R = 2

Output:
    1
      \
       2
Example 2:
Input:
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

Output:
      3
     /
   2
  /
 1

 */

import apple.laf.JRSUIUtils;

public class Leetcode_Trim_Binary_Search_Tree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    static class Solution {
        public TreeNode trimBST(TreeNode root, int L, int R) {




            return null;
        }
    }

    public static void main(String[] args){

        TreeNode root;
        root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);

        root.right = new TreeNode(4);

        new Solution().trimBST(root, 1, 3);

    }

}





