/*


Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]


 */

import java.util.*;

public class Leetcode_113_Path_Sum_2 {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {

        public List<List<Integer>> pathSum(TreeNode root, int sum) {

            List<List<Integer>> list = new ArrayList<>();
            if(root == null){
                return list;
            }
            helper(list, root, 0, sum, new ArrayList<>());
            return list;
        }

        private void helper(List<List<Integer>> list, TreeNode node, int sum, int target, List<Integer> temp){

            if(node == null){
                return;
            }
            sum += node.val;
            temp.add(node.val);
            if(node.left == null && node.right == null && sum == target){
                list.add(new ArrayList<>(temp));
            }
            helper(list, node.left, sum, target, temp);
            helper(list, node.right, sum, target, temp);
            temp.remove(temp.size()-1);
        }
    }
}
