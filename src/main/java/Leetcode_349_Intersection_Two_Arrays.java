/*


Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.




 */


import java.util.*;

public class Leetcode_349_Intersection_Two_Arrays {


    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {



            if(nums1 == null || nums2 == null){
                int[] res = {};
                return res;
            }

            List<Integer> list = new ArrayList<>();
            Arrays.sort(nums2);
            Set<Integer> set = new HashSet<>();
            for(int num:nums1){
                if(binarySearch(nums2, num)){
                    if(!set.contains(num)){
                        set.add(num);
                         list.add(num);
                    }
                }
            }


            return list.stream().mapToInt(i->i).toArray();
        }

        public boolean binarySearch_p(int[] targetArr, int target){
            int low = 0;
            int hight = targetArr.length-1;
            while(low<=hight){
                int mid = low +(hight-low)/2;
                int temp = targetArr[mid];
                if(target == temp){
                    return true;
                }
                if(target>mid){
                    low = mid+1;
                }else{
                    hight = mid-1;
                }
            }
            return false;
        }


        public boolean binarySearch(int[] targetArr, int target){

            if(targetArr==null){
                return false;
            }

            int low=0;
            int height=targetArr.length-1;
            while(low <=height){

                int midd = low + (height-low)/2;
                if(target == targetArr[midd]){
                   // System.out.println(midd);
                    return true;
                }else if(target > targetArr[midd]){
                     low = midd+1;
                }else {
                    height = midd-1;
                }


            }

            //System.out.println("no find");
            return false;
        }
    }


    public void doAction(){
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        int[] nums3 = {2,3};
        int[] arr = new Solution().intersection(nums1, nums2);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args){

        Leetcode_349_Intersection_Two_Arrays l349 = new Leetcode_349_Intersection_Two_Arrays();
        l349.doAction();

    }


}
