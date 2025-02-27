package com.example.entity.controller;

import com.example.entity.DTO.AdministratorDTO;
import com.example.entity.model.Administrator;
import com.example.entity.model.Course;
import com.example.entity.repository.AdministratorRepository;
import com.example.entity.repository.CourseRepository;
import com.example.entity.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/administrators")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    public ResponseEntity<Administrator> createAdministrator(@RequestBody AdministratorDTO administratorDTO) {
        Optional<Course> courseOpt = courseRepository.findById(administratorDTO.getCourseId());
        if (courseOpt.isEmpty()) {
            return ResponseEntity.badRequest().body(null); // or throw an exception
        }
        Course course = courseOpt.get();

        Administrator administrator = new Administrator();
        administrator.setFirstname(administratorDTO.getFirstname());
        administrator.setLastname(administratorDTO.getLastname());
        administrator.setStaffnumber(administratorDTO.getStaffnumber());
        administrator.setEmail(administratorDTO.getEmail());
        administrator.setCourse(course);
        administrator.setLead(administratorDTO.getLead());
        Administrator savedAdministrator = administratorRepository.save(administrator);
        return ResponseEntity.ok(savedAdministrator);
    }

//    @PostMapping
//    public Administrator createAdministrator(@RequestBody Administrator administrator) {
//        return administratorService.createAdministrator(administrator);
//    }

    @GetMapping
    public List<Administrator> getAllAdministrators() {
        return administratorService.getAllAdministrators();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrator> getAdministratorById(@PathVariable Long id) {
        Administrator administrator = administratorService.getAdministratorById(id).orElseThrow();
        return ResponseEntity.ok(administrator);
    }

    @PutMapping("/{id}")
    public Administrator updateAdministrator(@PathVariable Long id, @RequestBody Administrator administrator) {
        return administratorService.updateAdministrator(id, administrator);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministrator(@PathVariable Long id) {
        administratorService.deleteAdministrator(id);
        return ResponseEntity.noContent().build();
    }
}
