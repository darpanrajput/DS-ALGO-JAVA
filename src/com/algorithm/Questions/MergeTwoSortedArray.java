package com.algorithm.Questions;

import java.util.Arrays;

/*Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order.
 Merge them in sorted order without using any extra space. Modify arr1 so that it
 contains the first N elements and modify arr2 so that it contains the last M elements.
 Example 1:
Input:
n = 4, arr1[] = [1 3 5 7]
m = 5, arr2[] = [0 2 6 8 9]
Output:
arr1[] = [0 1 2 3]
arr2[] = [5 6 7 8 9]
Explanation:
After merging the two
non-decreasing arrays, we get,
0 1 2 3 5 6 7 8 9.
Example 2:

Input:
n = 2, arr1[] = [10, 12]
m = 3, arr2[] = [5 18 20]
Output:
arr1[] = [5 10]
arr2[] = [12 18 20]
Explanation:
After merging two sorted arrays
we get 5 10 12 18 20.
*/
public class MergeTwoSortedArray {
    public static void main(String[] args) {
        mergeTwoSorted(new long[]{1, 3, 5, 7}, new long[]{0, 2, 6, 8, 9}, 4, 5);
        mergeTwoSortedArrayWithLittle_Variation(new long[]{1,2,3,0,0,0}, new long[]{2,5,6}, 3, 3);
    }

    public static void mergeTwoSorted(long[] arr1, long[] arr2, int n, int m) {
        if (n == 0 && m == 0) return;
        long last;
        int i;
        int j = m - 1;
        /*n = 2, arr1[] = [10, 12]
        m = 3, arr2[] = [5 18 20]
        1 3 5 7
        0 2 6 8 9

        */

        /*since the both the arrays are sorted we will traverse the second array
         * and then try to find out the correct position of it in arr1 once we found
         * we can then stop it */

        while (j >= 0) {
            last = arr1[n - 1];
            i = n - 2;//remember to initialise the i with n-2th element always for every second array element
            while (i >= 0 && arr1[i] > arr2[j]) {
                arr1[i + 1] = arr1[i];
                i--;
            }

            /*we are out of the loop when we find any number smaller than out jth element*/
            if (i != n - 2 || last > arr2[j]) {
                /*i!=m-2 means that our first array should have at-least 2 element to traverse*/
                arr1[i + 1] = arr2[j];
                arr2[j] = last;
            }
            j--;
        }

        System.out.println("Array1=" + Arrays.toString(arr1) + " array 2=" + Arrays.toString(arr2));
    }


    public static void mergeTwoSortedArrayWithLittle_Variation(long[] arr1, long[] arr2, int m, int n) {
  /*
  LINK->https://leetcode.com/problems/merge-sorted-array/

 You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge numbs1 and numb2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array
nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the
 elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.



Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 * */

        int i=m-1;
        int j=n-1;
        if (m==0 && n == 0) return;

       while(m>0 && i>=0 && j>=0){

           if(arr2[j]>arr1[i]){
               arr1[i+j+1]=arr2[j];
               j--;//Because my jth element has been placed at the right place in first array so shift to the next element
           }else{
               //right shift the first array element to accommodate the item from second array at the correct place
               // in the first array
               arr1[i+j+1]=arr1[i];
               i--;
           }


       }
        //if I get a1[0] means there is only 1 element in a2[8] which can be Shift to a1 array because a1 has size equal o len(a1)+len(a2)
        //exceptional case a1[0,0,0] for a2[1,2,4]
        if (j>=0){

            int  k=0;
            while (k<j+1){
                arr1[k]=arr2[k];
                k++;
            }

        }
        System.out.println("Array1=" + Arrays.toString(arr1) + " array 2=" + Arrays.toString(arr2));
    }
}
