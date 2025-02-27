package com.example.entity.DTO;

public class StudentDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private int studentnumber;
    private Long courseId;

    public StudentDTO() {}

    public StudentDTO(Long id, String firstname, String lastname, int studentnumber, Long courseId) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.studentnumber = studentnumber;
        this.courseId = courseId;
    }

    // Getters and setters ...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getStudentnumber() {
        return studentnumber;
    }

    public void setStudentnumber(int studentnumber) {
        this.studentnumber = studentnumber;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", studentnumber=" + studentnumber +
                ", courseId=" + courseId +
                '}';
    }
}
