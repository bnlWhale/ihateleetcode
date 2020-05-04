/*






 */


import java.util.*;


public class BFS_Tree {


    static class Node { // thread tree
        int data;
        Node left;
        Node right;
        Node next;
        boolean rightThread;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            rightThread = false;
        }
    }


    public void levelOrderQueue(Node root) {

        Node subRoot = root;
        if (subRoot == null) {
            return;
        }
        System.out.println("levelOrderQueue:");
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
        ans.stream().forEach(arg -> System.out.println(Arrays.toString(arg.toArray())));
    }


    private void levelOrderHelper(Node node, int index, List<List<Integer>> ans) {

        if (node == null) {
            return;
        }
        List<Integer> tempList;
        if (ans.isEmpty() || ans.size() < index + 1) {
            tempList = new ArrayList<>();
            ans.add(tempList);
        } else {
            tempList = ans.get(index);
        }
        tempList.add(node.data);
        levelOrderHelper(node.left, index + 1, ans);
        levelOrderHelper(node.right, index + 1, ans);

    }


    public List<Integer> preorderTraversal(Node root) {

        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        Node temp;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            result.add(temp.data);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return result;
    }


    public List<Integer> inorderTraversal(Node root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) return results;
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node != null || !stack.empty()) {
            // 左孩子依次入栈，访问最左孩子
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // cur为空循环结束，说明已经到达最左下节点，访问它并添加到结果
            node = stack.pop();
            results.add(node.data);
            // 把根节点右孩子当做当前节点
            node = node.right;
        }
        return results;
    }


    public List<Integer> postorderTraversal(Node root) {
        LinkedList<Integer> results = new LinkedList<>();
        if (root == null) return results;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            results.addFirst(node.data);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return results;
    }

    /*

                3
               / \
              9  20
                /  \
               15   7

     */

    public List<List<Integer>> zigzagLevelOrder(Node root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        List<Integer> temp;
        int total = 0;
        while (queue.size() > 0) {
            temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                if (total % 2 == 1) {
                    temp.add(node.data);
                } else {
                    temp.add(0, node.data);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(temp);
            total++;

        }


        return result;

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


    private void verticalOrder(Node node, int index, Map<Integer, List<Integer>> ans) {

        if (node == null) {
            return;
        }
        List<Integer> tempList;
        if (ans.containsKey(index)) {
            tempList = ans.get(index);
        } else {
            tempList = new ArrayList<>();
            ans.put(index, tempList);
        }
        tempList.add(node.data);
        verticalOrder(node.left, index - 1, ans);
        verticalOrder(node.right, index + 1, ans);
    }


    public void bottomView(Node root, int level, Map<Integer, Integer> ht) {
        if (root == null)
            return;
        // create a queue for level order traversal
        Queue<QueuePack> queue = new LinkedList<>();
        // add root with level 0 (create a queue item pack)
        queue.add(new QueuePack(level, root));
        while (!queue.isEmpty()) {
            QueuePack q = queue.remove();
            // take out the items from the package
            Node tnode = q.tnode;
            int lvl = q.level;

            // keep updating the Map so that it will have the last entry from
            // each level(vertically) and that will the bottom view of the tree
            ht.put(lvl, tnode.data);
            //System.out.println(lvl+" "+tnode.data);
            // add the left and right children of visiting nodes to the queue
            if (tnode.left != null) {
                queue.add(new QueuePack(lvl - 1, tnode.left));
            }
            if (tnode.right != null) {
                queue.add(new QueuePack(lvl + 1, tnode.right));
            }
        }
        Set<Integer> keys = ht.keySet();
        for (Integer key : keys) {
            //System.out.print(ht.get(key) + " ");
        }
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    class QueuePack {
        int level;
        Node tnode;

        public QueuePack(int level, Node tnode) {
            this.level = level;
            this.tnode = tnode;
        }
    }

    private int getHeight(Node root) {
        if (root == null) return 0;
        return (1 + Math.max(getHeight(root.left), getHeight(root.right)));
    }


    private void buildBinaryTreeLevelOrder(int[] nums) {

        Node root = new Node(nums[0]);
        int index = 1;
        Queue<Node> queue = new LinkedList<>();
        Node current = root;
        while (index < nums.length) {
            Node node = new Node(nums[index]);
            if (current.left != null && current.right != null) {
                current = queue.remove();
            }
            if (current.left == null) {
                current.left = node;
            } else if (current.right == null) {
                current.right = node;
            }
            queue.add(node);
            index++;
        }
        levelOrderQueue(root);
    }


    /*  thread tree


                  10
                /    \
               5      15
              / \    / \
             1   7  12   20

            //1 5 7 10 12 15 20
     */


    private void convertBinaryTreeToThreadTree() {


        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);
        root.left.right = new Node(7);
        root.right.left = new Node(12);
        root.right.right = new Node(20);
        convertHelper(root, null);
        print(root);

        System.out.println("preOrder iterative");

        //print level order tree
        System.out.println("show:");
        Node start = root;
        Node pre = null;
        Node head = null;


    }

    private void convertHelper(Node node, Node pre) {

        if (node == null) {
            return;
        }
        convertHelper(node.right, pre);
        if (node.right == null && pre != null) {
            node.right = pre;
            node.rightThread = true;
            System.out.println(" convertHelper " + node.data + "  pre:" + pre.data);
        }
        convertHelper(node.left, node);

    }

    public void print(Node root) {
        //first go to most left node
        Node current = leftMostNode(root);
        //now travel using right pointers
        while (current != null) {
            System.out.print(" " + current.data);
            //check if node has a right thread
            if (current.rightThread)
                current = current.right;
            else // else go to left most node in the right subtree
                current = leftMostNode(current.right);
        }
        System.out.println("print recursive:");
        printInOrder(root);
    }


    private void printInOrder(Node node) {
        if (node == null || node.rightThread) {
            if (node != null && node.rightThread) {
                System.out.println(node.data);
            }
            return;
        }
        printInOrder(node.left);
        System.out.println(node.data);
        printInOrder(node.right);
    }

    public Node leftMostNode(Node node) {
        if (node == null) {
            return null;
        } else {
            while (node.left != null) {
                node = node.left;
            }
            return node;
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
        System.out.println("vertical order: ");
        result.keySet().stream().forEach(arg -> {
            List<Integer> list = result.get(arg);
            System.out.println(arg + "  " + Arrays.toString(list.toArray()));
        });

        int height = i.getHeight(root);
        System.out.println("tree height:" + height);


        Map<Integer, Integer> resTreeMap = new TreeMap<>();
        i.bottomView(root, 0, resTreeMap);
        //resTreeMap.keySet().forEach(arg-> System.out.println(resTreeMap.get(arg)));

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        i.buildBinaryTreeLevelOrder(nums);
        i.convertBinaryTreeToThreadTree();

        System.out.println();
    }


    /*

        leetcode 623 Add One Row to Tree


            A binary tree as following:
                   4
                 /   \
                2     6
               / \   /
              3   1 5

            v = 1

            d = 2

            Output:
                   4
                  / \
                 1   1
                /     \
               2       6
              / \     /
             3   1   5



            A binary tree as following:
                  4
                 /
                2
               / \
              3   1

            v = 1

            d = 3

            Output:
                  4
                 /
                2
               / \
              1   1
             /     \
            3       1

     */



    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) return null;
        // 当d==1时，需要替换根结点
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 检测到 d 为 0 时，直接返回，因为添加操作已经完成，没必要遍历完剩下的结点
            if (--d == 0) return root;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 当 d==1 时，需要插入该行
                if (d == 1) {
                    TreeNode left = new TreeNode(v);
                    left.left = node.left;
                    node.left = left;
                    TreeNode right = new TreeNode(v);
                    right.right = node.right;
                    node.right = right;
                } else {
                    // 如果 d 不为 1，那么就是层序遍历原有的入队操作
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
            }
        }
        return root;
    }


    class NodeNext {
        public int val;
        public NodeNext left;
        public NodeNext right;
        public NodeNext next;

        public NodeNext() {}

        public NodeNext(int _val,NodeNext _left,NodeNext _right,NodeNext _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public NodeNext connect(NodeNext root) {

        if(root == null){
            return null;
        }
        if(root.left!=null){
            root.next = root.right;
        }
        if(root.right != null && root.next!=null){
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return null;
    }


    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size()>0){
            Node node = queue.remove();
            if(node.left != null){
                node.left.next = node.right;
            }
            if(node.right != null && node.next != null){
                node.right.next = node.next.left;
            }
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }

        }
        return root;
    }

}





