package com.example.entity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Lecturer extends Employee {

    @OneToMany(mappedBy = "lecturer", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    @JsonIgnore    // Prevents serialization of the course field when a Module is converted to JSON
    private List<Module> modules;

    public Lecturer() {}

    public Lecturer(String firstname, String lastname, int staffnumber) {
        super(firstname, lastname, staffnumber);
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
}

