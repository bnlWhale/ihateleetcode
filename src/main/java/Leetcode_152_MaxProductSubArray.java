/*


Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


 */


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Leetcode_152_MaxProductSubArray {

    static class Solution {
        public int maxProduct(int[] nums) {

            if(nums == null || nums.length == 0){
                return 0;
            }
            if(nums.length==1){
                return nums[0];
            }
            int max = Integer.MIN_VALUE;
            int multi = 1;
            for(int i=0;i<nums.length;i++){

                max = Math.max(max, multi *=nums[i]);
                if(nums[i]==0){
                    multi=1;
                }
            }


            multi = 1;
            for(int i=nums.length-1;i>=0;i--){
                max = Math.max(max, multi*=nums[i]);
                if(nums[i]==0){
                    multi=1;
                }
            }


            return max;
        }
    }




    public static void main(String[] args){

        //int[] nums = {2,3,-2,4};
        //int[] nums =  {-2,0,-1};
        int[] nums = {-3,-4};

        System.out.println(new Solution().maxProduct(nums));



        Map<String,String> map = new HashMap<String,String>();
        map.put("A", "1");
        map.put("B", "2");
        map.put("C","3");

        Iterator iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            System.out.println(map.get(iterator.next()));
            map.put("D", "4"); //modification causes java.util.ConcurrentModificationException
        }



    }

}
