package com.algorithm.sorting;

import java.io.*;
import java.util.Arrays;


public class MergeSort {
    public static void main(String[] args) throws IOException {

        int[] a = {38, 27, 43, 3, 9, 82};
        int inversion=0;
        dived(a, 0, 5,0);
        System.out.println(Arrays.toString(a));

//        Reading test cases from file
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            int t= Integer.parseInt(reader.readLine());
            System.out.println("t="+t);
            int[]arr;
            while (t-->0) {
                int size=Integer.parseInt(reader.readLine());
                System.out.println("size="+size);
                arr=new int[size];
                String[] textArray=reader.readLine().split("\\s");
                for (int i = 0; i < arr.length; i++) {
                    arr[i]= Integer.parseInt(textArray[i]);
                }
                dived(arr, 0, arr.length-1,inversion);
                System.out.println(Arrays.toString(arr));
                System.out.println("inversion="+inversion);
            }
            reader.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static void dived(int[] a, int l, int r,int inversion) {

        if (l < r) {

            int m = l + (r - l) / 2;//to prevent overflow
            dived(a, l, m,inversion);
            dived(a, m + 1, r,inversion);
            conquer(a, l, m, r,inversion);
        }
    }

    private static void conquer(int[] arr, int low, int mid, int high,int inversion) {
        int[] tempArray = new int[(high - low) + 1];//added one because indexing starts from 0 inn array
        int si = low;
        int ei = mid + 1;
        int k = 0;

        while (si <= mid && ei <= high) {
            if (arr[si] <= arr[ei]) {
                tempArray[k++] = arr[si++];//=a[j++] for reverse order
            } else {
                tempArray[k++] = arr[ei++];//=a[i++] for reverse order
                inversion++;

            }
        }

//        only either of below two will run
        while (si <= mid) {
            tempArray[k++] = arr[si++];
        }

        while (ei <= high) {
            tempArray[k++] = arr[ei++];
        }

        for (int i = 0, j = low; i < tempArray.length; i++, j++) {
            arr[j] = tempArray[i];
        }

    }


}
