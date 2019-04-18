/*


Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"



 */


import java.util.Arrays;

public class Leetcode_541_Reverse_string_2 {

    static class Solution {
        public String reverseStr(String s, int k) {


            char[] chars = s.toCharArray();
            int length = s.length();
            int times = 0;
            boolean canDo = true;
            while (canDo) {
                int i = times * k;
                int j = (times + 1) * k - 1;
                if(j>=length){
                    j = length-1;
                }
                while (i < j) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                    i++;
                    j--;
                }
                times += 2;

                if (times * k > length) {
                    canDo = false;
                }

            }
            System.out.println(Arrays.toString(chars));


            return String.valueOf(chars);
        }
    }


    public static void main(String[] arg) {

        //String s = "abcdefg";
        String s = "abcd";
        int target = 8;
        new Solution().reverseStr(s, target);

    }

}
