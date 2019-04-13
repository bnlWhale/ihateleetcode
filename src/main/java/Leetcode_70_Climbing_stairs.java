/*


You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step



 */


public class Leetcode_70_Climbing_stairs {



    public void useInterClass(){
        System.out.println(new Solution().climb_Stairs(0,2));
    }

    public static void main(String[] args){

        Leetcode_70_Climbing_stairs lc = new Leetcode_70_Climbing_stairs();
        lc.useInterClass();



    }

     class Solution {

        public int climbStairs(int n) {
            return climb_Stairs(0, n);
        }
        public int climb_Stairs(int i, int n) {
            if (i > n) {
                return 0;
            }
            if (i == n) {
                return 1;
            }
            return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
        }
    }

    class Solution_1 {
        public int climbStairs(int n) {
            if(n == 1)
                return 1;
            if(n == 2)
                return 2;
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            int i =3;
            while(i <= n){
                dp[i] = dp[i - 1] + dp[i - 2] ;
                i++;
            }
            return dp[n];
        }

        public int notFn(int n){
            int sum = 0;
            int prepre = 1;
            int pre = 2;
            for(int i = 3;i <= n; i++){
                sum = prepre + pre;
                pre = sum;
                prepre = pre;
            }
            return sum;
        }
    }

}
