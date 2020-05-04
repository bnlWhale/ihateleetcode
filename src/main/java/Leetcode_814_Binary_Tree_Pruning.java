/*


We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.

Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

(Recall that the subtree of a node X is X, plus every node that is a descendant of X.)

Example 1:
Input: [1,null,0,0,1]
Output: [1,null,0,null,1]

Explanation:
Only the red nodes satisfy the property "every subtree not containing a 1".
The diagram on the right represents the answer.

 */


public class Leetcode_814_Binary_Tree_Pruning {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution{

        public TreeNode pruneTree(TreeNode root) {



            helper(root, null);


            //System.out.println(root.val);

            return root;
        }

        private void helper(TreeNode root, TreeNode parent){

            if(root == null){
                return;
            }

            helper(root.left, root);
            helper(root.right, root);
            if(root.val == 0){
                if(root.left == null && root.right == null){
                    if(parent != null){
                        if(parent.left == root){
                            parent.left = null;
                        }
                        if(parent.right == root){
                            parent.right = null;
                        }
                    }
                }
                else if(root.left == null && root.right.val == 0){
                    if(parent != null){
                        if(parent.left == root){
                            parent.left = null;
                        }
                        if(parent.right == root){
                            parent.right = null;
                        }
                    }
                }
                else if(root.right == null && root.left.val == 0){
                    if(parent != null){
                        if(parent.left == root){
                            parent.left = null;
                        }
                        if(parent.right == root){
                            parent.right = null;
                        }
                    }
                }
            }

        }
    }

    public static void main(String[] args){

        TreeNode root;
        root = new TreeNode(1);


        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        new Solution().pruneTree(root);
        System.out.println(root);
    }

}
