package com.example.homeassignment;

public class Member1 {
    String branch,status;
    Integer sem;

    public Member1() {
    }

    public Member1(String branch, String status, Integer sem) {
        this.branch = branch;
        this.status = status;
        this.sem = sem;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSem() {
        return sem;
    }

    public void setSem(Integer sem) {
        this.sem = sem;
    }
}
