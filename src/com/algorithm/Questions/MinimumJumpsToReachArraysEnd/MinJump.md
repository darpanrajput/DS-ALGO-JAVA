# O(n) Linear Solution

<table>
<tr>
<td>1</td>
<td>3</td>
<td>2</td>
<td>4</td>
<td>5</td>
</tr>
</table>


find Minimum Jumps to Reach end 1of Array Linear Time

Solution.we need to declare three variables
1) maxR = maximum Reachable Distance that justify the atmost steps require to jump = `a[0]`

2) Steps = steps are steps Left to consume Before we can jump
at most jump we can take.steps are the Buffer Steps that we decrease after each step we take .
It defines possible jumps for example if we have 3 jumps (atmost) then Steps-> seen as 1,2,3 jumps
also when steps Become O we jump & Increment jump variable .
4) Jump=jump defines minimum steps that we are require to take. 
when our all Steps finished We con assume that we are required to jump & increment our this jump counter.
at First, we start looping from i=1 to n .we assume that we already took the first jump when we each at oth index
hence `mox R = a[o];` `steps = a[0], jump = 1`
`© i=1, manR = 1, steps = 1, jump = 1 ,`

if( (==n-1) where `n` is the length of array. if we already have reached to the end
, we don't jump again. 
We then check the maxR ,if this the max on the current reachable 
which `index+a[index])`→ this expansion defines How far we can go before we hit the end.
so we need to define maxR as the maximum.

`maxR = max(1, 4) = 4` That means from index `i` we can reach to 4<sup>th</sup> and how many
steps that we have taken to come this far `steps = 1`, Now if we decrement steps By 1 we indicate
that our last steps is Completed & Now the time is to jump,so we did `steps--` & `jump++`
(`only when Steps == 0`) then we also need to define steps again for our,next jump that will be
taking when would consume all steps, so `steps = (manR-i) =(4-1)=3` this defines ->at Index 1<sup>st</sup>.
we have 3 steps either 3, 2,or 1 then check haven't we Reached to the Dead end ?where our 
reachability Becomes more than our current index `(i> = maxR)` indicates that
we con not jump at i to n-1 Because there are not enough jumps available & this due to `a[i]=0` 
eg: `a[1 ,3,2,0,0,4]` is dead end. not enough jumps, if we try to jump from 3 to 0 & 2 to 0