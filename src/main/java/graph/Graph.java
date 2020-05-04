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
    }

    private void dfsGraphList(List<List<Integer>> list){
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

}
