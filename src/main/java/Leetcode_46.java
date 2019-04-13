/*


Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]


 */


import java.lang.reflect.Array;
import java.util.*;

public class Leetcode_46 {


    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permute(nums, result, 0);
        System.out.println(Arrays.toString(result.toArray()));
        return result;
    }

    private static void permute(int[] nums, List<List<Integer>> result, int start){

        if(start == nums.length-1){
            result.add(asList(nums));
            return;
        }
        for(int i=start;i<nums.length;i++){
            swap(nums, i, start);
           // System.out.println("before:"+i+" "+start);
            permute(nums, result, start+1);
            swap(nums, i, start);
           // System.out.println("after:"+i+" "+start);
        }
    }


    private static List<Integer> asList(int[] nums){

        List<Integer> list = new ArrayList<Integer>(nums.length);
        for(int num:nums){
            list.add(num);
        }
        return list;
    }

    private static void swap(int[] nums, int i, int j){

        if( i !=j ){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

        }
    }



    public static void main(String[] args){

        int[] nums={1,2,3};
        permute(nums);

    }





}


class Solution {
    public void backtrack(int n,
                          ArrayList<Integer> nums,
                          List<List<Integer>> output,
                          int first) {
        // if all integers are used up
        if (first == n)
            output.add(new ArrayList<Integer>(nums));
        for (int i = first; i < n; i++) {
            // place i-th integer first
            // in the current permutation
            Collections.swap(nums, first, i);
            // use next integers to complete the permutations
            backtrack(n, nums, output, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        // init output list
        List<List<Integer>> output = new LinkedList();

        // convert nums into list since the output is a list of lists
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums)
            nums_lst.add(num);

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }
}
