/*


Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false


 */



public class Leetcode_125_Valid_Palindrome {


    static class Solution {
        public boolean isPalindrome(String s) {

            char[] charArr = s.toCharArray();
            int left=0;
            int right=charArr.length-1;
            while(left<right){

                char cLeft = charArr[left];
                if(isNotAlphabet(cLeft)){
                    left++;
                    continue;
                }
                char cRight = charArr[right];
                if(isNotAlphabet(cRight)){
                    right--;
                    continue;
                }
                if(Character.toLowerCase(cLeft)!=Character.toLowerCase(cRight)){
                    System.out.println("false");
                    return false;
                }
                left++;
                right--;
            }

            System.out.println("true");
            return  true;
        }

        private boolean isNotAlphabet(char c){

            char cc = Character.toLowerCase(c);
            if(cc>='a' && cc<='z'){
                return false;
            }
            return true;
        }
    }


    public static void main(String[] args){

       // String str = "A man, a plan, a canal: Panama";
       // String str = "race a car";
        String str = "OP";
        new Solution().isPalindrome(str);


    }

}
