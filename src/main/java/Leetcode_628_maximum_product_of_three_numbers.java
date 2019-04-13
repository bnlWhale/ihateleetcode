import java.util.ArrayList;
import java.util.List;

public class Leetcode_628_maximum_product_of_three_numbers {

    static class Solution{

        public int maximumProduct(int[] nums){

            int[] res={Integer.MIN_VALUE};
            backtrace(nums,new ArrayList<Integer>(),0, res);
            System.out.println(res[0]);
            return res[0];
        }


        private void backtrace(int[] nums, List<Integer> temp, int start, int[] res){

            if(temp.size()==3){
                int p=1;
                for(int t:temp){
                    p*=t;
                }
                if(res[0]<p){
                    res[0] = p;
                }
                //System.out.println(res[0]);
            }
            for(int i=start;i<nums.length;i++){

                temp.add(nums[i]);
                backtrace(nums, temp, i+1, res);
                temp.remove(temp.size()-1);
            }


        }


    }


    public static void main(String[] arg){
            int[] nums = {1,2,3,4};
            new Solution().maximumProduct(nums);
    }

}
