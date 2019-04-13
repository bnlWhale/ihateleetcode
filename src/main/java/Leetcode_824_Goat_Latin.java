/*


A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
For example, the word 'apple' becomes 'applema'.

If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".

Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion from S to Goat Latin.



Example 1:

Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
Example 2:

Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"


 */


public class Leetcode_824_Goat_Latin {

    static class Solution {
        public String toGoatLatin(String S) {

            String vow = "aeiou";
            String[] strArr = S.split(" ");
            StringBuilder sb = new StringBuilder();
            String str = "";
            for(int i=0; i<strArr.length;i++){
                str = strArr[i];
                char c = str.charAt(0);
                if(vow.indexOf(String.valueOf(c).toLowerCase())>-1){
                    str += "ma";
                }else{
                    str = str.substring(1, str.length())+String.valueOf(str.charAt(0))+"ma";
                }
                for(int j=0;j<i+1;j++){
                    str += "a";
                }

                sb.append(str);
                if(i!=strArr.length-1){
                    sb.append(" ");
                }
            }

            System.out.println(sb.toString());

            return sb.toString();
        }
    }

    public static void main(String[] args){

        String str = "I speak Goat Latin";
        new Solution().toGoatLatin(str);

    }

}
