/*

Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2

 */



public class Leetcode_572_Subtree_of_Another_Tree {



    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {

        String strLeft = "";
        String strRight = "";

        public boolean isSubtree(TreeNode s, TreeNode t) {

            String str1 = preOrder(s, "center");
            String str2 = preOrder(t,"center");

            collect(s, "center");

            System.out.println(str1);
            System.out.println(str2);
            System.out.println((str1.indexOf(str2)>-1));
            return str1.indexOf(str2)>-1;
        }

        private String preOrder(TreeNode node, String dir){

            if(node == null){
                return dir;
            }
            return "#"+node.val+preOrder(node.left, "#left")+preOrder(node.right, "#right");
        }

        private String collect(TreeNode node, String dir) {
            if (node == null) return "#"+dir;
            String serial = node.val + "," + collect(node.left, " left") + "," + collect(node.right, " right");
            //count.put(serial, count.getOrDefault(serial, 0) + 1);
            //if (count.get(serial) == 2)
               // ans.add(node);
            //serial = serial.substring(0, serial.length()-1);
            System.out.println("collect:"+serial+"  node.val:"+node.val);
            return serial;
        }
    }

    public static void main(String[] args){


        TreeNode root;
        root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        root.right = new TreeNode(5);
        root.right.left = new TreeNode(3);
        //root.right.right = new TreeNode(9);

        TreeNode root_1;
        root_1 = new TreeNode(4);
        root_1.left = new TreeNode(1);
        //root_1.left.left = new TreeNode(1);
        //root_1.left.right = new TreeNode(2);

        root_1.right = new TreeNode(2);
        //root_1.right.left = new TreeNode(3);
        //root_1.right.right = new TreeNode(9);

        new Solution().isSubtree(root, root_1);

    }
}
