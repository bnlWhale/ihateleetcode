/*


Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since
             the decimal part is truncated, 2 is returned.


 */


public class Leetcode_69 {

    public static void main(String[] args){

        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {


        if(x==0){
            return 0;
        }
        int start = 1;
        int end = x;
        while(start+1<end){

            int mid = start + (end - start)/2;
            if(mid>x/mid){
                end = mid;
            }else{
                start = mid;
            }

        }

        if(end<=x/end){
            return end;
        }


        return start;

    }


    public static int sqrt_1(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }

    }

}
