package com.algorithm.Questions.MaxiAndMinOfArray;
//https://leetcode.com/problems/removing-minimum-and-maximum-from-array/description/

/*
* Explanation
Find index i of the minimum
Find index j of the maximum

To remove element A[i],
we can remove i + 1 elements from front,
or we can remove n - i elements from back.*/
public class MinDeletions {
    public static void main(String[] args) {
        // [0,-4,19,1,8,-2,-3,5]
        //n=8;
        //i=2,j=1;
        //3,2->max-3;
        //6,7->max-7
        //3,7->min-3;
        //11,7->min-7
        //3,7->min-3
        //Math.min(Math.min(Math.max(i + 1, j + 1), Math.max(n - i, n - j)), Math.min(i + 1 + n - j, j + 1 + n - i));
        /*
        * [2,10,7,5,4,1,8,6]
        * n=8
        * i=1,j=5
        * 2,6-max->6
        * 7,3-max->7
        * 6,7-min->6
        * 5,13-min->5
        * 6,5-min->5*/

        int[] arr = new int[]{0, -4, 19, 1, 8, -2, -3, 5};
        System.out.println(minimumDeletions(arr));
    }

    public static int minimumDeletions(int[] A) {
        int i = 0, j = 0, n = A.length;
        for (int k = 0; k < n; ++k) {
            if (A[i] < A[k]) i = k;
            if (A[j] > A[k]) j = k;
        }
        return Math.min(Math.min(Math.max(i + 1, j + 1), Math.max(n - i, n - j)), Math.min(i + 1 + n - j, j + 1 + n - i));
    }
}
