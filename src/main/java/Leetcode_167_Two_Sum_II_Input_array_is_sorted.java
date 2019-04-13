/*


Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.


 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode_167_Two_Sum_II_Input_array_is_sorted {


    static class Solution {
        public int[] twoSum(int[] num, int target) {
            int[] indice = new int[2];
            if (num == null || num.length < 2) return indice;
            int left = 0, right = num.length - 1;
            while (left < right) {
                int v = num[left] + num[right];
                if (v == target) {
                    indice[0] = left + 1;
                    indice[1] = right + 1;
                    break;
                } else if (v > target) {
                    right --;
                } else {
                    left ++;
                }
            }
            return indice;
        }
    }

    public static void main(String[] args){

        //int[] nums = {2,7,11,15};
       // int target = 9;


        //int[] nums = {2,3,4};
       // int target = 6;

        int[] nums = {-1,0};
        int target = -1;

        new Solution().twoSum(nums, target);

    }
}
