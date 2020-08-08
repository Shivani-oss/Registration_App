package com.example.homeassignment;

public class DataSet3 {
    String branch,status;
    Integer sem;

    public DataSet3() {
    }

    public DataSet3(String branch, String status, Integer sem) {
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
