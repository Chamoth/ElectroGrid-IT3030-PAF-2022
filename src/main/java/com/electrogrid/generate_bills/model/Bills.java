package com.electrogrid.generate_bills.model;

public class Bills {

    private String invoiceNo;

    private String accountNo;

    private String userName;

    private String email;

    private String mobileNo;

    private String home;

    private String date;

    private String billAmount;

    public Bills(String invoiceNo, String accountNo, String userName, String email, String mobileNo, String home, String date, String billAmount) {
        this.invoiceNo = invoiceNo;
        this.accountNo = accountNo;
        this.userName = userName;
        this.email = email;
        this.mobileNo = mobileNo;
        this.home = home;
        this.date = date;
        this.billAmount = billAmount;
    }

    public Bills() {

    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(String billAmount) {
        this.billAmount = billAmount;
    }
}
