package com.example.homeassignment;

public class Member4 {

    String username,dob,designation,branch,phone,state;

    public Member4() {
    }
    public Member4(String username, String dob, String designation, String branch, String phone,String state) {
        this.username = username;
        this.dob = dob;
        this.designation = designation;
        this.branch = branch;
        this.phone = phone;
        this.state = state;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
