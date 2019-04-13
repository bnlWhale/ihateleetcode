/*


We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
Example :

Input: n = 10, pick = 6
Output: 6




 */





public class Leetcode_374_Guess_Number_Higher_or_Lower {


    public int guess(int target){
        return 0;
    }

     class Solution  {
        public int guessNumber(int n) {
            int start = 1;
            int end = n-1;

            while(start<=end){
                int mid = start + (end-start)/2;
                int temp = guess(mid);
                if(temp==0){
                    return mid;
                }else if(temp==-1){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }
            return n;
        }

    }


}
