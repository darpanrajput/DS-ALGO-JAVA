package com.algorithm.DS.KadanAlgo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KadanAlgo {

    public static class Structure{
        private int maxSum;
        private List<Integer> arr;

        public Structure(int maxSum, List<Integer> arr) {
            this.maxSum = maxSum;
            this.arr = arr;
        }

        public int getMaxSum() {
            return maxSum;
        }

        public void setMaxSum(int maxSum) {
            this.maxSum = maxSum;
        }

        public List<Integer> getArr() {
            return arr;
        }

        public void setArr(List<Integer> arr) {
            this.arr = arr;
        }
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}).getMaxSum());
        maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}).getArr().forEach(value->{
            System.out.print(value+",");
        });
        System.out.println("\n");
        System.out.println(maxSubArray(new int[]{-5,4,6,-3,4,-1}).getMaxSum());
        maxSubArray(new int[]{-5,4,6,-3,4,-1}).getArr().forEach(value->{
            System.out.print(value+",");
        });


    }


    public static Structure maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        HashMap<Integer,Integer>map=new HashMap<>();

        List<Integer> list = new ArrayList<>();


        for (int i = 0; i < nums.length; i++) {
            curSum = curSum + nums[i];
            if (curSum > maxSum) {
                maxSum = curSum;
                map.put(i,nums[i]);//potential array item for our maximum sum of sub array

            }

            if (curSum < 0) {
                curSum = 0;//resetting  current sum
                map.remove(i);//removing the values that was added because there is no point
                // of having a negative value as eventually it will decrease our sum, but we want the maximum
                // sum
            }

        }
        map.forEach((key, value) -> list.add(value));

        return new Structure(maxSum,list);
    }
}
