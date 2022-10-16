package com.algorithm.Questions.KthSmallestInArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;
//https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/

public class KthSmallest {
    public static void main(String[] args) {
        WriteTestCase();

        String input="C:\\Users\\Darpan\\IdeaProjects\\DsAlgorithm\\src\\com\\algorithm\\Questions\\KthSmallestInArray\\Input.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(input));
            int testCases=Integer.parseInt(reader.readLine());
            while (testCases-->0){
                int k= Integer.parseInt(reader.readLine());
                String[]arr=reader.readLine().split(",");
                int [] inputArr=new int[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    inputArr[i] = Integer.parseInt(arr[i]);
                };
                int []copyArr=Arrays.copyOf(inputArr,inputArr.length);
               int res= getTheKthSmallestElement(inputArr,0,inputArr.length-1,k);
               System.out.println(res+checkTest(copyArr,res,k));
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }




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
            if(a[i]<pivot){
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
       boolean res= arr[k-1] == output;
        if (res){
            return ": passed";
        }else {
            return ": failed";
        }

    }

    public static void WriteTestCase() {
        String path = "C:\\Users\\Darpan\\IdeaProjects\\DsAlgorithm\\src\\com\\algorithm\\Questions\\KthSmallestInArray\\Input.txt";
        try {
            //write ten random test cases
            BufferedWriter bufferedWriter =new BufferedWriter(new FileWriter(path));
            int test=10;
            bufferedWriter.write(test+"\n");
            while (test-->0){
                //generate 100 random number between 100 and 200
                int randomSize=generateRandom(100,1);
                int[]  randomIntsArray = IntStream.generate(() -> new Random().nextInt(100) + 100).limit(randomSize).toArray();

                int k=generateRandom(randomSize,1);

//                bufferedWriter.write(Arrays.toString(randomIntsArray)+"\n");
                StringBuilder builder=new StringBuilder();

                bufferedWriter.write(String.valueOf(k)+"\n");
                Arrays.stream(randomIntsArray).forEach((arr)->{
                    builder.append(arr).append(",");
                });
                bufferedWriter.write(builder.append("\n").toString());

            }
            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static  int generateRandom(int high,int low){
        Random r = new Random();
        return high==low?r.nextInt(1) + low:r.nextInt(high-low) + low;
    }


}
