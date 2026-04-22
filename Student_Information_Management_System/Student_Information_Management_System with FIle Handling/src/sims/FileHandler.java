package sims;

import java.io.*;
import java.util.*;

public class FileHandler {
    public static void save(List<Student> students) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"));
            oos.writeObject(students);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error saving file");
        }
    }
    public static List<Student> load() {
        List<Student> list = new ArrayList<>();

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"));
            list = (List<Student>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println("No previous data found");
        }

        return list;
    }
    public static void saveAsText(List<Student> students) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("students.txt"));

            for (Student s : students) {
                pw.println("ID: " + s.studentId);
                pw.println("Name: " + s.studentName);
                pw.println("Dept: " + s.department);

                pw.println("Internal: " + s.marks.internal);
                pw.println("External: " + s.marks.external);
                pw.println("Total: " + s.marks.getTotal());

                pw.println("Attendance: " + s.attendance.calcPercentage() + "%");
                pw.println("Fee: " + s.fee.amount + " | " + s.fee.status);

                pw.println("Result: " + (s.marks.getTotal() >= 50 ? "Pass" : "Fail"));

                for (Course c : s.courses) {
                    pw.println("Course: " + c.courseName);
                }

                pw.println("----------------------");
            }

            pw.close();
        } catch (Exception e) {
            System.out.println("Error writing text file");
        }
    }
}