/*


Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).

这道题让我们分割数组，两两一对，让每对中较小的数的和最大。这题难度不大，用贪婪算法就可以了。
由于我们要最大化每对中的较小值之和，那么肯定是每对中两个数字大小越接近越好，因为如果差距过大，而我们只取较小的数字，那么大数字就浪费掉了。明白了这一点，我们只需要给数组排个序，
然后按顺序的每两个就是一对，我们取出每对中的第一个数即为较小值累加起来即可，参见代码如下：


 */


import java.util.Arrays;

public class Leetcode_561_Array_Partition_I {


    class Solution {
        public int arrayPairSum(int[] nums) {

            Arrays.sort(nums);
            int sum=0;
            for(int i=0;i<nums.length;i+=2){
                sum += nums[i];
            }

            return sum;
        }
    }

}
