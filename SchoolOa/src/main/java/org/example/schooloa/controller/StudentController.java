package org.example.schooloa.controller;

import org.example.schooloa.entity.Student;
import org.example.schooloa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public String listStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student/list";
    }

    @GetMapping("/add")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/add";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        studentService.addStudent(student);
        return "redirect:/student/list";
    }

    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        Student student = studentService.getAllStudents().stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
        model.addAttribute("student", student);
        return "student/edit";
    }

    @PostMapping("/edit")
    public String editStudent(@ModelAttribute Student student) {
        studentService.updateStudent(student);
        return "redirect:/student/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/student/list";
    }
}
