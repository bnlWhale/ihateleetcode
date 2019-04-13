/*


Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?



 */



public class Leetcode_242 {


    public static void main(String[] args){
        isAnagram("anagram","nagaram");

        System.out.println(isAnagram1("aabb","abbb"));
    }


    public static boolean isAnagram(String s, String t) {

        if(s==null || t==null){
            return  false;
        }

        if(s.length()!=t.length()){
            return false;
        }

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int index = t.indexOf(c);
            if(index>-1){
                t = t.substring(0,index)+t.substring(index+1);
            }
        }


        return t.length()==0;
    }

    public static boolean isAnagram1(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }

}
