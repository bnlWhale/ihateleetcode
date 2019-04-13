
/*


Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.

Example :

Input: root = [4,2,6,1,3,null,null]
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

          4
        /   \
      2      6
     / \
    1   3

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
Note:

The size of the BST will be between 2 and 100.
The BST is always valid, each node's value is an integer, and each node's value is different.


 */




public class Leetcode_783_Minimum_Distance_Between_BST_Nodes {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    static class Solution {
        int result = Integer.MAX_VALUE;
        int pre = -1;
        public int minDiffInBST(TreeNode root) {


            recursive(root);
            System.out.println(result);
            return result;
        }


        private void recursive(TreeNode root){
            if(root==null){
                return;
            }
            recursive(root.left);
            if(pre != -1){
                result = Math.min(result, root.val-pre);
            }

            pre = root.val;
            recursive(root.right);
        }
    }


    public static void main(String[] args){

        TreeNode tn = new TreeNode(4);
        tn.left = new TreeNode(2);
        tn.right = new TreeNode(6);
        tn.left.left = new TreeNode(1);
        tn.left.right = new TreeNode(3);

        new Solution().minDiffInBST(tn);

    }

}
