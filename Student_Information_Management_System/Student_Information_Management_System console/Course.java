package sims;

public class Course {
    int courseId;
    String courseNumber;
    int marks;

    public Course(int id, String number) {
        this.courseId = id;
        this.courseNumber = number;
    }

    public void addCourse() {
        System.out.println("Course Added: " + courseNumber);
    }

    public void viewCourse() {
        System.out.println("Course: " + courseNumber);
    }
}