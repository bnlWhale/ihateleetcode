/*


Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array.


Follow up:
Could you solve it using only O(1) extra space?


Example 1:

Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".


Example 2:

Input:
["a"]

Output:
Return 1, and the first 1 characters of the input array should be: ["a"]

Explanation:
Nothing is replaced.


 */

import java.util.Arrays;

public class Leetcode_443_String_Compression {

    static class Solution {
        public int compress(char[] chars) {

            int j = 1;
            int count = 1;
            for (int i = 1; i < chars.length; i++) {

                if (chars[i - 1] != chars[i]) {
                    if(count>1){

                        for(char c : Integer.toString(count).toCharArray()){
                            chars[j] = c;
                            j++;
                        }
                        chars[j] = chars[i];
                        j++;
                        count = 1;
                    }else{
                        chars[j] = chars[i];
                        j++;
                    }
                } else {
                    count++;
                }

                if(i==chars.length-1 && count>1){
                    for(char c : Integer.toString(count).toCharArray()){
                        chars[j] = c;
                        j++;
                    }
                }
            }


            System.out.println(Arrays.toString(chars)+"  "+j);
            return j;
        }
    }

    public static void main(String[] args) {

        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        //char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b','b'};
        new Solution().compress(chars);
    }
}
