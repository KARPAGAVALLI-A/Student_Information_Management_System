package sims;

public class Professor {
    int professorId;
    String professorName;
    String subject;

    public Professor(int id, String name, String subject) {
        this.professorId = id;
        this.professorName = name;
        this.subject = subject;
    }

    public void addProfessor() {
        System.out.println("Professor Added: " + professorName);
    }

    public void assignMarks(Marks marks) {
        System.out.println("Marks assigned by " + professorName);
    }
}