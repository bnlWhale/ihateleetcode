/*


Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]



 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_39_combination_2 {


    public static void main(String[] args){
        int[] nums = {2,3,5};
        int target = 8;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), 0, target, res);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public static void backtrack(int[] nums, List<Integer> tempList, int start, int target, List<List<Integer>> res){

        if(target<0){
            return;
        }else if(target==0){
            res.add(new ArrayList<>(tempList));
        }else{
            for(int i=start;i<nums.length;i++){
                tempList.add(nums[i]);
                backtrack(nums, tempList, i, target-nums[i], res);
                tempList.remove(tempList.size()-1);
            }
        }



    }
}
