package com.algorithm.io;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.InputStreamReader;


public class ReadingFile {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("input.txt");
            /*
            if you read from user use  InputStreamReader r=new InputStreamReader(System.in);
            then use  BufferedReader br=new BufferedReader(r);
                        System.out.println("Enter your name");
                        String name=br.readLine();
                        System.out.println("Welcome "+name);
            */
            BufferedReader reader = new BufferedReader(fileReader);
            String Line;
            while ((Line = reader.readLine()) != null) {
                System.out.println(Line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void ReadFromConsole() {
        try {
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
            String name = "";
            while (!name.equals("stop")) {
                System.out.println("Enter data: ");
                name = br.readLine();
                System.out.println("data is: " + name);
            }
            br.close();
            r.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void BufferedReaderExample() {
        try {
            FileReader fr = new FileReader("D:\\textOutput.txt");
            BufferedReader br = new BufferedReader(fr);

            int i;
            while ((i = br.read()) != -1) {
                System.out.print((char) i);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
