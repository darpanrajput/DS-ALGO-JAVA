package com.algorithm.Questions.CounteInversion;
//https://leetcode.com/problems/global-and-local-inversions/submissions/
public class GlobalAndLocalInversion {
    public static void main(String[] args) {
      int arr1[]=new int[]{ 1,2,0};
      int arr2[]=new int[]{1,0,2};
        System.out.println("**********Method One O(n)Time fastest**********");
        System.out.println(checkIfLocalAndGlobalInversionAreSame(arr1));
        System.out.println(checkIfLocalAndGlobalInversionAreSame(arr2));
        System.out.println("**********SECOND METHOD WITH O(N)TIME************");
        System.out.println(checkLocalAndGlobalInversionAreSame(arr1));
        System.out.println(checkLocalAndGlobalInversionAreSame(arr2));

        System.out.println("**********THIRD METHOD WITH O(N) SQUARE TIME************");
        System.out.println(Bruteforce(arr1));
        System.out.println(Bruteforce(arr2));

        System.out.println("**********FOURTH METHOD WITH O(NlogN) TIME WITH THE HELP OF MERGE SORT************");
        System.out.println(MergeSortCountInversionNlogNTime.DriverMethod(arr1,0,arr1.length-1));
        System.out.println(MergeSortCountInversionNlogNTime.DriverMethod(arr2,0,arr2.length-1));
    }



//    Method One O(n)Time fastest
    public static boolean checkIfLocalAndGlobalInversionAreSame(int[]a){
        int max=0;
        for (int i = 0; i < a.length-2; i++) {
            max=Math.max(max,a[i]);

            if (max>a[i+2]) return false;//global inversion found


        }
        return true;
    }

    //SECOND METHOD WITH O(N)TIME
    public static boolean checkLocalAndGlobalInversionAreSame(int[]a){
        for (int i = 0; i < a.length; i++) {
            if (Math.abs(a[i]-i)>1) return false;//global inversion found
        }
        return true;
    }

    //THIRD METHOD WITH O(N*2)SQUARE TIME BRUTE FORCE
    public static boolean Bruteforce(int[]a){
        int GlobalInversion=0;
        int LocalInversion=0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length-1; j++) {
                if(a[i]>=a[j]) GlobalInversion++;
            }
        }
        for (int i = 0; i < a.length-1; i++) {
            if(a[i]>=a[i+1]) LocalInversion++;

        }
        System.out.println("L="+LocalInversion+" G= "+GlobalInversion);

        return GlobalInversion==LocalInversion;
    }

    //FOURTH METHOD WITH O(NlogN) TIME WITH THE HELP OF MERGE SORT
    static class MergeSortCountInversionNlogNTime{


        public static boolean DriverMethod(int[]a,int l,int r){
            int LocalInversion=0;
            for (int i = 0; i < a.length-1; i++) {
                if(a[i]>=a[i+1]) LocalInversion++;

            }
            return Divide(a,l,r)==LocalInversion;
        }
        private static int Divide(int[] a, int l, int r){
            int inversion=0;
            if(l<r){
                int m=l+(r-l)/2;
                inversion+=Divide(a,l,m);
                inversion+=Divide(a,m+1,r);
                inversion+=Conquer(a,l,m,r);
            }


            return inversion;
        }

        private static int Conquer(int[] a, int l,int m, int r){

            int si=l,ei=m+1,k=0,inversion=0;
            int[]b=new int[(r-l)+1];
            while(si<=m && ei<=r){
                if(a[si]<=a[ei]){
                    b[k++]=a[si++];
                }else {
                    inversion+=inversion+(m-si)+1;
                    b[k++]=a[ei++];
                }
            }

            while(si<=m){
                b[k++]=a[si++];
            }

            while (ei<=r){
                b[k++]=a[ei++];
            }

            for(int i=0,j=l;i<b.length;i++,j++){
                a[j]=b[i];
            }
            return inversion;
        }
    }
}
