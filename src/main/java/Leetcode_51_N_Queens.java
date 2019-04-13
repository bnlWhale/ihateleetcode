/*


The n-queens puzzle is the problem of placing n queens on an n×n chessboard
such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement,
where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.


size 11
[["Q....","..Q..","....Q",".Q...","...Q."], check   02413
["Q....","...Q.",".Q...","....Q","..Q.."],   check  03142
[".Q...","...Q.","Q....","..Q..","....Q"],   check  13024
[".Q...","....Q","..Q..","Q....","...Q."], check    14203
["..Q..","Q....","...Q.",".Q...","....Q"], check    20314
["..Q..","....Q",".Q...","...Q.","Q...."], check    24130
["...Q.","Q....","..Q..","....Q",".Q..."],check     30241

["...Q.",".Q...","....Q","..Q..","Q...."],  check   31420
["....Q",".Q...","...Q.","Q....","..Q.."],  check   41302
["....Q","..Q..","Q....","...Q.",".Q..."]], check   42031

=======================================================================

[Q...., ..Q.., ....Q, .Q..., ...Q.],
[.Q..., ...Q., Q...., ..Q.., ....Q],
[.Q..., ....Q, ..Q.., Q...., ...Q.],
 [..Q.., ....Q, Q...., ...Q., .Q...],
 [..Q.., ....Q, .Q..., ...Q., Q....],
 [...Q., Q...., ..Q.., ....Q, .Q...],
 [...Q., .Q..., ....Q, Q...., ..Q..],
 [...Q., .Q..., ....Q, ..Q.., Q....],
 [....Q, .Q..., ...Q., Q...., ..Q..],
 [....Q, ..Q.., Q...., ...Q., .Q...]]
65

 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_51_N_Queens {


    private static int counter=0;

    public static void main(String[] args) {

        solveNQueens(5);
        System.out.println(counter);
    }


    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i;
        }
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), res);
        //System.out.println(res.size());
        //System.out.println("aaa"+Arrays.toString(res.toArray()));
        return res;

    }




    public static void backtrack(int[] nums, List<Integer> tempList, List<List<String>> res) {

        if (tempList.size() == nums.length) {
            List<String> sList = new ArrayList<>();
            int size = nums.length;
            for(int j=0;j<size;j++){

                StringBuffer sb = new StringBuffer();
                for(int k=0;k<size;k++){
                    String str = ".";
                    if(k==tempList.get(j)){
                        str="Q";
                    }
                    sb.append(str);
                }
                sList.add(sb.toString());

            }
            res.add(sList);
            System.out.println(Arrays.toString(tempList.toArray()));

        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) {
                    continue;
                }

                if(tempList.size()>0){
                   int lastNum = tempList.get(tempList.size()-1);
                   if(Math.abs(nums[i]-lastNum)==1){
                       continue;
                    }

                }
                counter++;

                //System.out.println(Arrays.toString(tempList.toArray()));

                boolean inDiagonal = false;
                int size = tempList.size();
                if(size>2){
                    if(tempList.get(0)==0 && tempList.get(1)==3 && tempList.get(2)==1){
                        //System.out.println();
                    }
                }

                if(size>1){
                    for(int j=0;j<size;j++){

                        if( Math.abs(nums[i] - tempList.get(j)) == Math.abs(size-j)){
                            inDiagonal = true;
                            break;
                        }

                    }
                    if(inDiagonal){
                        continue;
                    }
                }


                //System.out.println(Arrays.toString(tempList.toArray())+" "+nums[i]);

                tempList.add(nums[i]);
                backtrack(nums, tempList, res);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

}
