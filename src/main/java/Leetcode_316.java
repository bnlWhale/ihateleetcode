/*

Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:

Input: "bcabc"
Output: "abc"
Example 2:

Input: "cbacdcbc"
Output: "acdb"


 */



public class Leetcode_316 {

    public static void main(String[] args){

        String str = "a";
        removeDuplicateLetters(str);
        //System.out.println(str);


    }

    public static void removeDuplicateLetters(String s){

        /*
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            for(int j=i+1;j<s.length();j++){
                 if(s.charAt(j) == c){
                     s = s.substring(0,j)+"X"+s.substring(j+1);
                 }
            }
        }
        System.out.println(s);
        */
        if(s == null){
            return;
        }
        int length = s.length();
        int index = 0;
        while (index<length){
            char c = s.charAt(index);
            int j=index+1;
            while(j<length){
                if(s.charAt(j) == c){
                    s = s.substring(0,j)+s.substring(j+1);
                    length = s.length();
                }
                j++;
            }
            index++;
        }
        System.out.println(s);

    }

}
