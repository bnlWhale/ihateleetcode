/*

You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /
  4

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())",
but you need to omit all the unnecessary empty parenthesis pairs.
And it will be "1(2(4))(3)".
Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \
      4

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example,
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.


 */


public class Leetcode_606_Cnstruct_String_Binary_Tree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    static class Solution {

        public String tree2str(TreeNode t) {

            if (t == null) return "";
            StringBuilder sb = new StringBuilder();
            helper(t, sb);
            // 去掉首尾的括号
            return sb.subSequence(1, sb.length() - 1).toString();

        }

        private void helper(TreeNode t, StringBuilder sb) {
            // 如果当前结点不存在，直接返回
            if (t == null) return;
            // 在当前结点值前面加上左括号
            sb.append("(" + t.val);
            // 如果左子结点不存在而右子结点存在，要在结果 sb 后加上个空括号
            if (t.left == null && t.right != null) sb.append("()");
            // 分别对左右子结点调用递归函数
            helper(t.left, sb);
            helper(t.right, sb);
            // 调用完之后要加上右括号，形成封闭的括号
            sb.append(")");
            System.out.println(sb.toString()+"  "+t.val);
        }
    }


    public static void main(String[] arg){

        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        //root.left.right = new TreeNode(3);

        root.right = new TreeNode(3);
        //root.right.left = new TreeNode(6);
        //root.right.right = new TreeNode(9);

        new Solution().tree2str(root);

    }
}
