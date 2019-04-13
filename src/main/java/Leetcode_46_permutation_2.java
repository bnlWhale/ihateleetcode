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




import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_46_permutation_2 {

    public static void main(String[] args){

        int[] nums = {1,2,3};
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), res);
        System.out.println(Arrays.toString(res.toArray()));

    }

    public static void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> res){

        if(tempList.size()==3){
            res.add(new ArrayList<>(tempList));
        }else{
            for(int i=0;i<nums.length;i++){
                if(tempList.contains(nums[i])){
                    continue;
                }
                tempList.add(nums[i]);
                backtrack(nums, tempList, res);
                tempList.remove(tempList.size()-1);
            }
        }

    }

}



