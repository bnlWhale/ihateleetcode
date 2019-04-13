/*


You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.


 */


public class Leetcode_441_Arranging_Coins {

    //Runtime: 8 ms, faster than 97.57% of Java online submissions for Arranging Coins.
    class Solution_1 {
        public int arrangeCoins(int n) {

            long sum = 0;
            int step = 0;
            while(sum<=n){
                step++;
                sum += step;
            }
            return step-1;

        }
    }

    //Runtime: 1 ms, faster than 100% of Java online submissions for Arranging Coins.
    class Solution {
        public int arrangeCoins(int n) {

            long nLong = (long)n;
            long st = 0;
            long ed = nLong;

            long mid = 0;
            while (st <= ed){
                mid = st + (ed - st) / 2;

                if (mid * (mid + 1) <= 2 * nLong){
                    st = mid + 1;
                }else{
                    ed = mid - 1;
                }
            }

            return (int)(st - 1);


        }
    }

}
