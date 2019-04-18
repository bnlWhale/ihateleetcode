/*



Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5




 */



public class Leetcode_58_Length_last_word {

    static class Solution {
        public int lengthOfLastWord(String s) {

            int total = 0;
            for(int i=s.length()-1;i>=0;i--){
                if(s.charAt(i) ==' ' && total>0){
                   break;
                }
                if(s.charAt(i)!=' '){
                    total++;
                }

            }

            System.out.println(total);
            return total;
        }
    }


    public static void main(String[] arg){

          String S = "Hello World";
          new Solution().lengthOfLastWord(S);

    }

}
