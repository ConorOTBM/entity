package com.example.entity.controller;

import com.example.entity.DTO.CourseDTO;
import com.example.entity.model.Course;
import com.example.entity.model.Module;
import com.example.entity.model.Student;
import com.example.entity.repository.ModuleRepository;
import com.example.entity.repository.StudentRepository;
import com.example.entity.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id).orElseThrow();
        return ResponseEntity.ok(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody CourseDTO courseDTO) {
        Optional<Course> courseOpt = courseService.getCourseById(id);
        if (courseOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Course existingCourse = courseOpt.get();
        existingCourse.setTitle(courseDTO.getTitle());
        existingCourse.setDescription(courseDTO.getDescription());

        // Update Modules
        List<Module> modules = moduleRepository.findAllById(courseDTO.getModuleids());
        existingCourse.setModules(modules); // Change to List if that's the expected type

        // Update Students
        List<Student> students = studentRepository.findAllById(courseDTO.getStudentids());
        existingCourse.setStudents(students); // Change to List if that's the expected type

        Course updatedCourse = courseService.updateCourse(id, existingCourse);
        return ResponseEntity.ok(updatedCourse);
    }

//    @PutMapping("/{id}")
//    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
//        return courseService.updateCourse(id, course);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}

