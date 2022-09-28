package com.algorithm.Questions.CounteInversion;

public class CountInversion {
    public static void main(String[] args) {
        int [] arr1=new int[]{2, 4, 1, 3, 5};
        System.out.println(MergeSortCountInversionNlogNTime
                .DriverMethod(arr1,0,arr1.length-1));
        int [] arr2=new int[]{2, 4, 1, 3, 5};
        System.out.println(DriverMethod(arr2));

        int b[] = new int[]{8, 4, 9, 2};

        System.out.println(MergeSortCountInversionNlogNTime
                .DriverMethod(b,0,b.length-1));
    }



    //USING THE TWO FOR LOOP BRUTEFORCE APPROACH N square time
        private static int DriverMethod(int[] a){
         int inversion = 0;
            for (int i = 0; i < a.length; i++) {

                for (int j =i+1; j < a.length-1; j++) {
                    if(a[i]>=a[j]){
                        inversion++;
                    }
                }
            }
            return inversion;
        }



    //Using merge sort algorithm
    static class MergeSortCountInversionNlogNTime{

        public static int DriverMethod(int[]a,int l,int r){
            return Divide(a,l,r);
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
