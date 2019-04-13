/*


Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.


 */


import java.util.*;

public class Leetcode_525_Contiguous_Array {

    static class Solution {

        public int findMaxLength(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int maxlen = 0;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                count = count + (nums[i] == 1 ? 1 : -1);
                System.out.println(count+"   "+i);
                if (map.containsKey(count)) {
                    maxlen = Math.max(maxlen, i - map.get(count));
                    //System.out.println(maxlen+"  "+count);
                } else {
                    map.put(count, i);
                }
            }
            //System.out.println(maxlen);
            return maxlen;
        }
    }

    public static void main(String[] args) {

       // int[] nums = {0, 1, 0, 0, 1, 1, 0};
        int[] nums = {0,0,1,0,0,0,1,1};
        new Solution().findMaxLength(nums);

    }
}
