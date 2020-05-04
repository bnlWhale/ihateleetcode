/*


Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4


Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.



 */


import java.util.*;

public class Leetcode_216_Lowest_Common_Ancestor_Binary_Tree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    static class Solution_1 {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            // Stack for tree traversal
            Deque<TreeNode> stack = new ArrayDeque<>();

            // HashMap for parent pointers
            Map<TreeNode, TreeNode> parent = new HashMap<>();

            parent.put(root, null);
            stack.push(root);

            // Iterate until we find both the nodes p and q
            while (!parent.containsKey(p) || !parent.containsKey(q)) {

                TreeNode node = stack.pop();

                // While traversing the tree, keep saving the parent pointers.
                if (node.left != null) {
                    parent.put(node.left, node);
                    stack.push(node.left);
                }
                if (node.right != null) {
                    parent.put(node.right, node);
                    stack.push(node.right);
                }
            }

            // Ancestors set() for node p.
            Set<TreeNode> ancestors = new HashSet<>();

            // Process all ancestors for node p using parent pointers.
            while (p != null) {
                ancestors.add(p);
                p = parent.get(p);
            }

            // The first ancestor of q which appears in
            // p's ancestor set() is their lowest common ancestor.
            while (!ancestors.contains(q))
                q = parent.get(q);
            return q;
        }

    }


    static class Solution_2 {

        private TreeNode ans;

        public Solution_2() {
            // Variable to store LCA node.
            this.ans = null;
        }

        private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

            // If reached the end of a branch, return false.
            if (currentNode == null) {
                return false;
            }

            // Left Recursion. If left recursion returns true, set left = 1 else 0
            int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

            // Right Recursion
            int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

            // If the current node is one of p or q
            int mid = (currentNode == p || currentNode == q) ? 1 : 0;


            // If any two of the flags left, right or mid become True
            if (mid + left + right >= 2) {
                this.ans = currentNode;
            }

            // Return true if any one of the three bool values is True.
            return (mid + left + right > 0);
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // Traverse the tree
            this.recurseTree(root, p, q);
            return this.ans;
        }
    }


    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 叶子节点左右孩子都为空，这时候返回null
            if (root == null) return null;
            // 发现目标节点则通过返回值标记该子树发现了某个目标结点
            if (root == p || root == q) {
                System.out.println("return root "+root);
                return root;
            }
            // Divide
            // 查看左子树中是否有目标结点，没有为null
            System.out.println("   left into "+root.left);
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            // 查看右子树是否有目标节点，没有为null
            System.out.println("   right into "+root.right);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            // Conquer
            // 左右节点都不为空，说明左右子树都有目标结点，则公共祖先就是本身
            if (left != null && right != null) {
                System.out.println("--- find target:"+root);
                return root;
            }

            // 如果发现了目标节点，则继续向上标记为该目标节点
            System.out.println(" *** return left :"+root.val+" "+(left == null ? right : left));
            return left == null ? right : left;
        }





    }

    public static void main(String[] arg){
        TreeNode root;
        root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode p = root.left.left;
        TreeNode q = root.left.right.right;

       //TreeNode result = new Solution().lowestCommonAncestor(root, p, q);
        //System.out.println("main return "+result+"  "+result.val);

        new Solution_1().lowestCommonAncestor(root, p, q);

    }


}
