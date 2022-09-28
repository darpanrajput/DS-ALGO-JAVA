package com.algorithm.DS;

import java.util.Arrays;

public class BinaryIndexTree {
    public static void main(String[] args) {
        int[] a = new int[]{3, 2, -1, 6, 5, 4, -3, 3, 7, 2, 3};


        int[] Btree = ConstructBtree(a.length, a);
        System.out.println("*******************The BTree **************************");
        System.out.println(Arrays.toString(Btree));

        System.out.println("*******************The BTree SUM **************************");

        System.out.println(getSum(6, Btree));

        System.out.println("*******************The BTree SUM(l,r) **************************");

        System.out.println(getSum(4,10, Btree));

        System.out.println("*******************The BTree update(l,r) **************************");

        System.out.println(Arrays.deepToString(update(6, 4, Btree, a)));
    }



    static int[][] update(int i,int num,int[]Btree,int[]A){
        int [][]ans=new int[][]{{}};
        int bIndex=i+1;
        int diff=Math.abs(num-A[i]);
         A[i]=num;
         while(bIndex<=A.length){
             Btree[bIndex]+=diff;
             bIndex+=bIndex&(-bIndex);//get the next node to be changed.
         }

         return ans= new int[][]{A, Btree};

    }

    static int getSum(int l,int r, int[] Btree){
        return getSum(r,Btree)-getSum(l-1,Btree);
    }

    static int getSum(int n, int[] Btree) {
        int sum = 0;
        int btreeIndex = n + 1;
        while (btreeIndex > 0) {

            sum = sum + Btree[btreeIndex];

            btreeIndex= btreeIndex - (btreeIndex & (-btreeIndex));//get the parent node
        }
        return sum;
    }

    static int[] ConstructBtree(int n, int a[]) {
        int[] Btree = new int[n + 1];

        for (int i = 0; i < n; i++) {
            /* (O)nlogN because for every element in array we have to log n operation till the next node exceeds the number
             of node available at a particular tree level*/
            int BtreeIndex = i + 1;//BIT index starts from 1;
            while (BtreeIndex <= n) {
                Btree[BtreeIndex] = Btree[BtreeIndex] + a[i];
                BtreeIndex = getNextNode(BtreeIndex);
            }

        }

        return Btree;
    }

    static int getNextNode(int index) {

        /*
         * 1) find the 2s compliment
         * 2) AND with the original Number
         * 3) Add with the original Number
         *
         * */
        return (index + (index & (-index)));
    }
}
