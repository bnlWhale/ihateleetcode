/*



Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.


 */


public class Leetcode_64_Minimum_Path_Sum {


    static class Solution {

        public int minPathSum(int[][] grid) {

            int m = grid.length;
            int n = grid[0].length;
            int[][] memo = new int[m][n];
            int result = dfs(grid, memo, 0, 0);
            System.out.println("final result:"+result);
            return result;

        }

        private int dfs(int[][] grid, int[][]memo, int x, int y){

            if(x>grid.length-1 || y>grid[0].length-1){
                //System.out.println("max "+x+"  "+y);
                return Integer.MAX_VALUE;
            }
            if(memo[x][y]>0){
                System.out.println("  memo "+x+" "+y+" "+memo[x][y]);
                return memo[x][y];
            }
            if(x==grid.length-1 && y==grid[0].length-1){
                //System.out.println("  grid "+x+" "+y);
                System.out.println(x+" "+y+"  "+grid[x][y]+" *");
                return grid[x][y];
            }
            //System.out.println(x+"  "+y);
            //int ans = grid[x][y] + Math.min(dfs(grid, memo, x+1, y), dfs(grid, memo, x, y+1));

            int dfs1 = dfs(grid, memo, x+1, y);
            System.out.println("before next: "+x+" "+y+"  "+grid[x][y]+" dfs1:"+dfs1);
            int dfs2 = dfs(grid, memo, x, y+1);
            System.out.println("-- "+x+" "+y+"  "+grid[x][y]+"       dfs1:"+dfs1+"   dfs2:"+dfs2);
            int ans = dfs1;
            if(dfs1>dfs2){
                ans = dfs2;
            }
            ans = grid[x][y]+ans;

            memo[x][y] = ans;
            System.out.println("return:"+ans+" xy "+x+" "+y);
            return ans;
        }

        private void showGridXY(int[][] grid){

            int Y = grid.length;
            int X = grid[0].length;
            for(int i=0; i<Y; i++){
                System.out.println();
                for(int j=0; j<X; j++){
                    System.out.print(grid[i][j]+" , ");
                }
            }

        }

        private void pacourir(int[][] grid, int x, int y, int maxX, int maxY){

            if(x>maxX-1){
                return;
            }
            if(y>maxY-1){
                return;
            }

            pacourir(grid, x+1, y, maxX, maxY);
            pacourir(grid, x, y+1, maxX, maxY);
            System.out.println(grid[x][y]);
        }
    }


     public static void main(String[] args){


        int[][] grid = {

                {1,3,1},
                {1,5,1},
                {4,2,1}
        };


        /*
         int[][] grid = {

                 {1,2},
                 {3,4}

         };

         */

        new Solution().minPathSum(grid);

        grid = new int[][]{
                {11, 12, 13},
                {21, 22, 23},
                {31, 32, 33}
        };

        int maxX = grid[0].length;
        int maxY = grid.length;

        //new Solution().pacourir(grid, 0, 0, maxX, maxY);
    }

    /*





     */


}
