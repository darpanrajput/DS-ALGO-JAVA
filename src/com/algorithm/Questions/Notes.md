# Method without extra space
public static  int `getDuplicatesWithoutSpace(int[] a)`
since the whole array size is limited to n+1 element with [1,n] inclusive elements
we can actually put and traverse the array and put the negative value at each array
since it is a natural order we can eventually come at a point we find am negative element
which states that this element has already been visited before.
[Link](https://practice.geeksforgeeks.org/problems/find-duplicates-in-an-array/1)
```java


public class FindDuplicatesInArray {
    public static void main(String[] args) {
        int[] numRay = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findDuplicates(new int[]{3, 1, 3, 4, 2}));
        System.out.println(getDuplicatesWithoutSpace(new int[]{1, 3, 4, 2, 2}));
        System.out.println(getDuplicatesWithoutSpace(new int[]{3, 1, 3, 4, 2}));
        System.out.println(getDuplicatesWithoutSpace(numRay));
    }


    public static int getDuplicatesWithoutSpace(int[] a) {
        //since the whole array size is limited to n+1 element with [1,n] inclusive elements
        //we can actually put and traverse the array and put the negative value at each array
        //since it is a natural order we can eventually come at a point we find am negative element
        //which states that this element has already been visited before.

        int[] res = new int[a.length + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int index = Math.abs(a[i]) - 1;
            if (a[index] < 0) {
                res[i] = Math.abs(a[i]);
                list.add(Math.abs(a[i]));
//                return Math.abs(a[i]);
            } else {
                a[index] = -a[index];
            }

            System.out.println("REs " + Arrays.toString(res));
        }
        return 0;
    }
}

```

[CODE](FindDuplicate/FindDuplicatesInArray.java)