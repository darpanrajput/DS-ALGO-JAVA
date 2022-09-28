package com.algorithm.io;

import java.io.BufferedReader;

import java.io.FileReader;


public class ReadingFile {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String Line;
            while ((Line = reader.readLine()) != null) {
                System.out.println(Line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
