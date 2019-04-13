import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


public class Leetcode_39 {



    public static void main(String[] args){

       // int[] nums = {2,3,6,7};
        //int target = 7;
        int[] nums = {2,3,5};
        int target = 8;
        combinationSum(nums, target);
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, 0, target);
        System.out.println(Arrays.toString(res.toArray()));
        return res;
    }

    private static void backtrack(List<List<Integer>> res , List<Integer> tempList, int [] nums, int start, int target){

        if(target == 0){
            res.add(new ArrayList<>(tempList));
        }else if(target<0){
            return;
        }else{
            //System.out.println("first add:"+Arrays.toString(tempList.toArray())+ "  start:"+start);
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(res, tempList, nums, i, target-nums[i]);
                //System.out.println("out:"+Arrays.toString(tempList.toArray())+"  i:"+i+"    start:"+start);
                tempList.remove(tempList.size() - 1);
                //System.out.println("remove last one:"+Arrays.toString(tempList.toArray()));
                //System.out.println("at end of for ****  i:"+i);
            }
        }
    }



}
