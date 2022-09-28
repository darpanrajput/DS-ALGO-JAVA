package com.algorithm.Questions;

public class MultiplyTwoString {
    public static void main(String[] args) {
        System.out.println(mul("123","456"));
        System.out.println(mul("7","29"));
        System.out.println(mul("4416","-333"));
        System.out.println(mul("-89382","-207"));
    }

    public static String mul(String numb1,String numb2){
        if(numb1.equals("0") ||numb2.equals("0")) return "0" ;
        String negSign="";
        if(numb1.charAt(0)=='-'||numb2.charAt(0)=='-'){
            negSign="-";
        }

        if(numb1.charAt(0)=='-'&& numb2.charAt(0)=='-'){
            negSign="";
        }
        if(numb1.charAt(0)=='-'){
            numb1=numb1.replace("-","");
        }
        if(numb2.charAt(0)=='-'){
            numb2=numb2.replace("-","");
        }
        if (numb1.length()<numb2.length()){
            String temp=numb2;
            numb2=numb1;
            numb1=temp;
          //  System.out.println(numb1+" "+numb2);
        }
        int i;
        int j=numb2.length()-1;
        int[] ans =new int[numb1.length()+numb2.length()];
        int PF=0;// a counter to keep track of my indexes in res array so that i could add
        // the current result to the correct result in result array.keep track of outer while loop
        while (j>=0){
            /* will now traverse all the number of numb1 for every numb2 jth element*/

            int jVal=numb2.charAt(j)-'0';
           // System.out.println("javl="+jVal);
            j--;
            int carry=0;
            int k=ans.length-1-PF;//determine the correct place in ans array
            i=numb1.length()-1;// resetting i to the last value or s1;
            while (carry!=0 || i>=0 ){
                //carry is !=0 because there might some carry at the last digit that we need to aad
                int iVal=i>=0?numb1.charAt(i)-'0':0;
               // System.out.println("      iVal="+iVal);
                int prod=(jVal*iVal)+carry+ans[k];
                carry=prod/10;
                ans[k]=prod % 10;
                i--;
                k--;
            }
            PF++;

        }

        StringBuilder res= new StringBuilder();
        boolean flag=true;
        for (int val : ans) {
            if(val==0 && flag){
                //this will avoid the leading zeroes in our ans array[00000056088]if any [056088]
                continue;
            }else {
                res.append(val);
                flag=false;
            }
        }

        return negSign+res;
    }
}
