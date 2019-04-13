
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
         if(subRoot == null) {
             return;
         }
         Queue<Node> queue = new LinkedList<>();
         queue.add(subRoot);
         while(queue.size()>0) {
             Node node = queue.remove();
             System.out.println(node.data);
             if(node.left!=null) {
                queue.add(node.left);
             }
             if(node.right!=null) {
                 queue.add(node.right);
             }
         }

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
        System.out.println("Breadth First Search : ");
        i.levelOrderQueue(root);
    }
}





