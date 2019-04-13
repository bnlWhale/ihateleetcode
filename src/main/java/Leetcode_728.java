/*


A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

Example 1:
Input:
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]



 */


import java.util.ArrayList;
import java.util.List;

public class Leetcode_728 {



    public static void main(String[] args){

        //selfDividingNumbers(1,22);
        System.out.println(isDivided(9));
    }

    public static void selfDividingNumbers(int left, int right){

        List<Integer> aList = new ArrayList<Integer>();
        for(int i=left;i<=right;i++){
            if(isDivided(i)){
                aList.add(i);
                System.out.println(i);
            }
        }
    }

    public static boolean isDivided(final int num){

        int temp = num;
        int mod = 0;
        while(temp>0){
             mod = temp%10;
             if(mod==0){
                 return false;
             }
             if(num%mod == 0){
                 temp = temp/10;
             }else{
                 return false;
             }
        }
        return true;
    }

    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        if (str.isEmpty()) {
            return false;
        }
        int i = 0;
        int length = str.length();
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
