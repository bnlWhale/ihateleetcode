/*


Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True


Example 2:

Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False



 */

import java.util.*;

public class Leetcode_653_Two_Sum_Input_BST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public boolean findTarget(TreeNode root, int k) {

            boolean[] ans = {false};
            recurInorder(root, new HashMap<>(), ans, k);
            System.out.println(ans[0]);
            return ans[0];

        }


        private void recurInorder(TreeNode root, Map<Integer, Integer> record, boolean[] ans, int target){
            if(root == null){
                return;
            }
            if(record.containsKey(root.val)){
                ans[0] = true;
            }else{
                record.put(target-root.val, 0);
            }

            recurInorder(root.left, record, ans, target);
            recurInorder(root.right, record, ans, target);
        }
    }


    public static void main(String[] args){

        TreeNode head = new TreeNode(5);
        TreeNode node = head;
        TreeNode oneNode_3 = new TreeNode(3);
        node.left = oneNode_3;
        TreeNode oneNode_2 = new TreeNode(2);
        oneNode_3.left = oneNode_2;
        TreeNode oneNode_4 = new TreeNode(4);
        oneNode_3.right = oneNode_4;
        TreeNode oneNode_6 = new TreeNode(6);
        head.right = oneNode_6;
        TreeNode oneNode_7 = new TreeNode(7);
        oneNode_6.right = oneNode_7;

        int k=9;
        new Solution().findTarget(head,k);

    }

}
