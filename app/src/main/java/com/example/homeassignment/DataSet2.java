package com.example.homeassignment;

public class DataSet2 {

    String id,mail,city,dob,phone_no,username;

    public DataSet2() {
    }

    public DataSet2(String id, String mail, String city, String dob, String phone_no, String username) {
        this.id = id;
        this.mail = mail;
        this.city = city;
        this.dob = dob;
        this.phone_no = phone_no;
        this.username = username;
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDob() {
        return dob;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
