package sims;

import java.io.Serializable;

public class Course implements Serializable {
    int courseId;
    String courseName;

    public Course(int id, String name) {
        this.courseId = id;
        this.courseName = name;
    }

    public void viewCourse() {
        System.out.println("Course: " + courseName);
    }
}