
/*


Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



public class Leetcode_1_two_sum {

    static class  Solution {
        public int[] twoSum(int[] nums, int target) {

            Map<Integer, Integer> record = new HashMap<>();


            for(int i=0;i<nums.length;i++){

                int temp = nums[i];
                if(record.containsValue(temp)){
                    Set<Integer> set = record.keySet();
                    Iterator<Integer> iterator = set.iterator();
                    for(Integer integer:set){
                       // System.out.println(integer+"   "+i);
                    }

                }else{
                    record.put(i, target-nums[i]);
                }


            }


            Map<Integer, String> saving = new HashMap<>();
            for(int i=0;i<nums.length;i++){

               if(saving.containsKey(nums[i])){
                   String str = saving.get(nums[i]);
                   str = str+"_"+String.valueOf(i);
                   saving.put(nums[i], str);
               }else{
                   saving.put(nums[i], String.valueOf(i));
               }
            }

            for(int i=0;i<nums.length;i++){
                if(saving.containsKey(target-nums[i])){
                    String str = saving.get(target-nums[i]);
                    String[] sArr = str.split("_");
                    System.out.println(i+"  "+sArr[0]);

                }
            }


            return null;
        }
    }


    public static void doAction(){

        int[] nums = {2,7,11,15,2};
        int target = 9;
        new Solution().twoSum(nums, target);

    }

    public static void main(String[] args){
        doAction();
    }


}
