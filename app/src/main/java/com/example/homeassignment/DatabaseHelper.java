package com.example.homeassignment;

public class DatabaseHelper {
    public String  Name,Email,Option;

    public DatabaseHelper() {

    }
    public DatabaseHelper(String name, String email, String option) {
        Name = name;
        Email = email;
        Option = option;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getOption() {
        return Option;
    }

    public void setOption(String option) {
        Option = option;
    }



}
