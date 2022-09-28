# Converting a Higher Indexed array to lower Index without reducing its weightage

when we try to convert this array into it's equivalent indexes
 we might end up creating 14123 items in memory if we take size as `new int[14113]`
<table>
<tr>
<td>121</td>
<td>23</td>
<td>41</td>
<td>14123</td>
<td>42</td>
<td>1</td>
<td>3</td>
<td>2</td>
</tr>
</table>
but the above array can be converted to new array which holds the different value
but holds the same weightage as above.the sizes reduces to n=7-1
<table>
<tr>
<td>7</td>
<td>4</td>
<td>5</td>
<td>8</td>
<td>6</td>
<td>1</td>
<td>3</td>
<td>2</td>
</tr>
</table>

Algorithm
1. find the array element one by one using divide conquer technique.
  ``` js
private static int lowerBound(int ele, int[] temp, int low, int high) {
   int mid=0;
   while(low<high){
   mid=low+(high-low)/2;
   if(ele==temp[mid]){
   return mid;
   }else if(ele>temp[mid]){
   low=mid+1;
   }else{
   high=mid;
   }
   }
   return mid;
   }
   }
 ```


