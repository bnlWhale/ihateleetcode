/*


Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.



 */



public class Leetcode_557_Reverse_Words_in_String_III {


    static class Solution {
        public String reverseWords(String s) {

            String[] strArr = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<strArr.length;i++){
                sb.append(reverser(strArr[i]));
                if(i!=strArr.length-1){
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());

            return sb.toString();
        }

        private String reverser(String str){
            int i=0;
            int j=str.length()-1;
            char[] chars = str.toCharArray();
            while(i<j){
                char c = chars[i];
                chars[i] = chars[j];
                chars[j] = c;
                i++;
                j--;
            }
            return String.valueOf(chars);
        }
    }

    public static void main(String[] arg){

        String str = "Let's take LeetCode contest";
        new Solution().reverseWords(str);
    }

}
