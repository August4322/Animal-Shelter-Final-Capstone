package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Volunteer {
    private int id;
    private String name;
    private String email;
    private int phone;
    private int applicationStatusId = 1;

    public Volunteer() {}

    //May need to add authorities later
    public Volunteer(int id, String name, String email, int phone, int applicationStatusId){
        this.id = id;
        this.name =  name;
        this.email = email;
        this.phone = phone;
        this.applicationStatusId = applicationStatusId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getApplicationStatusId() {
        return applicationStatusId;
    }

    public void setApplicationStatusId(int applicationStatusId) {
        this.applicationStatusId = applicationStatusId;
    }
}
