/*

Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.


irst of all we should take care of some edge cases. All negative numbers are not palindrome, for example: -123 is not a palindrome since the '-' does not equal to '3'. So we can return false for all negative numbers.

Now let's think about how to revert the last half of the number. For number 1221, if we do 1221 % 10, we get the last digit 1, to get the second to the last digit, we need to remove the last digit from 1221, we could do so by dividing it by 10, 1221 / 10 = 122. Then we can get the last digit again by doing a modulus by 10, 122 % 10 = 2, and if we multiply the last digit by 10 and add the second last digit, 1 * 10 + 2 = 12, it gives us the reverted number we want. Continuing this process would give us the reverted number with more digits.

Now the question is, how do we know that we've reached the half of the number?

Since we divided the number by 10, and multiplied the reversed number by 10, when the original number is less than the reversed number, it means we've processed half of the number digits.


 */


public class Leetcode_9_Palindrome_number {


    class Solution {
        public boolean isPalindrome(int x) {

            if(x<0 || (x!=0 && x%10==0)) return false;
            int rev = 0;
            int nowX = x;
            while(nowX>0){

                rev = rev*10 + nowX%10;

                nowX=nowX/10;
            }
            System.out.println(rev+"  "+x+"  "+(x==rev));
            return x==rev;
        }
    }

    public void doAction(int n){
        new Solution().isPalindrome(n);
    }

    public static void main(String[] args){

        Leetcode_9_Palindrome_number code9 = new Leetcode_9_Palindrome_number();
        int n=121;
        code9.doAction(n);



    }

}
