package com.algorithm.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class TestCasesChecking {
    public static void main(String[] args) {
        try {
            String path = "Inputs.txt";
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String Line = reader.readLine();
            int testCases = Integer.parseInt(Line);
            while (testCases-- > 0) {
                reader.readLine();
                String[] strs = reader.readLine().trim().split(",");
                int[] inputArray = new int[strs.length];
                for (int i = 0; i < strs.length; i++) {
                    inputArray[i] = Integer.parseInt(strs[i]);
                }
                System.out.println("InputArray=" + Arrays.toString(inputArray));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void WriteTestCase() {
        String path = "Input.txt";
        try {
            //write ten random test cases
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            int test = 10;
            bufferedWriter.write(test + "\n");
            while (test-- > 0) {
                //generate 100 random number between 100 and 200
                int randomSize = generateRandom(100, 1);
                int[] randomIntsArray = IntStream.generate(() -> new Random().nextInt(100) + 100).limit(randomSize).toArray();

                int k = generateRandom(randomSize, 1);

//                bufferedWriter.write(Arrays.toString(randomIntsArray)+"\n");
                StringBuilder builder = new StringBuilder();

                bufferedWriter.write(String.valueOf(k) + "\n");
                Arrays.stream(randomIntsArray).forEach((arr) -> {
                    builder.append(arr).append(",");
                });
                bufferedWriter.write(builder.append("\n").toString());

            }
            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static int generateRandom(int high, int low) {
        Random r = new Random();
        return high == low ? r.nextInt(1) + low : r.nextInt(high - low) + low;
    }


}
