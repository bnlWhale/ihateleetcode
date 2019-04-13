/*


Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].


 */


import java.util.HashMap;
import java.util.Map;

public class Leetcode_1 {


    public static void main(String[] args){

        int[] nums = {2, 7, 11, 15};
        twoSum(nums,18);

    }


    public  static  int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        Map<Integer,Integer> tempMap = new HashMap<Integer,Integer>();
        if(nums == null){
            return result;
        }
        int tempInt=0;
        int index=0;
        for(int i=0;i<nums.length;i++){
              tempInt = nums[i];
              if(tempMap.containsKey(tempInt)){
                  result[index++] = i;
                  result[index++] = tempMap.get(tempInt);

              }else{
                  tempMap.put(target-tempInt,i);
              }
        }

        for(int i:result){
            System.out.println(i);
        }

        return result;
    }

}
