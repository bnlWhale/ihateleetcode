/*


Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.

 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Leetcode_49_Gropu_anagrams {

    static  class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {

            List<List<String>> ans = new ArrayList<>();
            if(strs == null || strs.length==0){
                return ans;
            }

            Map<String, List<String>> map = new HashMap<>();
            for(String str:strs){
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String key = String.valueOf(chars);
                if(map.containsKey(key)){
                    List<String> list = map.get(key);
                    list.add(str);
                }else{
                    List<String> list = new ArrayList<>();
                    list.add(str);
                    map.put(key, list);
                }

            }
            for(List<String> list:map.values()){
                ans.add(list);
            }
            for(String key:map.keySet()){
                System.out.println(key);
            }

            System.out.println(ans.toString());
            System.out.println(map.values().toString());
            return ans;
        }
    }


    public static void main(String[] args){

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        new Solution().groupAnagrams(strs);
    }

}
