package com.example.entity.controller;

import com.example.entity.DTO.ModuleDTO;
import com.example.entity.model.Course;
import com.example.entity.model.Lecturer;
import com.example.entity.model.Module;
import com.example.entity.repository.CourseRepository;
import com.example.entity.repository.LecturerRepository;
import com.example.entity.repository.ModuleRepository;
import com.example.entity.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private LecturerRepository lecturerRepository;

    @PostMapping
    public ResponseEntity<Module> createModule(@RequestBody ModuleDTO moduleDTO) {
        Optional<Course> courseOpt = courseRepository.findById(moduleDTO.getCourseId());
        Optional<Lecturer> lecturerOpt = lecturerRepository.findById(moduleDTO.getLecturerId());
        if (courseOpt.isEmpty()) {
            return ResponseEntity.badRequest().body(null); // or throw an exception
        }
        Course course = courseOpt.get();

        if (lecturerOpt.isEmpty()) {
            return ResponseEntity.badRequest().body(null); // or throw an exception
        }
        Lecturer lecturer = lecturerOpt.get();

        Module module = new Module();
        module.setTitle(moduleDTO.getTitle());
        module.setDescription(moduleDTO.getDescription());
        module.setCourse(course);
        module.setLecturer(lecturer);
        Module savedModule = moduleRepository.save(module);
        return ResponseEntity.ok(savedModule);
    }

//    @PostMapping
//    public Module createModule(@RequestBody Module module) {
//        return moduleService.createModule(module);
//    }

    @GetMapping
    public List<Module> getAllModules() {
        return moduleService.getAllModules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Module> getModuleById(@PathVariable Long id) {
        Module module = moduleService.getModuleById(id).orElseThrow();
        return ResponseEntity.ok(module);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Module> updateModule(@PathVariable Long id, @RequestBody ModuleDTO moduleDTO) {

        Optional<Module> moduleOpt = moduleRepository.findById(id);
        if (moduleOpt.isEmpty()) {
            return ResponseEntity.notFound().build(); // Return 404 if module doesn't exist
        }

        Optional<Course> courseOpt = courseRepository.findById(moduleDTO.getCourseId());
        if (courseOpt.isEmpty()) {
            return ResponseEntity.badRequest().build(); // Return 400 if course is invalid
        }

        Optional<Lecturer> lecturerOpt = lecturerRepository.findById(moduleDTO.getLecturerId());
        if (lecturerOpt.isEmpty()) {
            return ResponseEntity.badRequest().build(); // Return 400 if lecturer is invalid
        }

        Module existingModule = moduleOpt.get();
        existingModule.setTitle(moduleDTO.getTitle());
        existingModule.setDescription(moduleDTO.getDescription());
        existingModule.setCourse(courseOpt.get());
        existingModule.setLecturer(lecturerOpt.get());
        Module updatedModule = moduleService.updateModule(id, existingModule);
        return ResponseEntity.ok(updatedModule);
    }

//    @PutMapping("/{id}")
//    public Module updateModule(@PathVariable Long id, @RequestBody Module module) {
//        return moduleService.updateModule(id, module);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable Long id) {
        moduleService.deleteModule(id);
        return ResponseEntity.noContent().build();
    }
}

