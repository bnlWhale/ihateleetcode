/*

Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1

 */


import java.util.*;

public class Leetcode_226_Invert_Binary_Tree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return root;
            // 将当前节点的左右分支进行对调反转
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            // 若左分支存在，则递归左分支的节点
            if (root.left != null) invertTree(root.left);
            // 若右分支存在，则递归右分支的节点
            if (root.right != null) invertTree(root.right);
            // 所有的节点遍历完成后，返回根节点
            return root;
        }
    }

    public static void main(String[] arg){
        TreeNode root;
        root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode node = new Solution().invertTree(root);
        //System.out.println(node.val);

        System.out.println("iterative traversal inorder");
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || stack.size()>0){
          while (cur != null){
              System.out.println(cur.val);
              stack.push(cur);
              cur = cur.left;
          }
          cur = stack.pop();
          cur = cur.right;
        }

    }


}
