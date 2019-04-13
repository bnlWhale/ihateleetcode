/*


Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]



 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcocd_22_Generate_Parentheses {

    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList();
            backtrack(ans, "", 0, 0, n);
            return ans;
        }

        public void backtrack(List<String> ans, String cur, int open, int close, int max){
            if (cur.length() == max * 2) {
                ans.add(cur);
                System.out.println("------------- "+cur.length()+"  "+cur+"  open:"+open);
                return;
            }

            if (open < max) {
                System.out.println("open: "+open+"  "+cur);
                backtrack(ans, cur + "(", open + 1, close, max);
            }
            if (close < open) {
                System.out.println("close:"+close+"  "+cur+"  open:"+open);
                backtrack(ans, cur + ")", open, close + 1, max);
            }
        }
    }

    public void doParenthesis(){
        List<String> strs = new Solution().generateParenthesis(3);
        System.out.println(Arrays.toString(strs.toArray()));
    }

    public static void main(String[] args){

        Leetcocd_22_Generate_Parentheses aObj = new Leetcocd_22_Generate_Parentheses();
        aObj.doParenthesis();

    }


}
