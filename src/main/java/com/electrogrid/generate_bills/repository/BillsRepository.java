package com.electrogrid.generate_bills.repository;

import com.electrogrid.generate_bills.model.Bills;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class BillsRepository {

//    List <Bills> bills;

    Connection con = null;

    public BillsRepository() {

        String url = "jdbc:mysql://localhost:3306/electrogrid_db?useSSL=false";
        String userName = "root";
        String password = "990219";

        try {

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(url, userName, password);

            System.out.println("Database connection is success!!!");

        }
        catch (Exception e) {
            System.out.println("Database connection is not success!!!");
        }

//        bills = new ArrayList<>();
//
//        Bills b1 = new Bills();
//
//        b1.setId(001);
//        b1.setInvoiceNo("00001");
//        b1.setAccountNo("Elec0001");
//        b1.setUserName("Chamoth");
//        b1.setBillAmount("Rs.1000");
//
//        bills.add(b1);

    }

    public List<Bills> getBills(){

        List<Bills> bills = new ArrayList<>();
        String sql = "select * from electrogrid_db.bills";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                Bills b = new Bills();
                b.setId(rs.getInt(1));
                b.setInvoiceNo(rs.getString(2));
                b.setAccountNo(rs.getString(3));
                b.setUserName(rs.getString(4));
                b.setEmail(rs.getString(5));
                b.setMobileNo(rs.getString(6));
                b.setHome(rs.getString(7));
                b.setDate(rs.getString(8));
                b.setBillAmount(rs.getString(9));

                bills.add(b);
            }
        }
        catch (Exception e) {
            System.out.println("Database cannot get bills!!!");
        }


        return  bills;

    }

    public Bills getBill(int id) {

        String sql = "select * from electrogrid_db.bills where id="+id;
        Bills b = new Bills();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if(rs.next()){
                b.setId(rs.getInt(1));
                b.setInvoiceNo(rs.getString(2));
                b.setAccountNo(rs.getString(3));
                b.setUserName(rs.getString(4));
                b.setEmail(rs.getString(5));
                b.setMobileNo(rs.getString(6));
                b.setHome(rs.getString(7));
                b.setDate(rs.getString(8));
                b.setBillAmount(rs.getString(9));

            }
        }
        catch (Exception e) {
            System.out.println("Database cannot get bill!!!");
        }

        return b;

//        for(Bills b : bills){
//            if(b.getId() == id){
//                return b;
//            }
//        }
//        return  null;
    }


    public void createBill(Bills b1) {

        String sql = "insert into electrogrid_db.bills values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, b1.getId());
            st.setString(2, b1.getInvoiceNo());
            st.setString(3, b1.getAccountNo());
            st.setString(4, b1.getUserName());
            st.setString(5, b1.getEmail());
            st.setString(6, b1.getMobileNo());
            st.setString(7, b1.getHome());
            st.setString(8, b1.getDate());
            st.setString(9, b1.getBillAmount());

            st.executeUpdate();

//            if(rs.next()){
//                b.setId(rs.getInt(1));
//                b.setInvoiceNo(rs.getString(2));
//                b.setAccountNo(rs.getString(3));
//                b.setUserName(rs.getString(4));
//                b.setEmail(rs.getString(5));
//                b.setMobileNo(rs.getString(6));
//                b.setHome(rs.getString(7));
//                b.setDate(rs.getString(8));
//                b.setBillAmount(rs.getString(9));
//            }
        }
        catch (Exception e) {
            System.out.println("Database cannot add bills!!!");
        }

    }

}
