/*

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input:
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output:
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?


 */


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode_73_Set_Matrix_Zeroes {

    class Solution {
        public void setZeroes(int[][] matrix) {

            if(matrix == null || matrix.length==0){
                return;
            }

            int row = matrix.length;
            int col = matrix[0].length;
            String str;
            Set<String> record = new HashSet<>();
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(matrix[i][j]==0){
                        str = String.valueOf(i)+'_'+String.valueOf(j);
                        if(record.contains(str)){
                            continue;
                        }else{
                            for(int k=0;k<col;k++){

                                if(matrix[i][k]!=0){
                                    str = String.valueOf(i)+'_'+String.valueOf(k);
                                }
                                matrix[i][k] = 0;
                                record.add(str);
                            }
                            for(int m=0;m<row;m++){
                                if(matrix[m][j]!=0){
                                    str = String.valueOf(m)+'_'+String.valueOf(j);
                                }
                                matrix[m][j] = 0;
                                record.add(str);
                            }
                        }
                    }
                }
            }
            for(int[] arr:matrix){
                System.out.println(Arrays.toString(arr));
            }
        }


    }


    public void doAction(){

        /*
        int[][] matrix = {

                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        */
        int[][] matrix = {

                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}

        };

        new Solution().setZeroes(matrix);

    }

    public static void main(String[] args){

        Leetcode_73_Set_Matrix_Zeroes l73 = new Leetcode_73_Set_Matrix_Zeroes();
        l73.doAction();

    }


}
