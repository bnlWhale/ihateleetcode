/*


Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
Note:

S will be a string with length between 1 and 12.
S will consist only of letters or digits.



 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_978 {


    public static void main(String[] args){

        String S = "a1b2";
        letterCasePermutation(S);
    }

    public static List<String> letterCasePermutation(String S) {

        List<String> res = new ArrayList<String>();
        char[] arr = S.toLowerCase().toCharArray();
        backtrack(arr, 0, res);
        System.out.println(Arrays.toString(res.toArray()));
        return res;
    }


    private static void backtrack(char[] arr, int pos, List<String> res){

        if(pos == arr.length){
            res.add(new String(arr));
            return;
        }
        backtrack(arr, pos+1, res);
        if(arr[pos] >= 'a' && arr[pos] <= 'z'){
            arr[pos] = (char)(arr[pos] - 'a' + 'A');
            backtrack(arr, pos+1, res);
            arr[pos] = (char)(arr[pos] - 'A' + 'a');
        }
    }


}
