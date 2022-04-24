package com.electrogrid.generate_bills.model;

import javax.validation.constraints.Pattern;

/***
 *
 * @author IT19976518
 * Ketipearachchi C. D.
 * it19976518@my.sliit.lk
 *
 */

public class Bills {

    private int id;

    private String invoiceNo;

    private String accountNo;

    private String userName;

    @Pattern(regexp = "^$|[a-zA-Z0-9_.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "is not in valid format")
    private String email;

    @Pattern(regexp = "(^$|([0-9]{10})|(\\+[0-9]{11,20})$)", message = "is not in valid format")
    private String mobileNo;

    private String home;

    private String date;

    private String billAmount;

    public Bills() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Bills{" +
                "id=" + id +
                ", invoiceNo='" + invoiceNo + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", home='" + home + '\'' +
                ", date='" + date + '\'' +
                ", billAmount='" + billAmount + '\'' +
                '}';
    }
}
