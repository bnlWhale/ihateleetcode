/*

Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.



Example:

Input:
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.


 */


import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class Leetcode_819_Most_Common_Word {

    static class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {


            Set<String> banSet = new HashSet<>();
            for(String banStr:banned){
                banSet.add(banStr.toLowerCase());
            }


            String[] pArr = paragraph.split(" ");
            Map<String, Integer> map = new HashMap<>();
            for(int i=0;i<pArr.length;i++){

                String temp = pArr[i].toLowerCase();
                if(banSet.contains(temp)){
                    continue;
                }
                if(temp.indexOf(",")>-1 || temp.indexOf(".")>-1){
                    temp = temp.substring(0, temp.length()-1);
                }

                map.put(temp, map.getOrDefault(temp, 0)+1);
            }

            //String ans = "";
            //map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);

            String max= map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
            //System.out.println(max);

            //LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
           // map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())).forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
           // System.out.println(reverseSortedMap);








            return max;
        }
    }


    public static void main(String[] args){

        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        new Solution().mostCommonWord(paragraph, banned);

    }

}
