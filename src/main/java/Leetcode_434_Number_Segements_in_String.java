/*


Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:

Input: "Hello, my name is John"
Output: 5


 */



public class Leetcode_434_Number_Segements_in_String {

    static class Solution {

        public int countSegments(String s) {

           char[] chars = s.toCharArray();
           int count=0;
           for(int i=0;i<chars.length;i++){

               if(chars[i]>='a' && chars[i]<='z' || chars[i]>='A' && chars[i]<='Z'){
                   count++;
                   while(++i<chars.length){
                       if(chars[i]>='a' && chars[i]<='z' || chars[i]>='A' && chars[i]<='Z'){
                           continue;
                       }else{
                           break;
                       }
                   }

               }

           }
            System.out.println(count);
           return count;
        }

        public int countSegments_1(String s) {
            int res=0;
            for(int i=0; i<s.length(); i++)
                if(s.charAt(i)!=' ' && (i==0 || s.charAt(i-1)==' '))
                    res++;
            return res;
        }
    }


    public static void main(String[] arg){

        //String str = "Hello, my name is John";
        String str = "hello";
        new Solution().countSegments(str);

    }

}
