package com.sims.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int studentId;
    private String studentName;
    private String department;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL,
               orphanRemoval = true, fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Course> courses = new ArrayList<>();

    @Embedded
    private Marks marks = new Marks();

    @Embedded
    private Attendance attendance = new Attendance();

    @Embedded
    private Fee fee = new Fee();

    @Embedded
    private Result result = new Result();

    public Student(int studentId, String studentName, String department) {
        this.studentId    = studentId;
        this.studentName  = studentName;
        this.department   = department;
        this.courses      = new ArrayList<>();
        this.marks        = new Marks();
        this.attendance   = new Attendance();
        this.fee          = new Fee();
        this.result       = new Result();
    }

    // original logic
    public void display() {
        System.out.println("\nID: "   + studentId);
        System.out.println("Name: "   + studentName);
        System.out.println("Dept: "   + department);
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
