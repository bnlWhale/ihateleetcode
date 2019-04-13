/*

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1



 */


public class Leetcode_33_Search_in_Rotated_Sorted_Array {


    static class Solution {
        public int search(int[] nums, int target) {

            int low=0;
            int heigh=nums.length-1;
            int mid=0;
            while(low<heigh){
                mid = low+(heigh-low)/2;
                if(nums[mid]>nums[heigh]){
                    low = mid+1;
                }else{
                    heigh = mid;
                }
            }
            System.out.println(low);

            int offset = low;
            low = 0;
            heigh = nums.length-1;
            while(low<=heigh){
                mid =  low + (heigh-low)/2;
                int subMid = (mid+offset)%nums.length;
                if(nums[subMid] == target){
                    System.out.println(subMid+"  "+target);
                    return subMid;
                }else if(nums[subMid]<target){
                    low = mid+1;
                }else{
                    heigh = mid-1;
                }
            }


            System.out.println(low+" "+heigh);
            return -1;
        }
    }


    class Solution_1 {
        public boolean search(int[] nums, int target) {
            int start = 0 , end = nums.length-1;
            while(start <= end){
                int mid = start + (end-start)/2;
                if(nums[mid]  == target) return true;
                if(nums[start] == nums[mid] && nums[mid] == nums[end]){
                    start++;end--;
                } else if(nums[start] <= nums[mid]){ // left is sorted
                    if(target >= nums[start] && target < nums[mid]){
                        end = mid-1;
                    } else {
                        start = mid+1;
                    }
                } else if(nums[end] >= nums[mid]) { // right is sorted
                    if(target <= nums[end] && target > nums[mid]){
                        start = mid+1;
                    } else {
                        end = mid-1;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] arg){


        int[] nums = {4,5,6,0,1,2};
        //int[] nums = {2,2,2,0,2,2};


        int target = 0;
        new Solution().search(nums,target);
    }

}
