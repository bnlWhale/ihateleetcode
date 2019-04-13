public class Leetcode_921 {


    /*

         Minimum Add to Make Parentheses Valid


Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.

Formally, a parentheses string is valid if and only if:

It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.



Example 1:

Input: "())"
Output: 1
Example 2:

Input: "((("
Output: 3
Example 3:

Input: "()"
Output: 0
Example 4:

Input: "()))(("
Output: 4


Note:

S.length <= 1000
S only consists of '(' and ')' characters.





     */


    public int minAddToMakeValid(String str){

        if(str == null){
            return 0;
        }
        int balance = 0;
        int result = 0;
        for(int i=0;i<str.length();i++){
            char aChar = str.charAt(i);
            if(aChar == '('){
                balance +=1;
            }else{
                balance -=1;
            }
            if(balance==-1){
                balance++;
                result++;
            }
        }


        return balance+result;
    }



    public static void main(String[] args){



    }


}
