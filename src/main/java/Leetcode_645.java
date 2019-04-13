/*

The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]
Note:
The given array size will in the range [2, 10000].
The given array's numbers won't have any order.

Runtime: 6 ms, faster than 99.47% of Java online submissions for Set Mismatch.

 */


public class Leetcode_645 {

    public static void main(String[] args){

    }

    public static int[] findErrorNums(int[] nums) {

        int length = nums.length;
        boolean[] result = new boolean[length+1];
        int repeatNum = 0;
        for(int num:nums){
            if(result[num]){
                repeatNum = num;
            }else{
                result[num] = true;
            }
        }
        for(int i=0;i<result.length;i++){
            if(!result[i]){
                return new int[]{repeatNum,i};
            }
        }
        return new int[1];
    }
}
