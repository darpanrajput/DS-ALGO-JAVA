package com.algorithm.io;

import java.io.BufferedWriter;
import java.io.FileWriter;


public class WritingFile {
    public static void main(String[] args) {
        BufferedWriter writer = null;
        String lines = "\n3 5 7 8";
        try {
            writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write(Integer.toString(4));
            writer.write(lines);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
