package com.algorithm.Questions.FindDuplicate;
/*LINK->https://leetcode.com/problems/find-the-duplicate-number/
LINK->https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3*/

import java.util.*;
public class FindDuplicatesInArray {
    public static void main(String[] args) {
        int[] numRay = {0,4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findDuplicates(new int[]{3, 1, 3, 4, 2}));
        System.out.println(getDuplicatesWithoutSpace(new int[]{1, 3, 4, 2, 2}));
        System.out.println(getDuplicatesWithoutSpace(new int[]{3, 1, 3, 4, 2}));
        System.out.println(duplicatesUsingMap(numRay,numRay.length));

    }

    public static ArrayList<Integer> duplicatesUsingMap(int arr[], int n) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        ArrayList<Integer> answer = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > 1){
                answer.add(entry.getKey());
            }
        }
        ArrayList<Integer> notFound = new ArrayList<>();
        notFound.add(-1);
        return answer.size() >= 1 ? answer : notFound;
    }
    public static int findDuplicates(int[] a) {
        //will only work if array starts from [1,n] of n+1 size
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int j : a) {
            if (set.size() > 0 && set.contains(j)) {
                res = j;
                return res;
            } else {
                set.add(j);
            }
        }

        return res;
    }

    public static int getDuplicatesWithoutSpace(int[] a) {
        //since the whole array size is limited to n+1 element with [1,n] inclusive elements
        //we can actually put and traverse the array and put the negative value at each array
        //since it is a natural order we can eventually come at a point we find am negative element
        //which states that this element has already been visited before.

        /*Link->https://practice.geeksforgeeks.org/problems/find-duplicates-in-an-array/1*/
        for (int i = 0; i < a.length; i++) {
            int index = Math.abs(a[i]) - 1;
            if (a[index] < 0) {
                return Math.abs(a[i]);
            } else {
                a[index] = -a[index];
            }
        }
        return -1;
    }


}

/*
* 0->
	0%9=0
	0/9=0
	a[0]=a[0]=0+(9)=9
1->
	4%9=4
	a[4]=a[4]+7=7+9=16
2->
	3%9=3
	a[3]=[3]+9=2+9=11
3->
	2%9=2
	a[2]=a[2]+9=3+9=12
4->
	7%9=7
	a[7]=a[7]+9=3+9=12
5->
	8%9=8
	a[8]=a[8]+9=1+9=10
6->
	2%9=2
	a[2]=a[2]+9=9+3=12
7->
	3%9=3
	a[3]=a[3]+9=2+9=11
8->
	1%9=1
	a[1]=a[1]+9=4+9=13

 0 1  2  3  4  5  6  7  8
[9,13,12,11,16,00,00,12,10]
*/
