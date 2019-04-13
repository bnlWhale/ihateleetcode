/*


Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
Example 1:
Input: "USA"
Output: True
Example 2:
Input: "FlaG"
Output: False


 */



public class Leetcode_520_Detect_Capital {

    static class Solution {
        public boolean detectCapitalUse(String word) {

            int count_low = 0;
            int count_cap = 0;
            int total = 0;
            int only = 0;
            char[] chars = word.toCharArray();
            for(int i=0;i<chars.length;i++){
                char c = chars[i];
                if(!Character.isLetter(c)){
                    return false;
                }
                if(c>='a' && c<='z'){
                    count_low++;
                }
                if(c>='A' && c<='Z'){
                    count_cap++;
                    if(i==0){
                        only = 1;
                    }
                }
                total++;
            }
            if(total==count_cap || total==count_low){
                return true;
            }
            if(count_cap>0 && count_cap==only){
                return true;
            }

            return false;
        }
    }

    public static void main(String[] args){

        String word = "FlaG";
        new Solution().detectCapitalUse(word);

    }

}
