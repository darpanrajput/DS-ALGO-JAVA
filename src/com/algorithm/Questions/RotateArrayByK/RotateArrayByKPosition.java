package com.algorithm.Questions.RotateArrayByK;

import java.util.Arrays;

public class RotateArrayByKPosition {
    public static void main(String[] args) {
        rotate(new char[]{'a', 'b', 'c', 'd', 'e'}, 3);
        rotate(new char[]{'a', 'b', 'c', 'd', 'e'}, 2);
        rotate(new char[]{'a', 'b', 'c', 'd', 'e'}, -2);
        rotate(new char[]{'a', 'b', 'c', 'd', 'e'}, -1);
        rotate(new char[]{'1', '2', '3', '4', '5','6','7'}, 2);
    }

    static void rotate(char arr[], int k) {
        k = k % arr.length;
        if (k < 0) k = k + arr.length;
        System.out.println(k);

        //part 1
        reverse(arr, 0, arr.length - k - 1);
        //part 2
        reverse(arr, arr.length - k, arr.length - 1);

        //last
        reverse(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    static void reverse(char[] a, int i, int j) {
        int li = i, ri = j;
        while (li < ri) {
            char t = a[li];
            a[li] = a[ri];
            a[ri] = t;
            li++;
            ri--;
        }
    }
}
