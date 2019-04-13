/*


Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.

Since the answer may be large, return the answer modulo 10^9 + 7.



Example 1:

Input: [3,1,2,4]
Output: 17
Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.


Note:

1 <= A.length <= 30000
1 <= A[i] <= 30000


 */

import java.util.*;

public class Leetcode_907_Sum_Subarray_Minimums {

    static class Solution {
        public int sumSubarrayMins(int[] A) {

            List<List<Integer>> ans = new ArrayList<>();
            helper(0, A, new ArrayList<>(), ans);
            System.out.println(Arrays.toString(ans.toArray()));
            return -1;
        }

        private void helper(int start, int[] A, List<Integer> temp, List<List<Integer>> ans){

            //System.out.println(Arrays.toString(temp.toArray()));
            if(start == A.length){
               // System.out.println(Arrays.toString(temp.toArray()));
            }
           // System.out.println(Arrays.toString(temp.toArray()));
            for(int i=start;i<A.length;i++){
                List<Integer> temp_ans = new ArrayList<>();
                for(int j=start;j<=i;j++){
                    temp.add(A[j]);
                    //System.out.print(A[j]);
                    temp_ans.add(A[j]);
                }
                ans.add(temp_ans);
                //System.out.println();
                helper(i+1, A, temp, ans);
                temp.remove(temp.size()-1);
            }

        }
    }

    public static void main(String[] args){

        int[] nums = {3,1,2};
        new Solution().sumSubarrayMins(nums);
    }

}
