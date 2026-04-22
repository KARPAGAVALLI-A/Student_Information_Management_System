package com.sims.service;

import com.sims.exception.DuplicateStudentException;
import com.sims.exception.StudentNotFoundException;
import com.sims.model.Course;
import com.sims.model.Student;
import com.sims.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    // original: add student
    @Transactional
    public Student addStudent(int id, String name, String dept,
                              int internal, int external,
                              int totalClasses, int present,
                              double feeAmount,
                              int courseId, String courseName) {

        if (studentRepository.existsByStudentId(id)) {
            throw new DuplicateStudentException(id);
        }

        Student s = new Student(id, name, dept);
        s.getMarks().setMarks(internal, external);
        s.getAttendance().markAttendance(totalClasses, present);
        s.getFee().payFee(feeAmount);
        s.getResult().generateResult(s.getMarks());

        Course course = new Course(courseId, courseName);
        course.setStudent(s);
        s.getCourses().add(course);

        return studentRepository.save(s);
    }

    // original: view all
    public List<Student> viewAll() {
        List<Student> students = studentRepository.findAll();
        students.forEach(s -> s.getResult().generateResult(s.getMarks()));
        return students;
    }

    // original: search
    public Student search(int studentId) {
        Student s = studentRepository.findByStudentId(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));
        s.getResult().generateResult(s.getMarks());
        return s;
    }

    // original: update (name + dept only)
    @Transactional
    public Student update(int studentId, String newName, String newDept) {
        Student s = studentRepository.findByStudentId(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));
        s.setStudentName(newName);
        s.setDepartment(newDept);
        return studentRepository.save(s);
    }

    // original: delete
    @Transactional
    public void delete(int studentId) {
        Student s = studentRepository.findByStudentId(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));
        studentRepository.delete(s);
    }
}
