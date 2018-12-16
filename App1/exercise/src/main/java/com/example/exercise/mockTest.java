package com.example.exercise;

import java.util.ArrayList;

/*  === MOCK TEST QUESTION ===
**ATTENTION** - in the actual exam you will be given the questions on paper.

An incomplete class definition for a Course object is given below.

This object is meant to store information on the names of students taking a particular course in a school.
TestCourse.java is provided for you to test your code. You no need to

(a)	The "students" instance variable is an ArrayList that stores student names as strings. When the constructor is called, "students" should be instantiated and the "numberOfStudents" variable should be initialized to zero.
(b)	Add the getter methods for all the instance variables.
(c)	Complete addStudent(). A student name as a string is passed to it and this method adds it to the end of the "students" ArrayList. You are reminded that "numberOfStudents" should be incremented.
(d)	Complete dropStudent(). A student name as a string is passed to it and this method removes this particular student name from the "students" ArrayList.

*/

public class mockTest {

    private String courseName;
    private int numberOfStudents;
    private ArrayList<String> students;

    public mockTest(String courseName){
        this.courseName = courseName;
        this.numberOfStudents = 0;
        students = new ArrayList<>();

    }


    public String getCourseName() {
        return courseName;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public ArrayList<String> getStudents() {
        return students;
    }

    public void addStudent(String student){
        numberOfStudents ++;

        students.add(student);

    }

    public void dropStudent(String student){
        numberOfStudents --;
        students.remove(student);
    }

}

