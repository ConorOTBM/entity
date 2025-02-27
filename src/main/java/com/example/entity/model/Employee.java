package com.example.entity.model;

import jakarta.persistence.Entity;

@Entity
public abstract class Employee extends Person {

    private int staffnumber;

    public Employee() {}

    public Employee(String firstname, String lastname, int staffnumber) {
        super(firstname, lastname);
        this.staffnumber = staffnumber;
    }

    public int getStaffnumber() {
        return this.staffnumber;
    }

    public void setStaffnumber(int staffnumber) {
        this.staffnumber = staffnumber;
    }
}