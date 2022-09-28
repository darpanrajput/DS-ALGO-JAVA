package com.algorithm.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class TestCasesChecking {
    public static void main(String[] args) {
        try {
            String path = "C:\\Users\\Darpan\\IdeaProjects\\DsAlgorithm\\src\\com\\algorithm\\Questions\\MinimumJumpsToReachArraysEnd\\inputs.txt";
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String Line = reader.readLine();
            int testCases = Integer.parseInt(Line);
            while (testCases-- > 0) {
                reader.readLine();
                String[] strs = reader.readLine().trim().split(",");
                int []inputArray=new int[strs.length];
                for (int i = 0; i < strs.length; i++) {
                    inputArray[i]=Integer.parseInt(strs[i]);
                }
                System.out.println("InputArray="+ Arrays.toString(inputArray));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
