package com.example.entity.DTO;

public class ModuleDTO {

    private String title;
    private String description;
    private Long courseId;
    private Long lecturerId;

    // Default constructor
    public ModuleDTO() {
    }

    // Constructor with all fields
    public ModuleDTO(String title, String description, Long courseId) {
        this.title = title;
        this.description = description;
        this.courseId = courseId;
    }

    // Getters and Setters

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

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Long lecturerId) {
        this.lecturerId = lecturerId;
    }

    @Override
    public String toString() {
        return "ModuleDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", courseId=" + courseId +
                ", lecturerId=" + lecturerId +
                '}';
    }
}