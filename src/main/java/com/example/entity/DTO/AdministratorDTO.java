package com.example.entity.DTO;

public class AdministratorDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private int staffnumber;
    private Long courseId;
    private Boolean lead;

    public AdministratorDTO() {}

    public AdministratorDTO(Long id, String firstname, String lastname, int staffnumber, Long courseId, Boolean lead) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.staffnumber = staffnumber;
        this.courseId = courseId;
        this.lead = lead;
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

    public int getStaffnumber() {
        return staffnumber;
    }

    public void setStaffnumber(int staffnumber) {
        this.staffnumber = staffnumber;
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

    public Boolean getLead() {
        return lead;
    }

    public void setLead(Boolean lead) {
        this.lead = lead;
    }

    @Override
    public String toString() {
        return "AdministratorDTO{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", staffnumber=" + staffnumber +
                ", courseId=" + courseId +
                ", lead=" + lead +
                '}';
    }
}
