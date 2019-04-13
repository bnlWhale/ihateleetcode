/*

An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:
Input:
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],
         [2,2,0],
         [2,0,1]]
Explanation:
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
Note:

The length of image and image[0] will be in the range [1, 50].
The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
The value of each color in image[i][j] and newColor will be an integer in [0, 65535].



 */


import java.util.Arrays;

public class Leetcode_733_Flodd_Fill {



    class Solution_1 {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int color = image[sr][sc];
            if (color != newColor) dfs(image, sr, sc, color, newColor);
            return image;
        }
        public void dfs(int[][] image, int r, int c, int color, int newColor) {
            if (image[r][c] == color) {
                image[r][c] = newColor;
                if (r >= 1) dfs(image, r-1, c, color, newColor);
                if (c >= 1) dfs(image, r, c-1, color, newColor);
                if (r+1 < image.length) dfs(image, r+1, c, color, newColor);
                if (c+1 < image[0].length) dfs(image, r, c+1, color, newColor);
            }
        }
    }


    class Solution_2 {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            if (image[sr][sc] == newColor) return image;
            fill(image, sr, sc, image[sr][sc], newColor);
            return image;
        }

        private void fill(int[][] image, int sr, int sc, int color, int newColor) {
            if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
            image[sr][sc] = newColor;
            fill(image, sr + 1, sc, color, newColor);
            fill(image, sr - 1, sc, color, newColor);
            fill(image, sr, sc + 1, color, newColor);
            fill(image, sr, sc - 1, color, newColor);
        }
    }

    class Solution {

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

            int sizeRow = image.length;
            int sizeCol = image[0].length;
            int oldColor = image[sr][sc];
            showArray(image);
            doFloodFill(image, 1,1, 2, sizeRow, sizeCol, oldColor);
            System.out.println("--------------");
            showArray(image);
            return image;
        }

        private void showArray(int[][] image){
            for(int i=0;i<image.length;i++){
                int[] a= image[i];
                System.out.println(Arrays.toString(a));
            }
        }

        public void doFloodFill(int[][] image, int row, int col, int newColor, int sizeRow, int sizeCol, int oldColor){

            System.out.println(row+" "+col);
            if(row < 0 || col < 0){
                return;
            }

            if(row >= sizeRow || col >= sizeCol){
                return;
            }

            if(image[row][col] == newColor) {
                return;
            }

            if(image[row][col] == oldColor) {

                image[row][col] = newColor;

            }


            doFloodFill(image, row-1, col,  newColor, sizeRow, sizeCol, oldColor);
            doFloodFill(image, row+1, col,  newColor, sizeRow, sizeCol, oldColor);
            doFloodFill(image, row, col-1,  newColor, sizeRow, sizeCol, oldColor);
            doFloodFill(image, row, col+1,  newColor, sizeRow, sizeCol, oldColor);

        }
    }


    public void doAction(){

        //int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] image = {{0,0,0},{0,0,0},{0,0,0}};
        int sr=1;
        int sc=1;
        int newColor=2;
        new Solution().floodFill(image,1,1,2);
    }

    public static void main(String[] args){

        Leetcode_733_Flodd_Fill aObj = new Leetcode_733_Flodd_Fill();
        aObj.doAction();


    }

}
