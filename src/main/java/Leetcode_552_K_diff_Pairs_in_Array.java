/*


Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.

Example 1:
Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
Example 2:
Input:[1, 2, 3, 4, 5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
Example 3:
Input: [1, 3, 1, 5, 4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
Note:
The pairs (i, j) and (j, i) count as the same pair.
The length of the array won't exceed 10,000.
All the integers in the given input belong to the range: [-1e7, 1e7].


 */


import java.util.*;

public class Leetcode_552_K_diff_Pairs_in_Array {

    static class Solution {
        public int findPairs(int[] nums, int k) {

            if (nums == null || nums.length == 0 || k < 0)   return 0;
            int count=0;
            Map<Integer, Integer> record = new HashMap<>();
            for(int element:nums){
                record.put(element, record.getOrDefault(element,0)+1);
            }

            for(int i:record.keySet()){
                if(k==0){
                    if(record.get(i)>=2){
                        count++;
                    }
                }else{
                    if(record.containsKey(k+i)){
                        count++;
                    }
                }

            }

            System.out.println(count);
            return count;
        }
    }


    public static void main(String[] args){

        Solution solution = new Solution();
        int[] nums = {3, 1, 4, 1, 5};
        //int[] nums = {1, 2, 3, 4, 5};
        int k=2;

        //int[] nums = {1, 2, 3, 4, 5};
        //int k=-1;

        int[] nums_1 = {1,1,1,1,1};


        solution.findPairs(nums, k);

    }

}
