/*

Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.
Example 1:
Input: ["23:59","00:00"]
Output: 1
Note:
The number of time points in the given list is at least 2 and won't exceed 20000.
The input time is legal and ranges from 00:00 to 23:59.



 */


import java.util.ArrayList;
import java.util.List;

public class Leetcode_539_Minimum_Time_Difference {


    public class Solution_1 {
        public int findMinDifference(List<String> timePoints) {
            boolean[] mark = new boolean[24 * 60];
            for (String time : timePoints) {
                String[] t = time.split(":");
                int h = Integer.parseInt(t[0]);
                int m = Integer.parseInt(t[1]);
                if (mark[h * 60 + m]) return 0;
                mark[h * 60 + m] = true;
            }

            int prev = 0, min = Integer.MAX_VALUE;
            int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
            for (int i = 0; i < 24 * 60; i++) {
                if (mark[i]) {
                    if (first != Integer.MAX_VALUE) {
                        min = Math.min(min, i - prev);
                    }
                    first = Math.min(first, i);
                    last = Math.max(last, i);
                    prev = i;
                }
            }

            min = Math.min(min, (24 * 60 - last + first));

            return min;
        }
    }

    static class Solution {
        public int findMinDifference(List<String> timePoints) {


            return -1;
        }
    }


    public static void main(String[] arg){

        List<String> time = new ArrayList<>();
        time.add("23:59");
        time.add("00:00");

        List<Integer> numList = new ArrayList<>();
        numList.add(4);
        numList.add(3);
        numList.add(7);
        //numList.sort((m, n) -> (m-n).min);


    }


}
