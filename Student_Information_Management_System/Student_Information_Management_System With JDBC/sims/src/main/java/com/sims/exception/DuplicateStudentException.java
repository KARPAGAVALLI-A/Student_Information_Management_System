package com.sims.exception;

public class DuplicateStudentException extends RuntimeException {
    public DuplicateStudentException(int studentId) {
        super("Student with ID " + studentId + " already exists.");
    }
}
