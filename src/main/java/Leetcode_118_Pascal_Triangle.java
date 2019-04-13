
/*


Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


 */


import java.util.ArrayList;
import java.util.List;

public class Leetcode_118_Pascal_Triangle {

    static class Solution{

        public List<List<Integer>> generate(int numRows) {


            List<List<Integer>> ans = new ArrayList<>();
            if(numRows==0){
                return ans;
            }
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            ans.add(temp);

            for(int i=1;i<numRows;i++){
                temp = new ArrayList<>();
                List<Integer> last = ans.get(i-1);
                for(int j=0;j<i+1;j++){
                    if(j==0 || j==i){
                        temp.add(1);
                    }else{
                        int totl = last.get(j-1)+last.get(j);
                        temp.add(totl);
                    }
                }
                ans.add(temp);
            }
            return ans;

        }



    }


}
