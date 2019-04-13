/*


Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?


 */


import java.util.Arrays;

public class Leetcode_189_Rotate_Array {

    static class Solution {
        public void rotate(int[] nums, int k) {
            if (k < 0) {
                return;
            }
            int length = nums.length;
            for(int i=0;i<k;i++){
                int temp = nums[length-1];
                for(int j=length-2;j>=0;j--){
                    nums[j+1] = nums[j];
                }
                nums[0] = temp;
            }

            System.out.println(Arrays.toString(nums));
        }
    }


    public static void main(String[] args) {

        //int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] nums = {-1,-100,3,99};

        new Solution().rotate(nums, 2);

    }


}
