/*

Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: True
Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: False
Note:
The input array won't violate no-adjacent-flowers rule.
The input array size is in the range of [1, 20000].
n is a non-negative integer which won't exceed the input array size.



 */


import java.util.Arrays;

public class Leetcode_605_Can_Place_Flowers {


    static class Solution_1 {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int i = 0, count = 0;
            while (i < flowerbed.length) {
                if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                    flowerbed[i] = 1;
                    count++;
                }
                i++;
            }
            return count >= n;
        }
    }




    static class Solution {





        public boolean canPlaceFlowers(int[] flowerbed, int n) {

            int count=0;
            int length = flowerbed.length;
            if(length<1 || length>20000){
                return false;
            }
            int i=0;
            while(i<length){

                if(flowerbed[i]==0){

                    if(i+1<length){
                        if(flowerbed[i+1] == 0){

                            if(i==0){
                                flowerbed[i]=1;
                                count++;
                            }
                            else if(i>0 && flowerbed[i-1]==0){
                                flowerbed[i]=1;
                                count++;
                            }
                        }

                    }else{

                       if(i==0 || i>0 && flowerbed[i-1]==0){
                           flowerbed[i]=1;
                           count++;
                       }
                    }



                }


                i++;

            }
            System.out.println(count);
            return count>=n;
        }



    }

    public static void main(String[] str1){
        //int[] flowerbed = {1,0,0,0,1};
        //int[] flowerbed = {1,0,0,0,1};
        int[] flowerbed = {1,0,0,0,0,1};
        int n=1;
        new Solution().canPlaceFlowers(flowerbed,n);

        int[] nums = {1,1,2,2,2};
        int max=0;
        int target=-1;
        int count=0;
        for(int i=0;i<nums.length-1;i++){
             if(nums[i] == nums[i+1]){
                 count++;
                 if(max<count){
                     max = count;
                     target = nums[i];
                 }
             }else{
                 count=0;
             }
        }


        String str = "loveleetcode";
        int[] charArr = new int[26];
        int index=-1;
        int total=-1;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            charArr[c-'a'] += 1;
        }

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(charArr[c-'a'] ==1){
                System.out.println("index is "+i+" "+c);
            }
        }

        int[] duplicate = {1,1,2,3};
        int j=0;
        for(int i=0;i<duplicate.length;i++){
                if(duplicate[i] != duplicate[j]){
                    duplicate[j]=duplicate[i];
                    j++;

                }
        }


        System.out.println("show "+Arrays.toString(duplicate));

    }

}
