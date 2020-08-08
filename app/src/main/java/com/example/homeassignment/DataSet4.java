package com.example.homeassignment;

public class DataSet4 {
    String amount;
    String accountno;
    String accountname;
    String date;
    String bankname;
    String ifsc;
    String method;

    public DataSet4() {
    }

    public DataSet4(String amount, String accountno, String accountname, String date, String bankname, String ifsc, String method) {
        this.amount = amount;
        this.accountno = accountno;
        this.accountname = accountname;
        this.date = date;
        this.bankname = bankname;
        this.ifsc = ifsc;
        this.method = method;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
