package com.algorithm.Questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given 2 arrays create a function that let user know (true/false)
        whether these arrays have any common items?
        Example 1:
        const a=[a,b,c,x];
        const b=[z,y,i]
        should return false

        Example:2
        const a=[a,b,c,x];
        const b=[z,y,x]
        should return true
  */
public class CheckCommonItemsInTwoArrays {
    public static void main(String[] args) {
        char[] a=new char[]{'a','b','c','x'};
        char[] b=new char[]{'z','y','i'};
        char[] c=new char[]{'a','b','c','x'};
        char[] d=new char[]{'z','y','x'};
        System.out.println("***************************** bruteForce *******************************************");
        System.out.println(bruteForce(a,b));
        System.out.println(bruteForce(c,d));
        System.out.println("***************************** Using Map *******************************************");
        System.out.println(isContainCommonItem(a,b));
        System.out.println(isContainCommonItem(c,d));

        System.out.println("***************************** Using sets *******************************************");
        System.out.println(isContainCommonItemUsingSet(a,b));
        System.out.println(isContainCommonItemUsingSet(c,d));
    }

    public static boolean bruteForce(char[] arr1, char[] arr2){

        for (char VALUE : arr1) {
//            System.out.print(VALUE+":");
            for (char value : arr2) {
//                System.out.print(value);
                if(VALUE == value){
                    return true;
                }

            }
        }
        return false;
    }

    /*****************************Using Map*******************************************/
    public static boolean isContainCommonItem(char[]arr1,char[]arr2){
        Map<Character,Boolean>map=new HashMap<Character,Boolean>();

        for (char ele : arr1) {
            map.put(ele,true);
        }

        for (char item:arr2) {
            if (map.get(item)!=null && map.get(item)) {
                return true;
            }
        }

        return false;

    }


    /*****************************Using Set*******************************************/
    public static boolean isContainCommonItemUsingSet(char[]arr1,char[]arr2){
        Set<Character>set=new HashSet<>();
        for (char ele: arr1) {
            set.add(ele);
        }

        for (char item :arr2) {
            if (!set.isEmpty() && set.contains(item)) {
                return true;
            }
        }
        return false;
    }

}
