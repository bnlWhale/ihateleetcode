
/*

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

 */


public class Leetcode_105_Construct_Binary_Tree_Preorder_Inorder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || inorder == null || preorder.length != inorder.length) return null;
            return helper(0, 0, inorder.length - 1, preorder, inorder);
        }

        private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
            if (preStart > preorder.length - 1 || inStart > inEnd) {
                return null;
            }
            // preorder的第一个元素一定是二叉树的根节点
            TreeNode root = new TreeNode(preorder[preStart]);
            // 表示在inorder中当前根节点的位置
            int inRoot = 0;
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == root.val) {
                    inRoot = i;
                    break;
                }
            }
            // preorder中当前根节点右边一个元素一定是根节点的左孩子
            // 左孩子一定在preorder的后部分[preStart+1,end]中，inorder的前部分[inStart,inIndex-1]中
            root.left = helper(preStart + 1, inStart, inRoot - 1, preorder, inorder);
            // inorder中当前根节点右边一个元素一定是根节点的右孩子
            // 通过inorder找到左孩子一共有多少个(inIndex-inStart)，这样就可以得到右子树的起始位置
            root.right = helper(preStart + (inRoot - inStart) + 1, inRoot + 1, inEnd, preorder, inorder);
            return root;
        }


    }

    public static void main(String[] arg){

        TreeNode root;
        root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        //root.left.right = new TreeNode(3);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(9);

        int[] preOrder = {5,4,11,8,13,9};
        int[] inOrder = {11,4,5,13,8,9};

        new Solution().buildTree(preOrder, inOrder);

    }
}
