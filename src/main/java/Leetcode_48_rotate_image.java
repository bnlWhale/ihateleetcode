/*


You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]


 */


import java.util.Arrays;

public class Leetcode_48_rotate_image {


    class Solution {
        public void rotate(int[][] matrix) {

            int row = matrix.length;
            int col = matrix[0].length;

            for (int i = 0; i < row; i++) {
                for (int j = i; j < col; j++) {
                    int from = matrix[i][j];
                    int to = matrix[j][i];
                    matrix[j][i] = from;
                    matrix[i][j] = to;

                }
            }

            for (int[] arr : matrix) {
                int i = 0;
                int j = arr.length - 1;
                while (i < j) {
                    int from = arr[i];
                    int to = arr[j];
                    arr[i] = to;
                    arr[j] = from;
                    i++;
                    j--;

                }
            }


            for (int[] arr : matrix) {
                System.out.println(Arrays.toString(arr));
            }
        }
    }

    public void doAction() {

        /*
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
       */

        int[][] matrix = {

                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };

        new Solution().rotate(matrix);

    }

    public static void main(String[] args) {


        Leetcode_48_rotate_image l48 = new Leetcode_48_rotate_image();
        l48.doAction();

    }


}
