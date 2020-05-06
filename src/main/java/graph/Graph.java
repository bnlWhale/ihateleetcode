package graph;

import java.util.*;

class Graph {

    // A utility function to add an edge in an
    // undirected graph
    static void addEdge(ArrayList<ArrayList<Integer> > adj,
                        int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // A utility function to print the adjacency list
    // representation of graph
    static void printGraph(ArrayList<ArrayList<Integer> > adj)
    {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex" + i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> "+adj.get(i).get(j));
            }
            System.out.println();
        }

       /*for(List list:adj){
           System.out.println("\n");
           for(Object obj:list){
               System.out.print("->"+obj);
           }
       }*/
    }

    /*

          0 --- 1 -
          -    - -    -
          -   -    -      - 2
          -  -      -   -
          4 --------- 3



     */



    // Driver Code
    public static void main(String[] args)
    {
        // Creating a graph with 5 vertices
        int V = 5;
        ArrayList<ArrayList<Integer> > adj
                = new ArrayList<ArrayList<Integer> >(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        // Adding edges one by one
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        printGraph(adj);
        dfsIterator(adj);

        int[] arr = {0,1,2,3,4,5};
       // traversalArr(arr, 0);

        int[][] arr2 = {
                {11,12,13,14},
                {21,22,23,24},
                {31,32,33,34},
                {41,42,43,44}

                        };
        traversalArr2(arr2, 0, 0);
    }

    private static void traversalArr(int[] arr, int index){

        if(index > arr.length-1){
            return;
        }
        System.out.println("traversalArr:"+arr[index]);
        traversalArr(arr, ++index);
    }

    private static void traversalArr2(int[][] arr, int i, int j){

        if(i>arr.length-1){
            return;
        }
        if(j>arr[0].length-1){
            return;
        }
        System.out.println("traversalArr2 "+arr[i][j]);
        traversalArr2(arr, i+1, j);
        traversalArr2(arr, i, j+1);

    }



    private void dfsGraphList(ArrayList<ArrayList<Integer> > list){
        if(list == null){
            return;
        }

    }

    private static void dfsIterator(ArrayList<ArrayList<Integer>> list){

        if(list == null || list.isEmpty()){
            return;
        }
        if(list.get(0) == null || list.get(0).isEmpty()){
            return;
        }
        int[] visited = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while(index>-1 && list.get(index)!=null){
            List<Integer> subList = list.get(index);
            for(Integer ii:subList){
                if(visited[ii]==0){
                    visited[ii] = 1;
                    stack.push(ii);
                    System.out.println("dfsIterator:"+ii);
                }
            }
            if(stack.size()==0){
                index=-1;
            }else{
                index = stack.pop();
            }

        }
    }

    // dijkstra algorithm
    private static void doDijstra(){

        int V = 5;
        int source = 0;

        // Adjacency list representation of the
        // connected edges
        List<List<Node> > adj = new ArrayList<List<Node> >();

        // Initialize list for every node
        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }

        // Inputs for the DPQ graph
        adj.get(0).add(new Node(1, 9));
        adj.get(0).add(new Node(2, 6));
        adj.get(0).add(new Node(3, 5));
        adj.get(0).add(new Node(4, 3));

        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(3, 4));

        // Calculate the single source shortest path
        DPQ dpq = new DPQ(V);
        dpq.dijkstra(adj, source);

        // Print the shortest path to all the nodes
        // from the source node
        System.out.println("The shorted path from node :");
        for (int i = 0; i < dpq.dist.length; i++)
            System.out.println(source + " to " + i + " is "
                    + dpq.dist[i]);

    }



}
