/*


X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.

A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.

Now given a positive number N, how many numbers X from 1 to N are good?

Example:
Input: 10
Output: 4
Explanation:
There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.


这道题定义了一种好数字，就是把每位上的数字翻转一下，能得到一个不同的数字。翻转规则定义为，0，1，和8翻转后还为其本身，2和5，6和9可以互相翻转。然后给了我们一个数字N，问我们 [1, N] 区间内共有多少个这样的好数字。
这道题大家踩👎的个数远超顶👍的个数，貌似很多人不太喜欢这道给数字发好人卡的题，博主倒觉得这道题还不错，感觉没有太多的技巧，就是一个数字一个数字的验证呗，对于每个数字，再一位一位的验证呗。我们将验证某个数字是否Good的
操作写到一个子函数中，遍历数字的每一位的方法，可以通过不停的除以10来获得，也可以像博主这样通过转变为字符串，再遍历字符即可。翻转规则中没有提到的数字有三个，3，4，和7，说明这三个数字无法翻转，若一旦被翻转，则无法形成
valid的数字，所以我们只要一旦遇到这三个数字中的一个，直接返回false即可。还有要注意的是，0，1，和8这三个数字翻转后还是其本身，由于好数字的需要翻转一个不同的数字，所以若都是由这三个数字组成，翻转后不会产生不同的数字，
也不符合题意。所以我们需要2，5，6，和9这四个数字中至少出现一个，我们用一个flag来标记出现过这些数字，最后只要check这个flag变量即可，参见代码如下

 */


import java.util.ArrayList;
import java.util.List;

public class Leetcode_788_Rotated_Digits {


    static class Solution {
        public int rotatedDigits(int N) {

           int i=1;
           int total=0;
           while(i<=N){
               if(isValide(i)){
                   total++;
               }
               i++;
           }
            System.out.println("result "+total);

           return total;

        }

        private boolean isValide(int N){

            String str = String.valueOf(N);
            char[] chars = str.toCharArray();
            int count=0;
            for(int i=0;i<chars.length;i++){

                if(chars[i] == '3' || chars[i] == '4' || chars[i] == '7'){
                    return false;
                }
                if(chars[i] == '0' || chars[i] == '1' || chars[i] == '8'){
                    count++;
                }

            }
            if(count==chars.length){
                return false;
            }

            return true;
        }

    }


    public int rotatedDigits_1(int N) {
        int[] dp = new int[N + 1];
        int count = 0;
        for(int i = 0; i <= N; i++){
            if(i < 10){
                if(i == 0 || i == 1 || i == 8) dp[i] = 1;
                else if(i == 2 || i == 5 || i == 6 || i == 9){
                    dp[i] = 2;
                    count++;
                }
            } else {
                int a = dp[i / 10], b = dp[i % 10];
                if(a == 1 && b == 1) dp[i] = 1;
                else if(a >= 1 && b >= 1){
                    dp[i] = 2;
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args){

         new Solution().rotatedDigits(10);

    }

}
