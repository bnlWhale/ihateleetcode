/*


Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]



 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_40 {

    public static void main(String[] args){

        int[] nums = {10,1,2,7,6,1,5};
        int target = 8;
        subsets(nums, target);
    }

    public static List<List<Integer>> subsets(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, 0, target);
        System.out.println(Arrays.toString(res.toArray()));
        return res;
    }

    private static void backtrack(List<List<Integer>> res , List<Integer> tempList, int [] nums, int start, int remain){

        if(remain<0){
            return;
        }
        else if(remain == 0){
            res.add(new ArrayList<>(tempList));
        }
        else {
            System.out.println("first add:"+Arrays.toString(tempList.toArray())+ "  start:"+start);
            for(int i = start; i < nums.length; i++){
                if( i>start && nums[i] == nums[i-1]){
                    // System.out.println("duplicate:"+i+"  "+nums[i]+"   "+start);
                    continue;
                }
                tempList.add(nums[i]);
                backtrack(res, tempList, nums, i + 1,remain-nums[i]);
                //System.out.println("out:"+Arrays.toString(tempList.toArray())+"  i:"+i+"    start:"+start);
                tempList.remove(tempList.size() - 1);
                // System.out.println("remove last one:"+Arrays.toString(tempList.toArray()));
                // System.out.println("---- ---- ---at end of for ****  i:"+i);
            }
        }

    }


}
