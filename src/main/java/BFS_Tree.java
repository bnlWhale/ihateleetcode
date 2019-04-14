/*






 */



import java.util.*;


public class BFS_Tree {


    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    public void levelOrderQueue(Node root) {

        Node subRoot = root;
        if (subRoot == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(subRoot);
        while (queue.size() > 0) {
            Node node = queue.remove();
            System.out.println(node.data);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

    }


    public void levelOrderArray(Node root) {

        List<List<Integer>> ans = new ArrayList<>();
        levelOrderHelper(root, 0, ans);
        ans.stream().forEach(arg->System.out.println(Arrays.toString(arg.toArray())));
    }


    private void levelOrderHelper(Node node, int index, List<List<Integer>> ans) {

        if (node == null) {
            return;
        }
        List<Integer> tempList;
        if (ans.isEmpty() || ans.size()<index+1) {
            tempList = new ArrayList<>();
            ans.add(tempList);
        }
        else {
            tempList = ans.get(index);
        }
        tempList.add(node.data);
        levelOrderHelper(node.left, index + 1, ans);
        levelOrderHelper(node.right, index + 1, ans);

    }

    /*


          1
        /    \
       2      3
      / \    / \
     4   5  6   7
             \   \
              8   9



     */


    private void verticalOrder(Node node, int index, Map<Integer, List<Integer>> ans){

        if(node==null){
            return;
        }
        List<Integer> tempList;
        if(ans.containsKey(index)){
            tempList = ans.get(index);
        }else{
            tempList = new ArrayList<>();
            ans.put(index, tempList);
        }
        tempList.add(node.data);
        verticalOrder(node.left, index-1, ans);
        verticalOrder(node.right, index+1, ans);
    }


    private int getHeight(Node root){
        if(root==null)return 0;
        return (1+ Math.max(getHeight(root.left), getHeight(root.right)));
    }

    public static void main(String[] args) throws java.lang.Exception {

        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.right.left = new Node(30);
        root.right.right = new Node(35);

        BFS_Tree i = new BFS_Tree();
        //System.out.println("Breadth First Search : ");
       // i.levelOrderQueue(root);
        //i.levelOrderArray(root);



        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);

        Map<Integer, List<Integer>> result = new TreeMap<>();
        i.verticalOrder(root, 0, result);
        result.keySet().stream().forEach(arg->{List<Integer> list = result.get(arg); System.out.println(arg+"  "+Arrays.toString(list.toArray()));});

        int height = i.getHeight(root);
        System.out.println("tree height:"+height);

    }
}





