package com.algorithm.Questions.CounteInversion;

import java.util.Arrays;

public class CountInvUsingBITForLowerIndexes {
    //count inversion using BIT for lower indexes upto 10^5
    //because the array element will be converted to index of our BIT
    public static void main(String[] args) {
        int[] a = new int[]{8, 4, 9, 2};

        System.out.println(countInversion(a));
        System.out.println(getMAX(a));
        int []arr = {8, 4, 2, 1};
        int n = arr.length;
        System.out.println(countInversion(arr));
    }

    static int countInversion(int[] a) {
        int count = 0;
        int max = getMAX(a);
        int[] BIT = new int[max + 1 ];

        for (int i = 0; i < a.length; i++) {
            count += (getSum(BIT, BIT.length-1) - getSum(BIT, a[i]));
            update(BIT, a[i], 1, BIT.length);
        }
        System.out.println(Arrays.toString(BIT));
        return count;
    }

    static int getSum(int BIT[], int i) {
        int BITIndex = i ;
        int sum = 0;

        while (BITIndex > 0) {
            sum += BIT[BITIndex];
            BITIndex = BITIndex - (BITIndex & (-BITIndex));
        }

        String s = "sum upto " + BITIndex + "th index in" + Arrays.toString(BIT) + " is=" + sum + " i=" + i;
        System.out.println(s);
        return sum;
    }

    static void update(int[] BIT, int index, int value, int arraySize) {
        int BIndex = index ;
        while (BIndex <arraySize) {
            BIT[BIndex] += value;

            BIndex = BIndex + (BIndex & (-BIndex));
        }

        String s = "Value to be update is =" + value + " at " + BIndex + " in BIT " + Arrays.toString(BIT);
        System.out.println(s);
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
