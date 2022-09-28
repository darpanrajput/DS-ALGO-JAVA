package com.algorithm.ReverseStringArray;

public class ReverseArrayString {

    public static void main(String[] args) {

    }

    public static String reverseWord(String str)
    {
        // Reverse the string str

        int start=0;
        int end=str.length()-1;
        char c[]=str.toCharArray();
        while(start<end){

            char temp=c[end];
            c[end]=c[start];
            c[start]=temp;
            start++;
            end++;
        }

        StringBuilder s= new StringBuilder();
        for(char ch:c){
            s.append(ch);
        }
        return s.toString();
    }
}
