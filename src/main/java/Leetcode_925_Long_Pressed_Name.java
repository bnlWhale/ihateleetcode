/*


Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.



Example 1:

Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.
Example 2:

Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
Example 3:

Input: name = "leelee", typed = "lleeelee"
Output: true
Example 4:

Input: name = "laiden", typed = "laiden"
Output: true
Explanation: It's not necessary to long press any character.

 */


public class Leetcode_925_Long_Pressed_Name {

    static class Solution {
        public boolean isLongPressedName(String name, String typed) {

           if(name.equals(typed)){
               return true;
           }

           int j=0;
           StringBuilder sb = new StringBuilder();
           for(int i=0;i<name.length();i++){

               char c = name.charAt(i);
               while( j<typed.length() && typed.charAt(j)!=c){
                   j++;
               }
               if(j<typed.length() && typed.charAt(j)==c){
                   sb.append(c);
                   j++;
               }
           }
            System.out.println(sb.toString());
           return sb.toString().equals(name);

        }

        public boolean isLongPressedName_1(String name, String typed) {
            int i = 0, m = name.length(), n = typed.length();
            for (int j = 0; j < n; ++j)
                if (i < m && name.charAt(i) == typed.charAt(j))
                    ++i;
                else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1))
                    return false;
            return i == m;
        }
    }

    public static void main(String[] arg){

        //String name = "alex";
        //String typed = "aaleex";

        String name = "leelee";
        String typed = "lleeelee";

        new Solution().isLongPressedName(name, typed);
    }

}
