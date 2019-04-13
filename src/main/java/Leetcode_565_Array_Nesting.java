/*



A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.

Suppose the first element in S starts with the selection of element A[i] of index = i, the next element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs in S.



Example 1:

Input: A = [5,4,0,3,1,6,2]
Output: 4
Explanation:
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

One of the longest S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}


Note:

N is an integer within the range [1, 20,000].
The elements of A are all distinct.
Each element of A is an integer within the range [0, N-1].

这道题让我们找嵌套数组的最大个数，给的数组总共有n个数字，范围均在[0, n-1]之间，题目中也把嵌套数组的生成解释的很清
楚了，其实就是值变成坐标，得到的数值再变坐标。那么实际上当循环出现的时候，
嵌套数组的长度也不能再增加了，而出现的这个相同的数一定是嵌套数组的首元素

In the last approach, we observed that in the worst case, all the elements of the numsnums
array are added to the sets corresponding to all the starting indices. But, all these sets
correspond to the same set of elements only, leading to redundant calculations.

We consider a simple example and see how this problem can be resolved. From the figure below,
we can see that the elements in the current nesting shown by arrows form a cycle. Thus, the same
elements will be added to the current set irrespective of the first element chosen to be added to
the set out of these marked elements.


Thus, when we add an element nums[j]nums[j] to a set corresponding to any of the indices, we mark
its position as visited in a visitedvisited array. This is done so that whenever this index
is chosen as the starting index in the future, we do not go for redundant countcount calculations,
since we've already considered the elements linked with this index, which will be added to a
new(duplicate) set.

By doing so, we ensure that the duplicate sets aren't considered again and again.

Further, we can also observe that no two elements at indices ii and jj will lead to a jump
to the same index kk, since it would require nums[i] = nums[j] = knums[i]=nums[j]=k, which isn't
possible since all the elements are distinct. Also, because of the same reasoning, no element
 outside any cycle could lead to an element inside the cycle. Because of this, the use of
  visitedvisited array goes correctly.

 */


import java.util.Arrays;

public class Leetcode_565_Array_Nesting {


    static class Solution {
        public int arrayNesting(int[] nums) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != Integer.MAX_VALUE) {
                    int start = nums[i], count = 0;
                    while (nums[start] != Integer.MAX_VALUE) {
                        int temp = start;
                        start = nums[start];
                        count++;
                        nums[temp] = Integer.MAX_VALUE;
                    }
                    res = Math.max(res, count);
                    System.out.println(Arrays.toString(nums));
                }
            }
            return res;
        }
    }


    static class Solution_1 {
        public int arrayNesting(int[] nums) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                int start = nums[i], count = 0;
                do {
                    start = nums[start];
                    count++;
                    System.out.println(start+"  "+nums[i]+"  "+i);
                }
                while (start != nums[i]);
                System.out.println();
                res = Math.max(res, count);

            }
            return res;
        }
    }

    public static void main(String[] args){

        int[] A = {5,4,0,3,1,6,2};
        new Solution_1().arrayNesting(A);


    }

}
