/*

You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1



 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_322_Coin_Change {



    class Solution {
        int total = Integer.MAX_VALUE;
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) return 0;
            Arrays.sort(coins);
            count(amount, coins.length-1, coins, 0);
            return total == Integer.MAX_VALUE?-1:total;
        }
        void count(int amount, int index, int[] coins, int count){
            if (index<0 || count>=total-1) return;
            int c = amount/coins[index];
            for (int i = c;i>=0;i--){
                int newCount = count + i;
                int rem = amount - i*coins[index];

                if (rem>0 && newCount<total)
                    count(rem, index-1, coins, newCount);
                else if (newCount<total)
                    total = newCount;
                else if (newCount>=total-1)
                    break;
            }
        }
    }


    public static void main(String[] args){

        int[] coins = {1,2,5};
        System.out.println(coinChange(coins,11));
    }


    public static int coinChange(int[] coins, int amount) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(coins);
        backtrack(coins, amount, tempList, res, 0);
        System.out.println(Arrays.toString(res.toArray())+" size:"+res.size());
        if(res.size()>0){
            return res.get(0).size();
        }else{
            return 0;
        }


    }

    public static void backtrack(int[] coins, int remain, List<Integer> tempList, List<List<Integer>> res, int start){

        if(remain<0){

            return;
        }else if(remain == 0){
            if(res.size()==0){
                res.add(new ArrayList<>(tempList));
            }
            else if(tempList.size()<res.get(0).size()){

                while (res.size()>0){
                   res.remove(res.size()-1);
                }
                res.add(new ArrayList<>(tempList));

            }


        }else{

            for(int i=start;i<coins.length;i++){

                tempList.add(coins[i]);
                backtrack(coins,remain-coins[i], tempList, res, i);
                tempList.remove(tempList.size()-1);

            }

        }

    }
}

