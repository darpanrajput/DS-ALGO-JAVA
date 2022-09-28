[Leetcode](https://leetcode.com/problems/find-the-duplicate-number/)<br/>
[GFG](https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/)

## Find Duplicates Array
Given an array of integers nums containing` n + 1` integers where each integer is in the range
`[1, n]` inclusive. There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant 
extra space.
```
Example 1:
Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
```

```java
import java.util.*;

public class FindDuplicatesInArray {
    public static void main(String[] args) {
        int[] numRay = {0, 4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findDuplicates(new int[]{3, 1, 3, 4, 2}));
        System.out.println(getDuplicatesWithoutExtraSpace(new int[]{1, 3, 4, 2, 2}));
        System.out.println(getDuplicatesWithoutExtraSpace(new int[]{3, 1, 3, 4, 2}));
        System.out.println(duplicatesUsingMap(numRay, numRay.length));

    }

    public static ArrayList<Integer> duplicatesUsingMap(int[] arr, int n) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> answer = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                answer.add(entry.getKey());
            }
        }
        ArrayList<Integer> notFound = new ArrayList<>();
        notFound.add(-1);
        return answer.size() >= 1 ? answer : notFound;
    }

    public static int findDuplicates(int[] a) {
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

    public static int getDuplicatesWithoutExtraSpace(int[] a) {
        //since the whole array size is limited to n+1 element with [1,n] inclusive elements
        //we can actually put and traverse the array and put the negative value at each array
        //since it is a natural order we can eventually come at a point we find am negative element
        //which states that this element has already been visited before.
        /*Link->https://practice.geeksforgeeks.org/problems/find-duplicates-in-an-array/1*/
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


}
```

#### output
```text
2
3
2
3
[2, 3]
```