package com.algorithm.Questions.MinimiseTheMaximumDiffBetHeightOfTower;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class MinimiseTheMxDiffOfTowerHeights {
    public static void main(String[] args) {
//        System.out.println(getMinDiffGFG(new int[]{4, 2, 3, 6}, 4, 3));//output->//4
//        System.out.println(getMinDiffLeetcode(new int[]{4, 2, 3, 6}, 4, 3));//output->//4
//        System.out.println(getMinDiffGFG(new int[]{1, 5, 8, 10}, 4, 2));//output->//5
//        System.out.println(getMinDiffLeetcode(new int[]{1, 5, 8, 10}, 4, 2));//output->//5
//        System.out.println(getMinDiffGFG(new int[]{3, 9, 12, 16, 20}, 5, 3));//output->//11
//        System.out.println(getMinDiffLeetcode(new int[]{3, 9, 12, 16, 20}, 5, 3));//output->//11
//        System.out.println(getMinDiffGFG(new int[]{2, 6, 3, 4, 7, 2, 10, 3, 2, 1}, 10, 5));//output->//7
//        System.out.println(getMinDiffLeetcode(new int[]{2, 6, 3, 4, 7, 2, 10, 3, 2, 1}, 10, 5));//output->//7
//        System.out.println(getMinDiffGFG(new int[]{0, 10}, 2, 2));//output-->6
//        System.out.println(getMinDiffLeetcode(new int[]{0, 10}, 2, 2));//output-->6


        String path = "C:\\Users\\Darpan\\IdeaProjects\\DsAlgorithm\\src\\com\\algorithm\\Questions\\MinimiseTheMaximumDiffBetHeightOfTower\\Inputs.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            int testCases = Integer.parseInt(reader.readLine());
            while (testCases-- > 0) {
                int n = Integer.parseInt(reader.readLine());
                int k = Integer.parseInt(reader.readLine());
                String[] strs = reader.readLine().split(",");
                int[] inputArray = new int[strs.length];
                for (int i = 0; i < strs.length; i++) {
                    inputArray[i] = Integer.parseInt(strs[i].trim());
                }
                System.out.println(
                        "GFG="+getMinDiffGFG(inputArray,n,k));
                System.out.println("Leetcode="+getMinDiffLeetcode(inputArray,n,k));

            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static int getMinDiffGFG(int[] arr, int n, int k) {

        Arrays.sort(arr);
        int MinEle = 0;
        int MaxEle = 0;
        int range;
        range = arr[n - 1] - arr[0];

        int max = arr[n - 1] - k;

        int min = arr[0] + k;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= k) {

                MaxEle = Math.max(arr[i - 1] + k, max);

                MinEle = Math.min(min, arr[i] - k);

                range = Math.min(range, (MaxEle - MinEle));
            }

        }

        return range;
    }

    static int getMinDiffLeetcode(int[] arr, int n, int k) {

        Arrays.sort(arr);
        int MinEle = 0;
        int MaxEle = 0;
        int range;
        range = arr[n - 1] - arr[0];
        int max = arr[n - 1] - k;
        int min = arr[0] + k;
        for (int i = 1; i < arr.length; i++) {


            MaxEle = Math.max(arr[i - 1] + k, max);
            MinEle = Math.min(min, arr[i] - k);
            range = Math.min(range, (MaxEle - MinEle));


        }

        return range;
    }


}
