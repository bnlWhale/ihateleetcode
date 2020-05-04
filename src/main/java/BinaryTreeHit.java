/*




Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

        _______9______
       /              \
    ___6__          ___1__
   /      \        /      \
  3       _5       0       8
         /  \
         3   7




 */


import java.util.*;


public class BinaryTreeHit {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }



    private void preOrderTraversal(TreeNode root){

        List<Integer> list = new ArrayList<>();
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(stack.size()>0){
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right != null){
                stack.add(node.right);
            }
            if(node.left != null){
                stack.add(node.left);
            }
        }
        System.out.println("preOrder:"+Arrays.toString(list.toArray()));

    }

    private void inOrderTraversal(TreeNode root){

        if(root == null){
            return;
        }
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while(cur != null || stack.size()>0){

            while(cur != null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        System.out.println("inOrder:"+Arrays.toString(list.toArray()));
    }


    private void postOrderTraversal(TreeNode root){

        if(root == null){
            return;
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (stack.size()>0){

            TreeNode node = stack.pop();
            list.add(0, node.val);
            if(node.left != null){
                stack.add(node.left);
            }
            if(node.right != null){
                stack.add(node.right);
            }
        }
        System.out.println("postOrder:"+Arrays.toString(list.toArray()));
    }

    private int sumOfTree(TreeNode root){

        if(root == null){
            return 0;
        }
        return root.val+ sumOfTree(root.left)+ sumOfTree(root.right);
    }

    private int maxLevelOfTree(TreeNode root){

        if(root == null){
            return 0;
        }
        return 1 + Math.max(maxLevelOfTree(root.left), maxLevelOfTree(root.right));
    }

    private void pathSumOfTreeByRoot(TreeNode root, List<Integer> tempList, int sum, int total){

        if(root == null){
            return;
        }
        sum += root.val;
        tempList.add(root.val);
        if(sum == total && root.left == null && root.right == null){
            System.out.println("pathSumOfTreeByRoot:"+Arrays.toString(tempList.toArray())+"  target:"+total);
        }
        pathSumOfTreeByRoot(root.left, tempList, sum, total);
        pathSumOfTreeByRoot(root.right, tempList, sum, total);
        tempList.remove(tempList.size()-1);
    }

    private void pathSumOfTreeByNode(TreeNode root, int total){

        if(root == null){
            return;
        }
        if(root.val == 3){
            System.out.println();
        }
        pathSumOfTreeByRoot(root, new ArrayList<>(), 0, total);
        pathSumOfTreeByNode(root.left, total);
        pathSumOfTreeByNode(root.right, total);
    }


    public static void main(String[] arg){

        TreeNode root;
        root = new TreeNode(9);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(7);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        BinaryTreeHit bth = new BinaryTreeHit();

        bth.preOrderTraversal(root);
        bth.postOrderTraversal(root);
        bth.inOrderTraversal(root);
        System.out.println("sum of Node: "+bth.sumOfTree(root));
        System.out.println("level of Tree: "+bth.maxLevelOfTree(root));

        List<Integer> tempList = new ArrayList<>();
        //bth.pathSumOfTreeByRoot(root, tempList, 0, 18);

        bth.pathSumOfTreeByNode(root,18);
    }
}
