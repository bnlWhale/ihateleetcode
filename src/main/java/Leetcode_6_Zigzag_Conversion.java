/*


The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I

除了第一行和最后一行没有中间形成之字型的数字外，其他都有，而首位两行中相邻两个元素的index之差跟行数是相关的，为 2*nRows - 2, 根据这个特点，
我们可以按顺序找到所有的黑色元素在元字符串的位置，将他们按顺序加到新字符串里面。对于红色元素出现的位置也是有规律的，每个红色元素的位置
为 j + 2*nRows-2 - 2*i, 其中，j为前一个黑色元素的列数，i为当前行数。 比如当n = 4中的那个红色5，它的位置为 1 + 2*4-2 - 2*1 = 5，
为原字符串的正确位置。当我们知道所有黑色元素和红色元素位置的正确算法，我们就可以一次性的把它们按顺序都加到新的字符串里面


 */


public class Leetcode_6_Zigzag_Conversion {

    static class Solution {
        public String convert(String s, int numRows) {

            int length = s.length();
            int size = 2*numRows-2;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<numRows;i++){
                for(int j=i;j<length; j +=size){
                    //System.out.print(s.charAt(j));
                    sb.append(s.charAt(j));
                    int temp = j + size - 2 * i;
                    if(i>0 && i!=numRows-1 && temp<length){
                       // System.out.print(s.charAt(temp));
                        sb.append(s.charAt(temp));
                    }
                }
                //System.out.println();
            }


            return sb.toString();
        }



    }


    public static void main(String[] arg){

        String s = "PAYPALISHIRING";
        //String s = "0123456789ABCDEF";
        int numRow = 3;
        new Solution().convert(s, numRow);

    }

}
