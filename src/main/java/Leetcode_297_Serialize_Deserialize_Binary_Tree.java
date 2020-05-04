/*


Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network
connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure
that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example:

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"

 */
import java.util.*;

public class Leetcode_297_Serialize_Deserialize_Binary_Tree {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    static class Codec {

        private static final String spliter = ",";
        private static final String NN = "X";

        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            //buildString(root, sb);


            String result = serializeOne(root);
            System.out.println(result);
            return result;

            //buildStringIterative(root, sb);
            //System.out.println(sb.toString());
            //return sb.toString();
        }

        private void buildString(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append(NN).append(spliter);
            } else {
                sb.append(node.val).append(spliter);
                buildString(node.left, sb);
                buildString(node.right, sb);
            }
        }

        private void buildStringIterative(TreeNode node, StringBuilder sb){

            if(node != null){

                Queue<TreeNode> queue = new LinkedList<>();
                queue.offer(node);
                while(queue.size()>0){
                    TreeNode aNode = queue.poll();
                    sb.append(aNode.val).append(spliter);
                    if(aNode.left != null){
                        queue.add(aNode.left);
                    }else{
                        sb.append(NN).append(spliter);
                    }
                    if(aNode.right != null){
                        queue.add(aNode.right);
                    }else{
                        sb.append(NN).append(spliter);
                    }
                }


            }

        }


        private static final String DELIMITER = ",";
        private static final String NULL_NODE = "NULL";

        // Encodes a tree to a single string.
        public String serializeOne(TreeNode root) {
            if (root == null)   return "#";
            //return root.val + "," + serializeOne(root.left) +","+serializeOne(root.right);
            String res = root.val + "," + serializeOne(root.left) +","+serializeOne(root.right);
            System.out.println("inside:"+res);
            return res;
        }
    }


    public static void main(String[] args){


        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        //root.left.left = new TreeNode(1);
        //root.left.right = new TreeNode(2);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);


        new Codec().serialize(root);

    }
}
