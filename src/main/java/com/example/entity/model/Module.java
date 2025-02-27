package com.example.entity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    @JsonIgnore    // Prevents serialization of the course field when a Module is converted to JSON
    private Course course;

    @ManyToOne
    @JoinColumn(name = "lecturer_id", nullable = true) // Allowing NULLs
    private Lecturer lecturer;

    // Constructors, getters, setters...
    public Module() {}

    public Module(String title, String description, Course course) {
        this.title = title;
        this.description = description;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }
}