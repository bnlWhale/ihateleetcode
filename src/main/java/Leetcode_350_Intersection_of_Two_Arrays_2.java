/*


Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?





 */


import java.util.*;
import java.util.stream.Collectors;

public class Leetcode_350_Intersection_of_Two_Arrays_2 {


     class Solution_1 {
        public int[] intersect(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            ArrayList<Integer> result = new ArrayList<Integer>();
            for(int i = 0; i < nums1.length; i++)
            {
                if(map.containsKey(nums1[i])) map.put(nums1[i], map.get(nums1[i])+1);
                else map.put(nums1[i], 1);
            }

            for(int i = 0; i < nums2.length; i++)
            {
                if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0)
                {
                    result.add(nums2[i]);
                    map.put(nums2[i], map.get(nums2[i])-1);
                }
            }

            int[] r = new int[result.size()];
            for(int i = 0; i < result.size(); i++)
            {
                r[i] = result.get(i);
            }

            return r;
        }
    }


    static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {

            if(nums1 == null || nums2==null){
                return new int[0];
            }

            List<Integer> list_1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
            List<Integer> list_2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
            List<Integer> ans = new ArrayList<>();
            for(Integer i:list_1){
                if(list_2.contains(i)){
                  // ans.add(i);
                }
            }

            Set<String> set = new HashSet<>();
            for(int j:nums2){
                for(int i=0;i<nums1.length;i++){
                    if(nums1[i]==j){
                        if(!set.contains(String.valueOf(i)+'_'+String.valueOf(nums1[i]))){
                            ans.add(nums1[i]);
                            set.add(String.valueOf(i)+'_'+String.valueOf(nums1[i]));
                            break;
                        }
                    }
                }
            }

            System.out.println(ans.toString());
           return ans.stream().mapToInt(i->i).toArray();
        }
    }

    public static void main(String[] args){

        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        new Solution().intersect(nums1,nums2);

    }


}
