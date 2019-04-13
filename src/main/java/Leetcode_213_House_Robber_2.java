/*


You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.
Example 2:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.


 */


public class Leetcode_213_House_Robber_2 {

    static class Solution {

        public int rob(int[] nums) {

            if(nums.length==0){
                return 0;
            }
            if(nums.length ==1){
                return nums[0];
            }

            int[] result = new int[nums.length];
            result[0] = nums[0];
            result[1] = Math.max(nums[0], nums[1]);

            int[] result_1 = new int[nums.length];
            result_1[0] = 0;
            result_1[1] = nums[1];

            for(int i=2;i<nums.length;i++){

                int temp = result[i-2];
                if(i==nums.length-1){

                }
                result[i] = Math.max(nums[i]+temp, result[i-1]);
                result_1[i] = Math.max(nums[i]+result_1[i-2], result_1[i-1]);
            }


            return result[result.length-1];
        }


    }

    public static void main(String[] args){

        //int[] nums = {1,2,3,1};
        //int[] nums = {2,7,9,3,1};
        int[] nums = {2,3,2};
        //int[] nums = {1,2,1,1};
        //int[] nums = {2,1,1,2};

        System.out.println(new Solution().rob(nums));
    }

}
