package com.example.homeassignment;

public class Member {

    private String username;
    private String dob;
    private String phone_no;
    private String mail;
    private String city;

    public Member(){

    }

    public Member(String id, String username, String dob, String mail, String city, String phone_no )  {
        this.username = username;
        this.dob = dob;
        this.phone_no = phone_no;
        this.mail = mail;
        this.city = city;
        this.id = id;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;
}
