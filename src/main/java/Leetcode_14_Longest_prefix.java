/*


Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

 */



public class Leetcode_14_Longest_prefix {


    class Solution {
        public String longestCommonPrefix(String[] strs) {


            if(strs == null || strs.length==0 ){
                return "";
            }


            int i=strs[0].length()>1?1:strs[0].length();
            String pre="";
            String temp = pre;
            while(i<=strs[0].length()){
                  pre = strs[0].substring(0,i);
                  for(String aStr:strs){
                      if(aStr.indexOf(pre)!=0){
                          return temp;
                      }
                  }
                  i++;
                  temp = pre;
            }

            return temp;
        }
    }

    public void doAction(){

             //String[] strs = {"flower","flow","flight"};
        //String[] strs = { "dog","racecar","car"};
        //String[] strs = {"aa","aa"};
        String[] strs = {"flower","flow","flight"};
        System.out.println(new Solution().longestCommonPrefix(strs));

    }

    public static void main(String[] arg){

        Leetcode_14_Longest_prefix lp = new Leetcode_14_Longest_prefix();
        lp.doAction();

    }

}
