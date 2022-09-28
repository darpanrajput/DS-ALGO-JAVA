# [Minimum Platform](https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1)
Given arrival and departure times of all trains that reach a railway station.
Find the minimum number of platforms required for the railway station so that no train is kept waiting.
Consider that all the trains arrive at the same day and leave on the same day. 
Arrival and departure time can never be the same for a train, but we can have arrival 
time of one train equal to departure time of the other. At any given instance of time, 
same platform can not be used for both departure of a train and arrival of another train. 
In such cases, we need different platforms.
[Video](https://www.youtube.com/watch?v=38JLfQGVlkw&t=297s)

Example 1
```js
Input: n = 6
arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
Output: 3
Explanation:
Minimum 3 platforms are required to
safely arrive and depart all trains.

```

Example 2
```js
Input: n = 3
arr[] = {0900, 1100, 1235}
dep[] = {1000, 1200, 1240}
Output: 1
Explanation: Only 1 platform is required to 
safely manage the arrival and departure 
of all trains. 

```
## approach
1. sort the arrival and departure time in ascending order
2. we need 2 variable , platform =1 and res=1 because no matter what we would
at least need 1 platform

`i` is the arrival pointer and j is the departure pointer. Whenever departure time is higher than
the arrival time we need another platform hence `platform++;` and compare is
`if(res<platform) res= platform` because res is the result that needs to be returned also
at this point `arr[i]>dep[j]`- arrival time will be lower than departure time we need to do i++;


if the train leaves before the arrival of any other train i.e. when arrival time is higher
that the departure time we need to decrement the needed platform as there is no need
to have a new platform again . we can utilise the same platform instead and also since
`jth`-which is departure is lower than arrival time we have increment j.

Iteration stops whenever we reached the condition `while(i<n and j<n)` where either of the
pointer exceeds n.

```
 static int findPlatform(int arr[], int dep[], int n)
    {   // add your code here
        // add your code here

        Arrays.sort(arr);
        Arrays.sort(dep);

        int platformNeeded=1;
        int res=1;
        int i=1; int j=0;
        while(i<n && j<n){

            if(arr[i]<=dep[j]){

                platformNeeded++;
                i++;

                if(platformNeeded>res) res=platformNeeded;

            }else{
                platformNeeded--;
                j++;
            }
        }
        return res;

    }

```
