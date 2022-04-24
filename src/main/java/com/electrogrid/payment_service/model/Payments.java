package com.electrogrid.payment_service.model;

public class Payments {

    private int id;
    private String b_id;
    private String account_number;
    private String c_id;
    private String c_name;
    private double amount;
    private String card_number;
    private String bank_name;
    private String card_exp_date;
    private int cvv;
    private String date;

    public Payments() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getB_id() {
        return b_id;
    }

    public void setB_id(String b_id) {
        this.b_id = b_id;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getCard_exp_date() {
        return card_exp_date;
    }

    public void setCard_exp_date(String card_exp_date) {
        this.card_exp_date = card_exp_date;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Payments{" +
                "id=" + id +
                ", b_id='" + b_id + '\'' +
                ", account_number='" + account_number + '\'' +
                ", c_id='" + c_id + '\'' +
                ", c_name='" + c_name + '\'' +
                ", amount=" + amount +
                ", card_number='" + card_number + '\'' +
                ", bank_name='" + bank_name + '\'' +
                ", card_exp_date='" + card_exp_date + '\'' +
                ", cvv=" + cvv +
                ", date='" + date + '\'' +
                '}';
    }
}


