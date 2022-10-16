package com.algorithm.Questions.SortArray0s1s2s;

import java.util.Arrays;
//https://leetcode.com/problems/sort-colors/description/
//https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
public class sortArrayOf0s1s2s {
    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 3};
//        swap(arr, 2, 0);
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[]{0, 1, 2, 0, 1, 2};
        int[] arr2 = new int[]{2, 0, 2, 1, 1, 0};

        sort(arr);
        sort(arr2);


    }

    private static void sort(int[] arr) {

        int mid, low, high, n;
        mid = low = 0;
        n = high = arr.length - 1;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, mid, high);
                    high--;
                    break;

            }
        }
        System.out.println(Arrays.toString(arr));

    }

    private static void swap(int[] a, int i1, int i2) {
        int temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }
}
