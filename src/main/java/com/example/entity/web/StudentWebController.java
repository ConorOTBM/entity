package com.example.entity.web;


import com.example.entity.model.Student;
import com.example.entity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentWebController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String getStudents(Model model) {
        // get students from the database
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        model.addAttribute("student", new Student());
        // open our template
        return "students";
    }

    @PostMapping
    public String addStudent(Student student) {
        studentService.createStudent(student);
        return "students";
    }
}
