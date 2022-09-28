package com.algorithm.sorting.comparableAndComparators;

public class Student implements Comparable<Student>{
    long marks;
    String name;
    public Student(){

    }

    public Student(long marks,String name){
        this.marks=marks;
        this.name=name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public long getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public int compareTo(Student o) {
        if(this.name.equals(o.name)) return (int) (o.marks-this.marks);//Descending order of marks
       else return (int) (this.marks-o.marks);//Ascending order of marks

       /* if (this.marks>o.marks) return 1; //Ascending order of marks
        else if(this.marks<o.marks) return -1;//Ascending order of marks
        return this.name.compareTo(o.name);//if name same then sort according to the name*/
    }
}
