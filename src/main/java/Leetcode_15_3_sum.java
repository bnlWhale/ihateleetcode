/*



Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]


 */


import java.util.*;

public class Leetcode_15_3_sum {


    class Solution {
        public List<List<Integer>> threeSum(int[] num) {
            Arrays.sort(num);
            List<List<Integer>> res = new LinkedList<>();
            for (int i = 0; i < num.length-2; i++) {
                if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                    int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                    while (lo < hi) {
                        if (num[lo] + num[hi] == sum) {
                            res.add(Arrays.asList(num[i], num[lo], num[hi]));
                            while (lo < hi && num[lo] == num[lo+1]) lo++;
                            while (lo < hi && num[hi] == num[hi-1]) hi--;
                            lo++; hi--;
                        } else if (num[lo] + num[hi] < sum) lo++;
                        else hi--;
                    }
                }
            }
            return res;
        }
    }



    public static void main(String[] args){

          int[] nums = {-1, 0, 1, 2, -1, -4};
          //Arrays.sort(nums);
         // System.out.println(Arrays.toString(nums));
          threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                continue;
            }else{
                set.add(nums[i]);
            }
            int subVal = 0 - nums[i];
            twoSumTotal(subVal,i,nums,result);

        }
        return result;
    }

    public static void twoSumTotal(int total, int index, @org.jetbrains.annotations.NotNull int[] nums, List<List<Integer>> result){

            Map<Integer,Integer> resultMap = new HashMap<Integer, Integer>();
           for(int i=index+1;i<nums.length;i++){
                   int val = nums[i];
                   if(resultMap.containsKey(val)){
                     List<Integer> list = new ArrayList<Integer>();
                     list.add(nums[index]);
                     list.add(nums[i]);
                     int other_i = resultMap.get(val);
                     list.add(nums[other_i]);
                     System.out.print(nums[index]+" "+nums[i]+" "+nums[other_i]);
                     System.out.println();
                   }else{
                       resultMap.put(total-val,i);
                   }
           }

    }

}


