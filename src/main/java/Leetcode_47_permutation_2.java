/*

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_47_permutation_2 {


    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {

            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            backtrack(nums, new ArrayList<>(), res, new boolean[nums.length]);
            System.out.println(Arrays.toString(res.toArray()));

            return res;

        }

        public void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> res, boolean [] used){

            if(tempList.size() == nums.length){
                res.add(new ArrayList<>(tempList));
            } else{
                for(int i = 0; i < nums.length; i++){
                    if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                    used[i] = true;
                    tempList.add(nums[i]);
                    backtrack(nums, tempList, res, used);
                    used[i] = false;
                    tempList.remove(tempList.size() - 1);
                }
            }


        }


    }

    public void doAction(){

        int[] nums = {1,1,2};

       new Solution().permuteUnique(nums);
    }

    public static void main(String[] args){

        Leetcode_47_permutation_2 l47_2 = new Leetcode_47_permutation_2();
        l47_2.doAction();

    }

}
