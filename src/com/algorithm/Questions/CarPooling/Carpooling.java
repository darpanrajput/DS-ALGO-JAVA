package com.algorithm.Questions.CarPooling;

import java.util.Arrays;
//https://leetcode.com/problems/car-pooling/submissions/
//video-->https://www.youtube.com/watch?v=oNRr1WjJgw4
public class Carpooling {
    public static void main(String[] args) {
        int i,j;
        System.out.println(carPooling_N(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4));//false
        System.out.println(carPoolingNlogN(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5));//true
        System.out.println(carPoolingNlogN(new int[][]{{4, 5, 6}, {6, 4, 7}, {5, 3, 4}, {2, 3, 5}}, 13));//true
        System.out.println(carPoolingNlogN(new int[][]{{4, 5, 6}, {6, 4, 7}, {4, 3, 5}, {2, 3, 5}}, 13));//true
        System.out.println(carPooling_N(new int[][]{{3, 0, 7}, {1, 4, 7}, {4, 7, 10}}, 5));//true
    }

    public static boolean carPoolingNlogN(int[][] trips, int capacity) {
        int n = trips.length;
        int[][] transformedTrips = new int[2 * n][3];
        int i = 0;
        for (int[] trip : trips) {
            transformedTrips[i][0] = trip[1];//from
            transformedTrips[i][1] = 1;//flag entry
            transformedTrips[i][2] = trip[0];//passenger count

            transformedTrips[i + 1][0] = trip[2];//to
            transformedTrips[i + 1][1] = 0;//flag exit
            transformedTrips[i + 1][2] = trip[0];//passenger count
            // System.out.println(Arrays.deepToString(transformedTrips));
            i += 2;//because each array row is filled twice ->>it avoid to override rows after i increases
        }
 //       System.out.println(Arrays.deepToString(transformedTrips));
//        Arrays.sort(transformedTrips,Comparator.comparingInt(a->a[0]));
        Arrays.sort(transformedTrips, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });
        System.out.println(Arrays.deepToString(transformedTrips));
        int curr = 0;
        for (int[] trip : transformedTrips) {
            if (trip[1] == 1) curr += trip[2];
            else if (trip[1] == 0) curr -= trip[2];
            System.out.println(curr);
            if (capacity < curr) return false;

        }
        return true;

    }

    public static boolean carPooling_N(int[][] trips, int capacity) {
        // the array of size can be maximum upto 1000,
        // but we can also consider the max elem in given array
        // ,and we can create the array of size max+1
        int n = 0;

        for (int x[] : trips) {
            n = Math.max(n, x[2]);
        }
        int km[] = new int[n + 1];
        for (int trip[] : trips) {
            km[trip[1]] += trip[0];
            km[trip[2]] -= trip[0];
        }
        for (int x : km) {
            capacity -= x;
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }

}
