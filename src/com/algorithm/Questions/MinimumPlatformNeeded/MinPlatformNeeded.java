package com.algorithm.Questions.MinimumPlatformNeeded;

import java.io.BufferedReader;

import java.io.FileReader;

import java.util.Arrays;
//Video-->https://www.youtube.com/watch?v=38JLfQGVlkw&t=297s
public class MinPlatformNeeded {
    public static void main(String[] args) {
       /* System.out.println(findPlatform(new int[]{900, 940, 950, 1100, 1500, 1800},
                new int[]{910, 1200, 1120, 1130, 1900, 2000}, 6));//3
        System.out.println(findPlatform(new int[]{900, 1100, 1235}, new int[]{1000, 1200, 1240}, 3));//1*/

        try {
            String path = "C:\\Users\\Darpan\\IdeaProjects\\DsAlgorithm\\src\\com\\algorithm\\Questions\\MinimumPlatformNeeded\\InputTests.txt";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            int tesCases = Integer.parseInt(bufferedReader.readLine().trim());
            while (tesCases-- > 0) {
                int n = Integer.parseInt(bufferedReader.readLine());
                String[] a = bufferedReader.readLine().split("\\s");
                int[] arr = new int[a.length];

                for (int i = 0; i < a.length; i++) {
                    arr[i] = Integer.parseInt(a[i].toCharArray()[0]=='0'?a[i].substring(0):a[i]);
                }
                a = bufferedReader.readLine().split("\\s");
                int[] dep = new int[a.length];
                for (int i = 0; i < a.length; i++) {
                    dep[i] = Integer.parseInt(a[i].toCharArray()[0]=='0'?a[i].substring(0):a[i]);
                }
                System.out.println(findPlatform(arr, dep, n));
            }
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int findPlatform(int arr[], int dep[], int n)
    {   // add your code here
        // add your code here

        Arrays.sort(arr);
        Arrays.sort(dep);

        int platformNeeded=1;
        int res=1;
        int i=1; int j=0;
        while(i<n && j<n){

            if(arr[i]<=dep[j]){

                platformNeeded++;
                i++;

                if(platformNeeded>res) res=platformNeeded;

            }else{
                platformNeeded--;
                j++;
            }
        }
        return res;

    }
}
