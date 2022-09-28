package com.algorithm.Questions.MinimumJumpsToReachArraysEnd;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Arrays;


/*https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1*/
public class MinimumJumps {
    public static void main(String[] args) {
        try {
            String path = "C:\\Users\\Darpan\\IdeaProjects\\DsAlgorithm\\src\\com\\algorithm\\Questions\\MinimumJumpsToReachArraysEnd\\inputs.txt";
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String Line = reader.readLine();
            int testCases = Integer.parseInt(Line);
            while (testCases-- > 0) {
                reader.readLine();//consume a line
                String[] strs = reader.readLine().trim().split(",");
                int []inputArray=new int[strs.length];
                for (int i = 0; i < strs.length; i++) {
                    inputArray[i]=Integer.parseInt(strs[i]);
                }
               System.out.println("Input="+Arrays.toString(inputArray));
                System.out.println(minJumpsOptimised(inputArray));
                //System.out.println(minJumps(inputArray));

            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    static int minJumpsOptimised(int[] arr) {

        int maxR = arr[0];
        int steps = arr[0];//how many steps left  to reach end//stepBuffer
        int Jump = 1;//when steps becomes 0 we jump
        int n = arr.length;
        if (n == 1) return 0;
        else if (arr[0] == 0) {
            return -1;
        } else {
            for (int i = 1; i < n; i++) {
                System.out.println("jump="+Jump);
                if (i == n - 1) return Jump;
                maxR = Math.max(maxR, arr[i] + i);
                steps--;
                if (steps == 0) {
                    //whenever our steps becomes 0 we jump
                    Jump++;
                    if (i >= maxR) {
                        return -1;
                    }
                    steps = maxR - i;
                }
            }
        }
        return Jump;
    }

    static int minJumps(int[] arr) {
        //not optimised code
        int[] jumps = new int[arr.length];
        if (arr.length == 1) return 0;
        else if (arr[0] == 0) return -1;
        Arrays.fill(jumps, 1, arr.length, Integer.MAX_VALUE);
        int n = jumps.length;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (i <= arr[j] + j) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                }
            }

        }
//        Arrays.stream(jumps).forEach((value -> System.out.print(value + " ")));


        return jumps[arr.length - 1] != Integer.MAX_VALUE ? jumps[arr.length - 1] : 0;//if we found a dead end
    }
}
