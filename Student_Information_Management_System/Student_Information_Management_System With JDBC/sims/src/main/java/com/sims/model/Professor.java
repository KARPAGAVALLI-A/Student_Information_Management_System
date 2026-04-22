package com.sims.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "professors")
@Data
@NoArgsConstructor
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int professorId;
    private String professorName;
    private String subject;

    public Professor(int professorId, String professorName, String subject) {
        this.professorId = professorId;
        this.professorName = professorName;
        this.subject = subject;
    }

    // original logic
    public void assignMarks(Marks marks, int internal, int external) {
        marks.setMarks(internal, external);
        System.out.println("Marks assigned by " + professorName);
    }
}
