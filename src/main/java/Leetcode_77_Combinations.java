/*


Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]


 */

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Leetcode_77_Combinations {

    static class Solution {
        public List<List<Integer>> combine(int n, int k) {

           int[] nums = new int[n];
           for(int i=0;i<n;i++){
               nums[i] = i+1;
           }

           List<List<Integer>> res = new ArrayList<>();

           if(n<k){
               return res;
           }

            backtrace(nums, new ArrayList<>(), 0, res, k);

            System.out.println(Arrays.toString(res.toArray()));
            return res;
        }

        private void backtrace(int[] nums, List<Integer> tempList, int start, List<List<Integer>> res, int k){

            if(tempList.size()==k){
                res.add(new ArrayList<>(tempList));
            }

            for(int i=start;i<nums.length;i++){

                tempList.add(nums[i]);
                backtrace(nums, tempList, i+1, res, k);
                tempList.remove(tempList.size()-1);
            }


        }


    }

    public static void main(String[] args){

        new Solution().combine(4,2);


    }
}
