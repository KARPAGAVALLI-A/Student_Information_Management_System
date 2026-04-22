package com.sims.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(int studentId) {
        super("Student with ID " + studentId + " not found.");
    }
}
