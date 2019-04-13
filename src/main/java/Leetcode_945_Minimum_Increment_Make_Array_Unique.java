/*

Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.

Return the least number of moves to make every value in A unique.



Example 1:

Input: [1,2,2]
Output: 1
Explanation:  After 1 move, the array could be [1, 2, 3].
Example 2:

Input: [3,2,1,2,1,7]
Output: 6
Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
It can be shown with 5 or less moves that it is impossible for the array to have all unique values.


Note:

0 <= A.length <= 40000
0 <= A[i] < 40000



Let's count the quantity of each element. Clearly, we want to increment duplicated values.

For each duplicate value, we could do a "brute force" solution of incrementing it repeatedly
until it is not unique. However, we might do a lot of work - consider the work done by an array of
all ones. We should think of how to amend our solution to solve this case as well.

What we can do instead is lazily evaluate our increments. If for example we have [1, 1, 1, 1, 3, 5],
we don't need to process all the increments of duplicated 1s. We could take three ones
(taken = [1, 1, 1]) and continue processing. When we find an empty place like 2, 4, or 6, we can
then recover that our increment will be 2-1, 4-1, and 6-1.


 */


import java.util.*;

public class Leetcode_945_Minimum_Increment_Make_Array_Unique {

    static class Solution {
        public int minIncrementForUnique(int[] A) {

            Map<Integer, Integer> map = new HashMap<>();
            int total=0;
            for(int i=0;i<A.length;i++){
                int temp = A[i];
                if(map.containsValue(temp)){
                   while (map.containsValue(temp)){
                       temp++;
                       total++;
                   }
                   A[i] = temp;
                   map.put(i,temp);
                }else{
                    map.put(i,temp);
                }
            }
            System.out.println(Arrays.toString(A)+"  total move:"+total);
            return total;
        }
    }


    class Solution_1 {
        public int minIncrementForUnique(int[] A) {
            int[] count = new int[100000];
            for (int x: A) count[x]++;

            int ans = 0, taken = 0;

            for (int x = 0; x < 100000; ++x) {
                if (count[x] >= 2) {
                    taken += count[x] - 1;
                    ans -= x * (count[x] - 1);
                }
                else if (taken > 0 && count[x] == 0) {
                    taken--;
                    ans += x;
                }
            }

            return ans;
        }
    }

    public static void main(String[] args){

        //int[] nums = {1,2,2};
        int[] nums = {3,2,1,2,1,7};
        new Solution().minIncrementForUnique(nums);

    }


}
