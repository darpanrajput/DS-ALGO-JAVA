package com.algorithm.Questions;

import java.util.*;
//https://leetcode.com/problems/reduce-array-size-to-the-half/submissions/
/*
* You are given an integer array arr. You can choose a set of integers and remove all
* the occurrences of these integers in the array.

Return the minimum size of the set so that at least half of the integers of the array are removed.

Example 1:

Input: arr = [3,3,3,3,5,5,5,2,2,7]
Output: 2
Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e. equal to half of the size of the old array).
Possible sets of size 2 are {3,5},{3,2},{5,2}.
Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has a size greater than half of the size of the old array.
Example 2:

Input: arr = [7,7,7,7,7,7]
Output: 1
Explanation: The only possible set you can choose is {7}. This will make the new array empty.
*
* */
public class ReduceArraySizeofTheHalf {
    public static void main(String[] args) {
        System.out.println(remove(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7}));
        System.out.println(remove(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

    public static int remove(int[] array) {
        int res = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int el : array) {
            if (map.containsKey(el)) {
                map.put(el, map.get(el) + 1);
            } else {
                map.put(el, 1);
            }

        }
        /*Map doesn't allow duplicate keys, but it allows duplicate values. HashMap and LinkedHashMap
        allows null keys and null values but TreeMap doesn't allow any null key or value.
         Map can't be traversed, so you need to convert it into Set using keySet() or entrySet() method*/

        /* SortMapByKeys comp = new SortMapByKeys(map);
        Map<Integer, Integer> sortedMap = new HashMap<>();
        sortedMap.putAll(map);*/

        /*we couldn't use TreeMap because for input {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        the treemap will have all values as 1 for every item of array and duplicates values aren't allowed there
         hence we used list instead*/

      /*  for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
            count++;
            res = res + entry.getValue();
            if (res >= array.length / 2) {
                return count;
            }
            return count;
        }*/

        List<Integer> sortedList = new ArrayList<>(map.values());
        Collections.sort(sortedList, Collections.reverseOrder());
        for (int val : sortedList) {
            System.out.print(val+",");
            count++;
            res = res + val;
            if (res >= array.length / 2) {
                return count;
            }


        }


        return count;
    }

    public static class SortMapByKeys implements Comparator<Object> {
        Map<Integer, Integer> map;

        SortMapByKeys(Map<Integer, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(Object o1, Object o2) {
            return ((Integer) map.get(o2)).compareTo((Integer) map.get(o1));//decreasing order of keys
        }
    }
}
