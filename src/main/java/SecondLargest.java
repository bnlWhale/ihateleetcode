/*

It is positive random integer array = {4,5,6,7,6,5,7,1,2,2,5,6}
Return the Second Largest Number


 */


public class SecondLargest {


    public static int findSecondLargest(int[] nums) {

        int max = 0;
        int secMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                secMax = max;
                max = nums[i];
            }

        }
        return secMax;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 4, 1};
        System.out.println(findSecondLargest(nums));

    }


}
