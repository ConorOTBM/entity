package com.example.entity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Administrator extends Employee {

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    @JsonIgnore // Prevents serialization of the course field when an Administrator is converted to JSON
    private Course course;
    private Boolean lead;

    public Administrator() {};

    public Administrator(String firstname, String lastname, int staffnumber, Course course, Boolean lead) {
        super(firstname, lastname, staffnumber);
        this.course = course;
        this.lead = lead;
    }

    // Getters and setters
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Boolean getLead() {
        return lead;
    }

    public void setLead(Boolean lead) {
        this.lead = lead;
    }
}