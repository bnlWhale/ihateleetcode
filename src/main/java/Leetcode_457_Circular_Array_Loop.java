/*


You are given a circular array nums of positive and negative integers. If a number k at an index is positive, then move forward k steps. Conversely, if it's negative (-k), move backward k steps. Since the array is circular, you may assume that the last element's next element is the first element, and the first element's previous element is the last element.

Determine if there is a loop (or a cycle) in nums. A cycle must start and end at the same index and the cycle's length > 1. Furthermore, movements in a cycle must all follow a single direction. In other words, a cycle must not consist of both forward and backward movements.



Example 1:

Input: [2,-1,1,2,2]
Output: true
Explanation: There is a cycle, from index 0 -> 2 -> 3 -> 0. The cycle's length is 3.
Example 2:

Input: [-1,2]
Output: false
Explanation: The movement from index 1 -> 1 -> 1 ... is not a cycle, because the cycle's length is 1.
 By definition the cycle's length must be greater than 1.
Example 3:

Input: [-2,1,-1,-2,-2]
Output: false
Explanation: The movement from index 1 -> 2 -> 1 -> ... is not a cycle, because movement from index 1 -> 2 is a forward movement, but movement from index 2 -> 1 is a backward movement. All movements in a cycle must follow a single direction.



这一题我使用了快慢指针解决的，首先遍历一遍原数组，对于数组里面的每一个数值，设定一个slow指针，和一个fast指针，
slow指针每一次跳一格，fast指针每一次跳两格，当slow指针第一次跳时回到了原点，说明这个起点不可行，将nums[start]
设置为0，当fast指针跳到了一个格子，格子的值和fast指针跳之前的格子的值符号相反的时候，说明从start格子到fast指针
所在的格子都不可行，需要将从start格子到fast指针格子的全部格子都设置为0，这里使用的是setZero函数

这里还需要注意的是当fast跳两步之后和跳之前的索引相等的话，说明fast指针找到了一个单循环，单循环不能够算作循环，
因此这个时候依然需要将start到fast指针之间的全部格子都设为0

当某一次fast和slow指针索引相等的时候，说明这个时候找到了一个非单循环，这个循环是合理的，因此说明这个数组里面存在循环，
返回true

以后在做题的时候记住使用快慢指针判断路径里面是否存在循环的方法，使用一个快指针，一个慢指针，快指针每次移动两个，
慢指针每次移动一格，当快指针和慢指针移动到索引相等的时候，说明找到了一个循环。这里需要说明一下，只要路径中存在循环，
在不断的移动的过程中快指针最终一定会和慢指针相等，也就是说只要存在循环则一定可以找到


说实话，这道题描述的并不是很清楚，比如题目中有句话说循环必须是forward或是backward的，如果不给例子说明，
不太容易能get到point。所谓的循环必须是一个方向的就是说不能跳到一个数，再反方向跳回来，这不算一个loop。
比如[1, -1]就不是一个loop，而[1, 1]是一个正确的loop。看到论坛中一半的帖子都是各种需要clarify和不理解test
case就感觉很好笑～博主也成功踩坑了。弄清楚了题意后来考虑如何做，由于从一个位置只能跳到一个别的位置，而不是像图那样
一个点可以到多个位置，所以这里我们就可以根据坐标建立一对一的映射，一旦某个达到的坐标已经有映射了，说明环存在，
当然我们还需要进行一系列条件判断。首先我们需要一个visited数组，来记录访问过的数字，然后我们遍历原数组，
如果当前数字已经访问过了，直接跳过，否则就以当前位置坐标为起始点开始查找，进行while循环，计算下一个位置，
计算方法是当前位置坐标加上对应的数字，由于是循环数组，所以结果可能会超出数组的长度，所以我们要对数组长度取余。
当然上面的数字也可能是负数，加完以后可能也是负数，所以在取余之前还得再补上一个n，使其变为正数。此时我们判断，
如果next和cur相等，说明此时是一个数字的循环，不符合题意，再有就是检查二者的方向，数字是正数表示forward，
若是负数表示backward，在一个loop中必须同正或同负，我们只要让二者相乘，如果结果是负数的话，说明方向不同，
直接break掉。此时如果next已经有映射了，说明我们找到了合法的loop，返回true，否则建立一个这样的映射，
将next位置在visited数组中标记true，继续循环，参见代码如下：

 */


public class Leetcode_457_Circular_Array_Loop {


    static class Solution {

        public boolean circularArrayLoop(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    continue;
                }
                // slow/fast pointer
                int j = i, k = getIndex(i, nums);
                while (nums[k] * nums[i] > 0 && nums[getIndex(k, nums)] * nums[i] > 0) {
                    if (j == k) {
                        // check for loop with only one element
                        if (j == getIndex(j, nums)) {
                            break;
                        }
                        return true;
                    }
                    j = getIndex(j, nums);
                    k = getIndex(getIndex(k, nums), nums);
                    //System.out.println(j+" "+k);
                }
                // loop not found, set all element along the way to 0
                j = i;
                int val = nums[i];
                while (nums[j] * val > 0) {
                    int next = getIndex(j, nums);
                    nums[j] = 0;
                    j = next;
                }
            }
            return false;
        }

        public int getIndex(int i, int[] nums) {
            int n = nums.length;
            return i + nums[i] >= 0? (i + nums[i]) % n: n + ((i + nums[i]) % n);
        }

    }


    class Solution_1 {

        public boolean circularArrayLoop(int[] nums) {
            if (nums == null || nums.length <= 2) return false;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) return false;
                int slow = i, fast = getIndex(nums, i);
                while (nums[fast] * nums[i] > 0 && nums[getIndex(nums, fast)] * nums[i] > 0) {
                    if (slow == fast) {
                        if (slow == getIndex(nums, slow)) break;
                        return true;
                    }
                    slow = getIndex(nums, slow);
                    fast = getIndex(nums, getIndex(nums, fast));
                }
                slow = i;
                int pre = nums[i];
                while (nums[slow] * pre > 0) {
                    int next = getIndex(nums, slow);
                    nums[slow] = 0;
                    slow = next;
                }
            }
            return false;
        }
        private int getIndex(int[] nums, int i) {
            int len = nums.length;
            int next = i+nums[i];
            return next >= 0 ? next%len : next%len+len;
        }
    }

    public static void main(String[] args){

        int[] nums = {2,-1,1,2,1,2};
        new Solution().circularArrayLoop(nums);
    }

}
