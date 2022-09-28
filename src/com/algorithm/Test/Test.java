package com.algorithm.Test;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.*;
import java.time.*;

public class Test {

/*
import libraries
import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.*;
import java.time.*;

* */
public static void main(String[] args) {
    String s[]=new String[]{"0125","0125","0245"};
    int num= Integer.parseInt(s[0].toCharArray()[0]=='0'?s[0].substring(0):s[0]);
    System.out.println(num);
}

}
