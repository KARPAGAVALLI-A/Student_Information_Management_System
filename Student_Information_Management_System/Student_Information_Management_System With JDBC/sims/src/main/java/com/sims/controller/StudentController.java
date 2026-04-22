package com.sims.controller;

import com.sims.model.Student;
import com.sims.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public String listStudents(Model model) {
        List<Student> students = studentService.viewAll();
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "add";
    }

    @PostMapping("/add")
    public String addStudent(
            @RequestParam int studentId,
            @RequestParam String studentName,
            @RequestParam String department,
            @RequestParam int internal,
            @RequestParam int external,
            @RequestParam int totalClass,
            @RequestParam int present,
            @RequestParam double feeAmount,
            @RequestParam int courseId,
            @RequestParam String courseName,
            RedirectAttributes ra) {

        studentService.addStudent(studentId, studentName, department,
                internal, external, totalClass, present,
                feeAmount, courseId, courseName);
        ra.addFlashAttribute("successMessage", "Student added successfully!");
        return "redirect:/students";
    }

    @GetMapping("/view/{studentId}")
    public String viewStudent(@PathVariable int studentId, Model model) {
        model.addAttribute("student", studentService.search(studentId));
        return "view";
    }

    @GetMapping("/edit/{studentId}")
    public String showEditForm(@PathVariable int studentId, Model model) {
        model.addAttribute("student", studentService.search(studentId));
        return "edit";
    }

    @PostMapping("/edit/{studentId}")
    public String updateStudent(
            @PathVariable int studentId,
            @RequestParam String studentName,
            @RequestParam String department,
            RedirectAttributes ra) {

        studentService.update(studentId, studentName, department);
        ra.addFlashAttribute("successMessage", "Student updated successfully!");
        return "redirect:/students";
    }

    @GetMapping("/delete/{studentId}")
    public String deleteStudent(@PathVariable int studentId, RedirectAttributes ra) {
        studentService.delete(studentId);
        ra.addFlashAttribute("successMessage", "Student deleted successfully!");
        return "redirect:/students";
    }

    @GetMapping("/search")
    public String searchStudent(@RequestParam int studentId, Model model) {
        model.addAttribute("student", studentService.search(studentId));
        return "view";
    }
}
