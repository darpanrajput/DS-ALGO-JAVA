# Merge Intervals
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

```java
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] interval =new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] interval2 =new int[][]{{1,4},{4,5}};
        for (int[] arr :   merge(interval)) {
            System.out.println(Arrays.toString(arr));
        }
        for (int[] arr :   merge(interval2)) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int[][] merge(int [][]intervals){
        LinkedList<int[]>merged=new LinkedList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        //n(log(n))

        for(int [] interval:intervals){
            //o(n)
            if (merged.isEmpty() || merged.getLast()[1]<interval[0]){
                merged.add(interval);

            }else{
                merged.getLast()[1]= Math.max(
                        merged.getLast()[1],
                        interval[1]
                );
            }
        }

        //n(log(n))+o(n)=>n(log(n)+1)=>nlog(n)
        return merged.toArray(new int[merged.size()][]);
    }
}

```