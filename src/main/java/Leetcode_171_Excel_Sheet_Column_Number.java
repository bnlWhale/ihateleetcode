/*


Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701



 */


public class Leetcode_171_Excel_Sheet_Column_Number {

    static class Solution {
        public int titleToNumber(String s) {


            int offset = 64;
            int basic = 26;

            int total = 0;
            int length = s.length();
            for(int i=0;i<length;i++){
                int multipleTimes = length-1-i;
                int charVal = Integer.valueOf(s.charAt(i))-offset;
                total += charVal*Math.pow(basic, multipleTimes);
            }





            System.out.println(total);

            return total;
        }
    }

    public static void main(String[] args){
         String s = "ZY";
         new Solution().titleToNumber(s);
    }


}
