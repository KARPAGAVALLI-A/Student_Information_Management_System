package sims;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student(1, "Karpaga", "CSE", "karpaga@mail.com", "9876543210");
        s1.addStudent();
        s1.viewStudent();

        Course c1 = new Course(101, "CS101");
        c1.addCourse();

        s1.courses.add(c1);

        s1.attendance.markAttendance(100, 85);
        System.out.println("Attendance %: " + s1.attendance.calcPercentage());

        s1.fee.payFee(50000);
        s1.fee.viewFee();
        Marks m = new Marks();
        m.internal = 25;
        m.external = 50;

        m.calcTotalMark();
        m.displayMarks(); 
        Result r = new Result();
        r.generateResult(m);

        Professor p = new Professor(1, "Dr. Kumar", "Java");
        p.addProfessor();
        p.assignMarks(m);
    }
}