/*



given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.


 */


import java.util.Arrays;

public class Leetcode_283_Move_hero {

    static class Solution {
        public void moveZeroes(int[] nums) {

            int j=0;
            int total = 0;
            for(int i=0;i<nums.length;i++){

               if(nums[i]!=0){
                  nums[j] = nums[i];
                  j++;
               }else{
                   total++;
               }

            }
            for(int i=0;i<total;i++){
                nums[nums.length-1-i] = 0;
            }
            System.out.println(Arrays.toString(nums));
        }
    }



    public static void main(String[] args){

        int[] nums = {0,1,0,3,12};
        new Solution().moveZeroes(nums);
    }
}
