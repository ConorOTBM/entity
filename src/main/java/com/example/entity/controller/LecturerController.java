package com.example.entity.controller;

import com.example.entity.model.Lecturer;
import com.example.entity.model.Student;
import com.example.entity.service.LecturerService;
import com.example.entity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lecturers")
public class LecturerController {

    @Autowired
    private LecturerService lecturerService;

    @PostMapping
    public Lecturer createLecturer(@RequestBody Lecturer lecturer) {
        return lecturerService.createLecturer(lecturer);
    }

    @GetMapping("{id}")
    public Optional<Lecturer> findById(@PathVariable Long id) {
        Optional<Lecturer> optionalLecturer = lecturerService.getLecturerById(id);
        if(optionalLecturer.isEmpty()) {
            throw new RuntimeException("Lecturer id not found, " + id);
        }
        else {
            return  optionalLecturer;
        }
    }

    @GetMapping("/test/{id}")
    public ResponseEntity<Lecturer> getLecturerById(@PathVariable Long id) {
        Lecturer lecturer = lecturerService.getLecturerById(id).orElseThrow();
        return ResponseEntity.ok(lecturer);
    }
    @GetMapping
    public List<Lecturer> getAllLecturers() {
        return lecturerService.getAllLecturers();
    }

    @PutMapping("/{id}")
    public Lecturer updateLecturer(@PathVariable Long id, @RequestBody Lecturer lecturer) {
        return lecturerService.updateLecturer(id, lecturer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLecturer(@PathVariable Long id) {
        lecturerService.deleteLecturer(id);
        return ResponseEntity.noContent().build();
    }
}
