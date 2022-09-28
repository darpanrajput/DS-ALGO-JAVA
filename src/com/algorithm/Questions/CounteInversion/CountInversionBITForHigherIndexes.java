package com.algorithm.Questions.CounteInversion;

import java.util.Arrays;

public class CountInversionBITForHigherIndexes {
    public static void main(String[] args) {
        int a[]=new int[]{7,-90,100,1};
        int arr[] = {8, 4, 2, 1};
        convert(a);
        convert(arr);
        System.out.println(countInversion(a));
        System.out.println("\nsecond array");
        System.out.println(countInversion(arr));
    }


    static int countInversion(int[] a) {
        int count = 0;
        int max = getMAX(a);
        int[] BIT = new int[max + 1 ];

        for (int i = 0; i < a.length; i++) {
            count += (getSum(BIT, BIT.length-1) - getSum(BIT, a[i]));
            update(BIT, a[i], 1);
        }
        System.out.println(Arrays.toString(BIT));
        return count;
    }


    public static  void convert(int a[]){
        int n=a.length;
        int temp[]= Arrays.copyOf(a,n);
        Arrays.sort(temp);
        for (int i = 0; i < n; i++) {
            a[i]=lowerBound(a[i],temp,0,n)+1;
        }
        System.out.println("Converted Array");
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


    public static int getSum(int BIT[],int i){
        int sum=0;
        int BITIndex=i;
        while(BITIndex>0){

            sum+=BIT[BITIndex];

            BITIndex-=BITIndex & (-BITIndex);
        }
        return sum;
    }

    public static void update(int BIT[],int i,int value){
        int BITIndex=i;

        while(BITIndex<BIT.length){
            BIT[BITIndex]=BIT[BITIndex]+value;
            BITIndex+=BITIndex & (-BITIndex);
        }
    }

    static int getMAX(int a[]) {
        int m = Integer.MIN_VALUE;

        for (int value : a) {
            if (m < value) {
                m = value;
            }
        }

        return m;
    }
}
