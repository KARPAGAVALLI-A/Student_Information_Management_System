package sims;

import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        students = FileHandler.load();

        while (true) {
            System.out.println("\n1.Add");
            System.out.println("2.View All");
            System.out.println("3.Search");
            System.out.println("4.Update");
            System.out.println("5.Delete");
            System.out.println("6.Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1: addStudent(); break;
                case 2: viewAll(); break;
                case 3: search(); break;
                case 4: update(); break;
                case 5: delete(); break;

                case 6:
                    FileHandler.save(students);
                    FileHandler.saveAsText(students); // 🔥 TEXT FILE
                    System.out.println("Saved!");
                    return;

                default:
                    System.out.println("Invalid");
            }
        }
    }

    // 🔹 ADD STUDENT
    static void addStudent() {
        System.out.print("ID: ");
        int id = sc.nextInt(); sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Dept: ");
        String dept = sc.nextLine();

        Student s = new Student(id, name, dept);

        System.out.print("Internal: ");
        int i = sc.nextInt();

        System.out.print("External: ");
        int e = sc.nextInt();
        s.marks.setMarks(i, e);

        System.out.print("Total Classes: ");
        int t = sc.nextInt();

        System.out.print("Present: ");
        int p = sc.nextInt();
        s.attendance.markAttendance(t, p);

        System.out.print("Fee: ");
        double f = sc.nextDouble();
        s.fee.payFee(f);

        System.out.print("Course ID: ");
        int cid = sc.nextInt(); sc.nextLine();

        System.out.print("Course Name: ");
        String cname = sc.nextLine();

        s.courses.add(new Course(cid, cname));

        students.add(s);
        System.out.println("Added!");
    }

    // 🔹 VIEW ALL
    static void viewAll() {
        for (Student s : students) {
            s.display();
        }
    }

    // 🔹 SEARCH
    static void search() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.studentId == id) {
                s.display();
                return;
            }
        }
        System.out.println("Not found");
    }

    // 🔹 UPDATE
    static void update() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt(); sc.nextLine();

        for (Student s : students) {
            if (s.studentId == id) {

                System.out.print("New Name: ");
                s.studentName = sc.nextLine();

                System.out.print("New Dept: ");
                s.department = sc.nextLine();

                System.out.println("Updated!");
                return;
            }
        }
        System.out.println("Not found");
    }

    // 🔹 DELETE
    static void delete() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        students.removeIf(s -> s.studentId == id);
        System.out.println("Deleted if existed");
    }
}