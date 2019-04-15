/*


The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.




 */


public class Leetcode_38_Count_and_Say {

    static class Solution {
        public String countAndSay(int n) {

            String str = "1";
            String cur="";
            int length=0;
            for(int i=2;i<=n;i++){
                length = str.length();
                int j=0;
                int count=1;
                while(j<length){

                    if(j+1<length && str.charAt(j) == str.charAt(j+1)){
                        count++;
                        j++;
                        continue;
                    }else{
                        cur += String.valueOf(count)+String.valueOf(str.charAt(j));
                        j++;
                        count=1;
                    }
                }
                str = cur;
                cur="";
            }


            System.out.println(str);
            return str;
        }
    }



     class Solution_1 {
        public String countAndSay(int n) {
            StringBuilder curr=new StringBuilder("1");
            StringBuilder prev;
            int count;
            char say;
            for (int i=1;i<n;i++){
                prev=curr;
                curr=new StringBuilder();
                count=1;
                say=prev.charAt(0);

                for (int j=1,len=prev.length();j<len;j++){
                    if (prev.charAt(j)!=say){
                        curr.append(count).append(say);
                        count=1;
                        say=prev.charAt(j);
                    }
                    else count++;
                }
                curr.append(count).append(say);
            }
            return curr.toString();

        }
    }


    public static void main(String[] args){
        new Solution().countAndSay(5);
    }

}
