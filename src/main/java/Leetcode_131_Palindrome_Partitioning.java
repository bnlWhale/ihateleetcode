/*


Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]



 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_131_Palindrome_Partitioning {

    public static void main(String[] args){

       // String target = "aab";
        String target = "3124";
        List<List<String>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), target, 0);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), s, 0);
        return list;
    }


    public static void backtrack(List<List<String>> list, List<String> tempList, String s, int start){

        //System.out.println(Arrays.toString(tempList.toArray()));
        if(start == s.length()){
            list.add(new ArrayList<>(tempList));
           // System.out.println(Arrays.toString(tempList.toArray()));
        }
        else{
            for(int i = start; i < s.length(); i++){
                if(isPalindrome(s, start, i)){
                    tempList.add(s.substring(start, i + 1));
                    //System.out.println(s.substring(start, i + 1));
                    backtrack(list, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }


    public static boolean isPalindrome(String s, int low, int high){
        while(low < high)
            if(s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }

}
