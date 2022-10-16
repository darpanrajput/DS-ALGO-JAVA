package com.algorithm.Questions.MaxiAndMinOfArray;
//https://practice.geeksforgeeks.org/problems/find-minimum-and-maximum-element-in-an-array4428/1
public class MaxAndMinOfArray {
    static class Pair {
        int max, min;

        Pair() {
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1000, 11, 445, 330, 3000};
        Pair p = getMinMax(arr);
        Pair p2 = getMiniMax(arr, 0, arr.length - 1);
        System.out.println(p2.max + "," + p2.min);
    }


    public static Pair getMinMax(int a[]) {
        Pair p = new Pair();
        int n = a.length;
        if (n == 1) {
            p.min = a[0];
            p.max = a[0];
            return p;

        }
        if (a[0] > a[1]) {
            p.max = a[0];
            p.min = a[1];
        } else {
            p.min = a[0];
            p.max = a[1];
        }

        for (int i = 2; i < n; i++) {
            if (a[i] > p.max) {
                p.max = a[i];

            } else if (a[i] < p.min) {
                p.min = a[i];

            }
        }

        return p;
    }


    /*Recursion getting min max */

    public static Pair getMiniMax(int a[], int low, int high) {
        Pair p = new Pair();
        Pair leftSubArray = new Pair();
        Pair rightSubArray = new Pair();
        int mid;
        if (low == high) {
            p.min = p.max = a[low];
            return p;
        }

        //there is only 2 elements
        if (high == low + 1) {
            if (a[low] > a[high]) {
                p.max = a[low];
                p.min = a[high];
            } else {
                p.min = a[low];
                p.max = a[high];
            }

            return p;
        }

        /*if there are more two elements*/
        mid = low + (high - low) / 2;
        leftSubArray = getMiniMax(a, low, mid);
        rightSubArray = getMiniMax(a, mid + 1, high);

        /*Compare two part simultaneously*/
        if (leftSubArray.min < rightSubArray.min) {
            p.min = leftSubArray.min;
        } else {
            p.min = rightSubArray.min;
        }

        if (rightSubArray.max > leftSubArray.max) {
            p.max = rightSubArray.max;
        } else {
            p.max = leftSubArray.max;
        }

        return p;

    }

}
