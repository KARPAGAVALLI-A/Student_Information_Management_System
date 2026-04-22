package sims;

import java.util.*;

public class Student {
    int studentId;
    String studentName;
    String department;
    String email;
    String phoneNumber;

    List<Course> courses = new ArrayList<>();
    Attendance attendance = new Attendance();
    Fee fee = new Fee();

    public Student(int id, String name, String dept, String email, String phone) {
        this.studentId = id;
        this.studentName = name;
        this.department = dept;
        this.email = email;
        this.phoneNumber = phone;
    }

    public void addStudent() {
        System.out.println("Student Added: " + studentName);
    }

    public void updateStudent(String name) {
        this.studentName = name;
    }

    public void viewStudent() {
        System.out.println("ID: " + studentId + ", Name: " + studentName);
    }
}