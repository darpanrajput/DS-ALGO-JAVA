package com.algorithm.HigherToLoweIndex;

import java.util.Arrays;

public class ConvertHighIndexesToLowIndexesWithSameMagnitude {
    public static void main(String[] args) {
        int[]a=new int[]{121,23,41,14123,42,1,3,2};
        int n=a.length;
        int[] temp = Arrays.copyOf(a,n);
        Arrays.sort(temp);
        for (int i = 0; i < n; i++) {
            a[i]=lowerBound(a[i],temp,0,n)+1;
        }
        System.out.println("Converted Array");
        System.out.println(Arrays.toString(temp));
        System.out.println(Arrays.toString(a));
    }


    private static int lowerBound(int ele, int[] temp, int low, int high) {
        int mid=0;
        while(low<high){
            mid=low+(high-low)/2;
            if(ele==temp[mid]){
                return mid;
            }else if(ele>temp[mid]){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return mid;
    }
}
