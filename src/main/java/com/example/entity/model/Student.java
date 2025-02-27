package com.example.entity.model;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private String email;

    @Column(unique = true)
    private int studentnumber;

    public Student()
    {

    }
    public Student(String firstname, String lastname, int studentnumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.studentnumber = studentnumber;
    }

    public int getStudentnumber() {
        return studentnumber;
    }


    public void setStudentnumber(int studentnumber) {
        this.studentnumber = studentnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
