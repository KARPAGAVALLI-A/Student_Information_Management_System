package sims;

import java.io.Serializable;
import java.util.*;

public class Student implements Serializable {
    int studentId;
    String studentName;
    String department;

    List<Course> courses = new ArrayList<>();
    Marks marks = new Marks();
    Attendance attendance = new Attendance();
    Fee fee = new Fee();
    Result result = new Result();

    public Student(int id, String name, String dept) {
        this.studentId = id;
        this.studentName = name;
        this.department = dept;
    }

    public void display() {
        System.out.println("\nID: " + studentId);
        System.out.println("Name: " + studentName);
        System.out.println("Dept: " + department);

        marks.displayMarks();

        for (Course c : courses) {
            c.viewCourse();
        }

        attendance.display();
        fee.display();

        result.generateResult(marks);
        result.display();
    }
}