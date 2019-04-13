/*


Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]


 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_90 {




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
            //swap(nums, i, start);
            // System.out.println("before:"+i+" "+start);
            permute(nums, result, start+1);
           // swap(nums, i, start);
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


    /*

The Basic idea is: use "while (i < n.length && n[i] == n[i - 1]) {i++;}" to avoid the duplicate. For example, the input is 2 2 2 3 4. Consider the helper function. The process is:

each.add(n[i]); --> add first 2 (index 0)
helper(res, new ArrayList<>(each), i + 1, n); --> go to recursion part, list each is <2 (index 0)>
while (i < n.length && n[i] == n[i - 1]) {i++;} --> after this, i == 3, add the element as in subset I


     */

    /*
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<Integer>();
        List<Integer> each = new ArrayList<Integer>();
        helper(res, each, 0, nums);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> each, int pos, int[] n) {
        if (pos <= n.length) {
            res.add(each);
        }
        int i = pos;
        while (i < n.length) {
            each.add(n[i]);
            helper(res, new ArrayList<Integer>(each), i + 1, n);
            each.remove(each.size() - 1);
            i++;
            while (i < n.length && n[i] == n[i - 1]) {i++;}
        }
        return;
    }
*/


}
