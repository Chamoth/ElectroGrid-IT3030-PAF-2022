package com.electrogrid.generate_bills.repository;

import com.electrogrid.generate_bills.model.Bills;

import java.util.ArrayList;
import java.util.List;

public class BillsRepository {

    List <Bills> bills;

    public BillsRepository() {

        bills = new ArrayList<>();

        Bills b1 = new Bills();

        b1.setId(001);
        b1.setInvoiceNo("00001");
        b1.setAccountNo("Elec0001");
        b1.setUserName("Chamoth");
        b1.setBillAmount("Rs.1000");

        bills.add(b1);

    }

    public List<Bills> getBills(){

        return  bills;

    }

    public Bills getBill(int id) {

        for(Bills b : bills){
            if(b.getId() == id){
                return b;
            }
        }

        return  null;
    }


    public void createBill(Bills b1) {

        bills.add(b1);

    }

}
