/*


Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21



 */



public class Leetcode_7_reverse_integer {

    static int reverse(int x){

        long result = 0;
        long num = (long)x;
        while(num !=0){

            result = result*10+num%10;
            num /= 10;
        }
        int test = (int)result;
        if(test == result){
            return test;
        }



        return 0;
    }

}
