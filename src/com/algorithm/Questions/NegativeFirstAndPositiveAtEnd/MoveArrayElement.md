### Move all Negative Elements of an array at start and all positive at the end
we just need to get a hold if positive element location
and swap it with the negative element. positive pointer will be slower
than the iterator `i` hence the location to the positive element will be 
always behind the `i` and then we can swap the location to bring the negative
element at the start. for the we first need to compare the if our element 
is negative or not if it is negative that means we can swap it to bring it to start.

```java
public class MoveArrayElements {
    public static void main(String[] args) {
        Segregate(new int[]{1,2,3,-1,-4,8,9,-6},8);
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
}

```
#### output
```text
[-1, -4, -6, 1, 2, 8, 9, 3]
Time Complexity: O(n*log(n)), Where n is the length of the given array.
Auxiliary Space: O(n)
```
