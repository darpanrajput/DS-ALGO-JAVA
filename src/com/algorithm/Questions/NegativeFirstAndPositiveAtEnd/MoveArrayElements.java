package com.algorithm.Questions.NegativeFirstAndPositiveAtEnd;

import java.util.Arrays;

public class MoveArrayElements {
    public static void main(String[] args) {
        Segregate(new int[]{1,2,3,-1,-4,8,9,-6},8);
        Segregate(new int[]{-1, 2, -3, 4, 5, 6, -7, 8, 9},9);
        twoPinterAlgorithm(new int[]{1,2,3,-1,-4,8,9,-6},0,7);
        twoPinterAlgorithm(new int[]{-1, 2, -3, 4, 5, 6, -7, 8, 9},0,8);
    }

    public static void Segregate(int []a, int size){
        int positiveElementLoc=0;
        for (int i = 0; i < size; i++) {
            if(a[i]<0){
                int temp=a[i];
               a[i]=a[positiveElementLoc];
               a[positiveElementLoc]=temp;
               positiveElementLoc++;
            }
        }
        System.out.println(Arrays.toString(a));
    }



    // Function to shift all the
// negative elements on left side
    static void twoPinterAlgorithm(int[] arr, int left, int right)
    {

        // Loop to iterate over the
        // array from left to the right
        while (left <= right)
        {

            // Condition to check if the left
            // and the right elements are
            // negative
            if (arr[left] < 0 && arr[right] < 0)
                left++;

                // Condition to check if the left
                // pointer element is positive and
                // the right pointer element is negative
            else if (arr[left] > 0 && arr[right] < 0)
            {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }

            // Condition to check if both the
            // elements are positive
            else if (arr[left] > 0 && arr[right] > 0)
                right--;
            else
            {
                left++;
                right--;
            }
        }

        System.out.println(Arrays.toString(arr));

    }
}
