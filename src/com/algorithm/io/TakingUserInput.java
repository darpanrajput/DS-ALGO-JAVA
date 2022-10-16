package com.algorithm.io;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class TakingUserInput {
    public static void main(String[] args) {
        Scanner br = new Scanner(new BufferedInputStream(System.in));
        System.out.println("Enter number of test cases ");
        int t = br.nextInt();
        while (t-->0) {
            System.out.println("Enter the array size for test case: "+t);
            int n = br.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter the Element(separated by space) for size=" + n);
            String enterKey = br.nextLine();//simply consumes enter key

            String lines = br.nextLine();
            String[] strs = lines.trim().split("\\s+");

            for (int i = 0; i < strs.length; i++) {

                arr[i] = Integer.parseInt(strs[i]);
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
