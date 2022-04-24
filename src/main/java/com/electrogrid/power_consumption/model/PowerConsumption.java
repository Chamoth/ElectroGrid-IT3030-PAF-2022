package com.electrogrid.power_consumption.model;

public class PowerConsumption {

    private int id;

    private String accountNo;

    private String invoiceNo;

    private String userName;


    private int usedUnits;


    private float totalCost;


    public PowerConsumption() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUsedUnit() {
        return usedUnits;
    }

    public void setUsedUnit(int usedUnit) {
        this.usedUnits = usedUnit;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "PowerConsumption{" +
                "id=" + id +
                ", invoiceNo='" + accountNo + '\'' +
                ", accountNo='" + invoiceNo + '\'' +
                ", userName='" + userName + '\'' +
                ", usedUnit='" + usedUnits + '\'' +
                ", totalCost='" + totalCost + '\'' +
                '}';
    }
}
