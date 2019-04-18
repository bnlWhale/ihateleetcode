/*


Given an input string, reverse the string word by word.



Example 1:

Input: "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.


Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.



 */

import java.util.*;

public class Leetcode_151_Reverse_words_in_String {

    static class Solution {
        public String reverseWords(String s) {

            List<String> list = new ArrayList<>();
            String str = getWord(s, list);

            int i=0;
            int j=list.size()-1;
            while(i<j){
                String temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                i++;
                j--;
            }
            StringBuilder sb = new StringBuilder();
            list.stream().forEach(arg-> sb.append(arg));
            return sb.toString();
        }

        private String getWord(String s, List<String> words) {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == ' '){
                    continue;
                }
                sb.append(s.charAt(i));
                if(i==s.length()-1 || s.charAt(i+1)==' '){
                    words.add(sb.toString());
                    sb = new StringBuilder();
                }
            }

            return sb.toString();
        }
    }

    public static void main(String[] arg) {

        //String S = "the sky is blue";
        String S = "a good   example";
        new Solution().reverseWords(S);

    }

}
