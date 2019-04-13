/*

The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"



 */




import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_60_permutation_sequence    {


    class Solution {

        public String getPermutation(int n, int k) {

            int[] nums = new int[n];
            for(int i=0;i<n;i++){
                nums[i]=i+1;
            }
            List<List<Integer>> res = new ArrayList<>();
            backtrack(nums, res, new ArrayList<>(), k);
            //System.out.println(res.get(k-1));
            if(k>0){
                List<Integer> list = res.get(k-1);
                String str = "";
                for(Integer item:list){
                    str += item.toString();
                }
                System.out.println(str);
                return str;
            }
            return "";
        }

        public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> tempList, int index){

            if(tempList.size()==nums.length){
                res.add(new ArrayList<>(tempList));
                if(res.size()==index){
                    return;
                }
                //System.out.println(Arrays.toString(tempList.toArray()));
            }else{
                for(int i=0;i<nums.length;i++){
                    if(tempList.contains(nums[i])){
                        continue;
                    }
                    tempList.add(nums[i]);
                    backtrack(nums, res, tempList, index);
                    tempList.remove(tempList.size()-1);
                }
            }



        }
    }

    public void doAction(){

        new Solution().getPermutation(4, 9);

    }

    public static void main(String[] args){

        Leetcode_60_permutation_sequence l60 = new Leetcode_60_permutation_sequence();
        l60.doAction();

    }

}
