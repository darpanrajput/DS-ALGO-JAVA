package com.algorithm.Questions.CoinDenomination;

import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/number-of-coins1824/1


public class CoinChangeDenominations {
    public static void main(String[] args) {
        int[] denominations = new int[]{7, 5, 1};//4
        int[] denominations2 = new int[]{25, 10, 5};//2
        int[] denominations3 = new int[]{9, 2, 11, 5, 14, 17, 8, 18};//3
        int value = 18;
        int value2 = 30;
        int value3 = 39;

        System.out.println(getMinCoin(denominations3, value3));
    }

    static int getMinCoin(int[] denominations, int value) {
        int[] table = new int[value + 1];
        Arrays.fill(table, -1);
        table[0] = 0;
        int res = minCoin(value, denominations, table);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    static int minCoin(int value, int[] arr, int[] table) {
        int ans = Integer.MAX_VALUE;
        if (value == 0) return 0;
        for (int item : arr) {
            int subRes;
            if (value - item >= 0) {
                if (table[value - item] != -1) {
                    subRes = table[value - item];
                } else {
                    subRes = minCoin(value - item, arr, table);
                }

                if (subRes != Integer.MAX_VALUE) {// when there is no coin available to accommodate the 1 rs
                    ans = Math.min(subRes + 1, ans);
                }
            }


        }

        return table[value] = ans;


    }
}
