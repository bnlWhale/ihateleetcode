/*


Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place,
and all letters reverse their positions.



Example 1:

Input: "ab-cd"
Output: "dc-ba"
Example 2:

Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"


 */


public class Leetcode_917_Reverse_Only_Letters {

    static class Solution {
        public String reverseOnlyLetters(String S) {

            char[] chars = S.toCharArray();
            int i=0;
            int j=chars.length-1;
            while(i<j){

                if(isNotLetter(chars[i])){
                    i++;
                    continue;
                }
                if(isNotLetter(chars[j])){
                    j--;
                    continue;
                }

                char c = chars[i];
                chars[i] = chars[j];
                chars[j] = c;

                i++;
                j--;
            }

           // System.out.println(String.valueOf(chars));

            return String.valueOf(chars);
        }

        private boolean isNotLetter(char c){

            if('A'<=c && c<='Z' || 'a'<=c && c<='z'){
                return false;
            }

            return true;
        }
    }

    public static void main(String[] args){


       // String str = "ab-cd";
        String str = "a-bC-dEf-ghIj";
        new Solution().reverseOnlyLetters(str);

    }

}
