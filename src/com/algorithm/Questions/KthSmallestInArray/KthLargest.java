package com.algorithm.Questions.KthSmallestInArray;
//https://leetcode.com/problems/kth-largest-element-in-an-array/
import java.util.Arrays;

public class KthLargest {
    public static void main(String[] args) {
        int a[]=new int[]{3,2,1,5,6,4};
        int b[]=Arrays.copyOf(a,a.length);
        int res=getTheKthSmallestElement(a,0,a.length-1,2);
        System.out.println(res+checkTest(b,res,2));
    }

    static  int getTheKthSmallestElement(int []a,int low, int high,int k){

        int partition=partition(a,low,high,k);
        if(partition==k-1){
            return a[partition];
        } else if (partition>k-1) {
            return getTheKthSmallestElement(a,low,partition-1,k);
        }else{
            return   getTheKthSmallestElement(a,partition+1,high,k);
        }


    }
    static int partition(int[] a, int low, int high, int k) {

        int pivot = a[high];
        int pivotLoc = low;
        //performing sorting also
        for (int i = low; i <= high; i++) {
            //will iterate on certain portion or full array
            if(a[i]>pivot){// this will give  the largest element
                int temp=a[i];
                a[i]=a[pivotLoc];
                a[pivotLoc]=temp;
                pivotLoc++;

            }
        }
        int temp=a[pivotLoc];
        a[pivotLoc]=a[high];
        a[high]=temp;
        return pivotLoc;// return the index of our immediate largest w.r.t high or just high
    }


    static String checkTest(int[] arr,int output,int k){
        Arrays.sort(arr);
        reverse(arr);
        boolean res= arr[k-1] == output;
        if (res){
            return ": passed";
        }else {
            return ": failed";
        }

    }

    public static void reverse(int[] array)
    {

        // Length of the array
        int n = array.length;

        // Swaping the first half elements with last half
        // elements
        for (int i = 0; i < n / 2; i++) {

            // Storing the first half elements temporarily
            int temp = array[i];

            // Assigning the first half to the last half
            array[i] = array[n - i - 1];

            // Assigning the last half to the first half
            array[n - i - 1] = temp;
        }
    }

}

