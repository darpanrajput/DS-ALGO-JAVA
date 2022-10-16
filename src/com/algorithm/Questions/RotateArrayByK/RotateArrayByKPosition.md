1.Rotate and Array by Kth Position
[Video](https://www.youtube.com/watch?v=8RErc0VXAo8)
1. `k=0 ,size=5` ,
2. <table><tr><td>a</td><td>b</td><td>c</td><td>d</td><td>e</td></tr></table> no rotations

3. `k=1`, <table><tr><td>e</td><td>b</td><td>c</td><td>d</td><td>a</td></tr></table> for` k=1` `e`
will be shifted to first place.
4. `k=-1`,<table><tr><td>b</td><td>c</td><td>d</td><td>e</td><td>a</td></tr></table> for `k=-1` `e`
   and `a` will be shifted to back.
5. `k=2`,<table><tr><td>`d`</td><td>`e`</td><td>a</td><td>b</td><td>c</td></tr></table> last 2 elements
will be placed at front.
6. `k=3`,<table><tr><td>`c`</td><td>`d`</td><td>`e`</td><td>a</td><td>b</td></tr></table> last 3 elements
   will come at front.(compare only with k=0 array)
7. `k=4`,<table><tr><td>`b`</td><td>`c`</td><td>`d`</td><td>`e`</td><td>a</td></tr></table> last 4 elements
   will come at front.(compare only with k=0 array)
8. `k=5`,<table><tr><td>`a`</td><td>`b`</td><td>`c`</td><td>`d`</td><td>`e`</td></tr></table> last 5 elements
   will come at front.it is not the same array as original i.e. no change. this is point where it will repeat start repeating itself
9. `k=5`, <table><tr><td>`e`</td><td>b</td><td>c</td><td>d</td><td>a</td></tr></table> last 1 elements
   will come at front.like k=1 only one rotation

**conclusion** :
1. if we have k=3 and size=5 and `3 % 5=3` which is` k % arr.legnth` then we will get k number of
rotation, and we take 3 items from last and place them at the first 3 places and rest remains same
2. if k=6 then, `6 % 5=1` only one ration and put the last item at first place.
3. if k=-1 then , `k=K % arr.length ,k=k+arr.length` i.e. `k= -1+5=4`, solve only for k=4.
4. if k=-6 then `k=K%arr.legth ,k=-6+5=>-1` solve only for `k=-1` bring first element to the last [b,c,d,e,a].
5. The `%` will make any number smaller than the size
   and then when we add to the size it will become positive for e.g.
   if `k=-7` then `k=-7%5=-2` and then if it is negative that means
   it has to become positive by `k=-2+5=3` that means rotate only for` k=3` instead of `k=-7`

**Algorithm**
1. first take modulus `k=k%arr.len`
2. if k<0 the k=k+arr.len
3. reverse(arr,from,to) divide array in 2 parts <table><tr><td>`a`</td><td>b</td><td>c</td><td>d</td><td>e</td></tr></table>
   1. part 1 reverse the array from 0 to arr.len-k-1 `reverse(arr,0,1) which means reverse [a,b]`
   2. part 2 reverse the array from arr.len-k-1  to arr.len-1 `reverse(arr,2 ,5) which means reverse[c,d,e]`
   3. now lastly reverse the array from 0 to n-1 `reverse(arr,2 ,5)-->[b,a,e,d,c]--->[c,d,e,a,b]`


##### Another approach, Suppose the give array is arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2.

First Step:
=> Store the elements from 2nd index to the last.
=> temp[] = [3, 4, 5, 6, 7]

Second Step:
=> Now store the first 2 elements into the temp[] array.
=> temp[] = [3, 4, 5, 6, 7, 1, 2]

Third Steps:
=> Copy the elements of the temp[] array into the original array.
=> arr[] = temp[] So arr[] = [3, 4, 5, 6, 7, 1, 2]
