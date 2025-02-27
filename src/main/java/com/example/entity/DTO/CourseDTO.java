package com.example.entity.DTO;

import java.util.List;

public class CourseDTO {

    private Long id;
    private String title;
    private String description;
    private List<Long>  moduleids;
    private List<Long> studentids;

    // Constructors, getters, setters...
    public CourseDTO() {}

    public CourseDTO(String title, String description, List<Long> moduleids, List<Long> studentids) {
        this.title = title;
        this.description = description;
        this.moduleids = moduleids;
        this.studentids = studentids;
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

    public List<Long> getModuleids() {
        return moduleids;
    }

    public void setModuleids(List<Long> moduleids) {
        this.moduleids = moduleids;
    }

    public List<Long> getStudentids() {
        return studentids;
    }

    public void setStudentids(List<Long> studentids) {
        this.studentids = studentids;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", moduleids=" + moduleids +
                ", studentids=" + studentids +
                '}';
    }
}
