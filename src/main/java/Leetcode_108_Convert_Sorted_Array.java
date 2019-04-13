/*


Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5


 */


public class Leetcode_108_Convert_Sorted_Array {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static  class Solution {

        public TreeNode sortedArrayToBST(int[] num) {
            if (num.length == 0) {
                return null;
            }
            TreeNode head = helper(num, 0, num.length - 1);
            return head;
        }

        public TreeNode helper(int[] num, int low, int high) {
            if (low > high) { // Done
                //System.out.println("---"+low+"  "+high);
                return null;
            }
            int mid = (low + high) / 2;
            TreeNode node = new TreeNode(num[mid]);
            System.out.println("before:"+num[mid]+"   "+mid+"  "+" low:"+low+"  "+high);
            node.left = helper(num, low, mid - 1);
            node.right = helper(num, mid + 1, high);
            System.out.println(node.val+"  ");
            return node;
        }

    }

    public static void main(String[] args){

        int[] nums = {-10,-3,0,5,9};
        new Solution().sortedArrayToBST(nums);

    }

}
