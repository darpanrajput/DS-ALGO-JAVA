package com.algorithm.sorting.comparableAndComparators;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.*;


public class MainSortingClass {
    public static void main(String[] args) throws IOException {
        List<Student> students = new ArrayList<>();

        String path = System.getProperty("user.dir") +
                "\\src\\com\\algorithm\\sorting\\comparableAndComparators\\Data.json";
        System.out.println("Working Directory Path= " + path);

        JSONParser parser = new JSONParser();
        try {
            JSONArray obj = (JSONArray) parser.parse(new FileReader(path));
//            System.out.println(obj);

            for (Object a : obj) {
                JSONObject student = (JSONObject) a;

                String name = (String) student.get("name");
                long marks = (long) student.get("marks");
                Student s = new Student(marks, name);
                students.add(s);

            }

           /* Collections.sort(students);*///sort by using comparable
            /*Collections.sort(students,new SortByNameThenMarks());*///sort by using comparator and compare method
            /*Collections.sort(students,Collections.reverseOrder())*/;///Reverse Order sorting

           /* students.sort(new Comparator<Student>() {
           //sorting using Anonymous class
                @Override
                public int compare(Student o1, Student o2) {
                    if (o1.name.equals(o2.getName())) return (int) (o2.marks - o1.marks);
                    else return (int) (o1.marks - o2.marks);
                }
            });*/


            /*Lambda Expression comparator sorting*/
            students.sort((o1, o2) -> {
                if (o1.name.equals(o2.getName())) return (int) (o2.marks - o1.marks);
                else return (int) (o1.marks - o2.marks);
            });
            /*Lambda Expression comparator sorting based on only name*/
           /* students.sort((s1,s2)-> s1.compareTo(s2));*/
            students.sort(Student::compareTo);




            for (Student s : students) {
                System.out.println("[name:" + s.name + ",Marks:" + s.marks + "]");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SortByNameThenMarks implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            if (o1.name.equals(o2.getName())) return (int) (o2.marks - o1.marks);
            else return (int) (o1.marks - o2.marks);

        }
    }
}
