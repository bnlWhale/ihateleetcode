/*

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

 */

import java.util.Arrays;

public class Leetcode_88 {


    public static  void merge(int[] nums1, int m, int[] nums2, int n) {

        int index=0;
        int total=m;
        for(int i=0;i<n;i++){
            int val = nums2[i];
            boolean notfind = true;
            for(int j=index;j<total;j++){
                if(val<=nums1[j]){
                    moveNextArr(nums1,j,total);
                    nums1[j]=val;
                    total++;
                    index = j+1;
                    //System.out.println(" * ");
                    /*for (int num:nums1
                    ) {
                        System.out.print(num+" ");
                    }*/
                    notfind = false;
                    break;
                }

            }
            if(notfind){
                if(total == nums1.length){
                    nums1[total-1]=val;
                }else{
                    nums1[total]=val;
                    total++;
                }
                index = total;
            }
        }
        for (int num:nums1
             ) {
            System.out.println(num);

        }
    }

    public static void moveNextArr(int[] arr, int from, int to){

        System.out.println("begin move "+from+" "+ to);
        for(int i=to;i>from;i--){
            if(i>arr.length){
                break;
            }
            arr[i] = arr[i-1];

        }
        for (int num:arr
        ) {
            System.out.print(num+" ");
        }
        System.out.println("  ");
    }

    public static void main(String[] args){

             //int[] nums1 = new int[]{1,2,3,0,0,0};
             //int[] nums2 = new int[]{2,5,6};
            // merge(nums1,3,nums2,3);


            // int[] nums1 = new int[]{4,5,6,0,0,0};
             //int[] nums2 = new int[]{1,2,3};
             //merge(nums1,3,nums2,3);

       // int[] nums1 = new int[]{0};
        //int[] nums2 = new int[]{1};
       // merge(nums1,1,nums2,1);

        int[] nums1 = new int[]{2,0};
        int[] nums2 = new int[]{1};
        //merge2(nums1,1,nums2,1);
        merge3(nums1,1,nums2,1);

        System.out.println(Arrays.toString(nums1));
    }


    public static void merge3(int A[], int m, int B[], int n){

        int indexA=m-1;
        int k=m+n-1;
        int trackNum=0;
        for(int i=n-1;i>=0;i--){
            boolean isBigger = true;

            while(isBigger){
                if(indexA<0){
                    A[k-trackNum] = B[i];
                    trackNum++;
                    break;
                }
                if(B[i]>=A[indexA]){
                    A[k-trackNum] = B[i];
                    isBigger = false;
                    trackNum++;

                }else{
                   A[k-trackNum] = A[indexA];
                   indexA--;
                    trackNum++;
                }
            }

        }

    }



    public static void merge2(int A[], int m, int B[], int n) {
        int i=m-1, j=n-1, k=m+n-1;
        while (i>-1 && j>-1) A[k--]= (A[i]>B[j]) ? A[i--] : B[j--];
        while (j>-1)         A[k--]=B[j--];

    }

}
