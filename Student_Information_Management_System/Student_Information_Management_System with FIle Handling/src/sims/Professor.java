package sims;

import java.io.Serializable;

public class Professor implements Serializable {
    int professorId;
    String professorName;
    String subject;

    public Professor(int id, String name, String subject) {
        this.professorId = id;
        this.professorName = name;
        this.subject = subject;
    }

    public void assignMarks(Marks marks, int internal, int external) {
        marks.setMarks(internal, external);
        System.out.println("Marks assigned by " + professorName);
    }
}