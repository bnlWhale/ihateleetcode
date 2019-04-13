/*

Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:
Input: [1, 2, 2, 3, 1]
Output: 2
Explanation:
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:
Input: [1,2,2,3,1,4,2]
Output: 6

 */



import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode_669_Degree_of_Array {

    class Solution {
        public int findShortestSubArray(int[] nums) {
            Map<Integer, Integer> counter = new HashMap<>(), first = new HashMap<>();
            int res = 0, degree = 0;
            for (int i = 0; i < nums.length; ++i) {
                first.putIfAbsent(nums[i], i);
                counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
                if (counter.get(nums[i]) > degree) {
                    degree = counter.get(nums[i]);
                    res = i - first.get(nums[i]) + 1;
                } else if (counter.get(nums[i]) == degree)
                    res = Math.min(res, i - first.get(nums[i]) + 1);
            }
            return res;
        }
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 2, 3, 1};




        System.out.println(Arrays.toString(nums));
    }

}
