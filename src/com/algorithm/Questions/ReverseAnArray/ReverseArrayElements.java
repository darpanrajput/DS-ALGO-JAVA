package com.algorithm.Questions.ReverseAnArray;

import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/reverse-a-string/1
//https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
//https://leetcode.com/problems/reverse-string/description/
public class ReverseArrayElements {
    public static void main(String[] args) {

        char c = 97;
        System.out.print(c);
        int[] arr = new int[]{1, 2, 3};
        String[] arr2 = {"A", "B", "C", "D"};
        reverse(arr2, 0, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    public static void reverse(int[] arr, int low, int high) {

        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(String[] arr, int low, int high) {

        while (low < high) {
            String temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void reverseByRecursion(int[] arr, int start, int end) {
        if (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
            reverseByRecursion(arr, start, end);
        }
        System.out.println(Arrays.toString(arr));
    }
}
