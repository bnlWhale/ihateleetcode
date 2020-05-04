/*


Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3


 */


import java.util.*;

public class Leetcode_257_BinaryTree_Path {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public List<String> binaryTreePaths(TreeNode root) {

            List<String> result = new ArrayList<>();
            helper(root, result, "");
            return result;
        }

        public void helper(TreeNode root, List<String> strList, String str){

            if(root == null){
                return;
            }
            str = str+root.val;
            if(root.left != null || root.right != null){
                str += "->";
            }
            if(root.left == null && root.right == null){
                strList.add(str);
                System.out.println(str);
            }

            helper(root.left, strList, str);
            helper(root.right, strList, str);
        }
    }

    public static void main(String[] arg){
        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);

        new Solution().binaryTreePaths(root);
    }
}
