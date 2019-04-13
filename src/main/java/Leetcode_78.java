/*



Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]


 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_78 {

    public static void main(String[] args){

        int[] nums = {1,2,3};
        subsets(nums);
    }


    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length ==0) return res;
        subsets(nums, 0, res, new ArrayList());
        System.out.println(Arrays.toString(res.toArray()));
        return res;
    }

    public static void subsets(int[] nums, int index, List<List<Integer>> res, List<Integer> subset){

        if(index == nums.length){
            res.add(subset);
            System.out.println(Arrays.toString(subset.toArray()));
            return;
        }

        subsets(nums, index+1, res, subset);
        ArrayList list = new ArrayList(subset);
        list.add(nums[index]);
       // System.out.println(index+"  "+Arrays.toString(list.toArray()));
        subsets(nums, index+1, res, list);

    }

}





