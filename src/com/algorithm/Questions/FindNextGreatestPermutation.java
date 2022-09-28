package com.algorithm.Questions;

import java.util.Arrays;

public class FindNextGreatestPermutation {

    public static void main(String[] args) {
        int[]a=new int[]{1,2,3,2,3};
        int[]b=new int[]{1,2,3,4,3,2,3,4,2};
        int[]c=new int[]{1,2,3,5,4,2};

        nextHighestPermutation(a);
        nextHighestPermutation(b);
        nextHighestPermutation(c);
    }

    static void nextHighestPermutation(int[] a){
        int n=a.length;
        int i=1;
        int peakIndex=-1;
        if(n==1) return ;

        while (i<n){
            if(a[i]>a[i-1]){
                peakIndex=i;
            }
            i++;
        }

        System.out.println("PeakIndex="+peakIndex);

        if (peakIndex==1){
            /*if peak is -1 that means the array is
            in descending order hence we need to arrange them in simply
            ascending order for that we run a loop for only n/2 times
            and then simply swap Kth element with n-1-k
            n-1=> for getting the last index and n-1-k for
            getting the index to bew swapped with
            */
            for (int j = 0; j < n / 2; j++) {
                swap(j,n-1-j,a);

            }

            return;

        }

        /*This the case when the immediate right of the peak can either be
        1) higher than its immediate left
        2) lower than its immediate left*/

        int index=peakIndex;

        for (int j = peakIndex; j < n; j++) {
            if (a[peakIndex-1]<a[j] && a[j]<a[index]){

                index=j;
            }
        }
        swap(index,peakIndex-1,a);
        System.out.println("After Swap with peak index="+Arrays.toString(a));
        Arrays.sort(a,peakIndex,n);
        System.out.println(Arrays.toString(a));
    }


    public static void swap(int i,int j,int[]arr){

        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
