package com.electrogrid.payment_service.repository;

import com.electrogrid.payment_service.model.Payments;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class PaymentsRepository {

    Connection con = null;

    public PaymentsRepository() {

        String url = "jdbc:mysql://localhost:3306/electrogrid?useSSL=false";
        String userName = "root";
        String password = "root";

        try {

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(url, userName, password);

            System.out.println("Database connection is success!!!");

        }
        catch (Exception e) {
            System.out.println("Database connection is not success!!!");
        }

    }

    //Display All Payment Details
    public List<Payments> getPayments(){

        List<Payments> payments = new ArrayList<Payments>();
        String sql = "SELECT * FROM electrogrid.payment";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                Payments p = new Payments();
                p.setId(rs.getInt(1));
                p.setB_id(rs.getString(2));
                p.setAccount_number(rs.getString(3));
                p.setC_id(rs.getString(4));
                p.setC_name(rs.getString(5));
                p.setAmount(rs.getDouble(6));
                p.setCard_number(rs.getString(7));
                p.setBank_name(rs.getString(8));
                p.setCard_exp_date(rs.getString(9));
                p.setCvv(rs.getInt(10));
                p.setDate(rs.getString(11));

                payments.add(p);
            }
        }
        catch (Exception e) {
            System.out.println("Database cannot get payments  !");
        }

        return  payments;
    }

    // Get specific payment detail
    public Payments getPayment(int id) {

        String sql = "SELECT * FROM electrogrid.payment WHERE id="+id;
        Payments p = new Payments();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if(rs.next()){
                p.setId(rs.getInt(1));
                p.setB_id(rs.getString(2));
                p.setAccount_number(rs.getString(3));
                p.setC_id(rs.getString(4));
                p.setC_name(rs.getString(5));
                p.setAmount(rs.getDouble(6));
                p.setCard_number(rs.getString(7));
                p.setBank_name(rs.getString(8));
                p.setCard_exp_date(rs.getString(9));
                p.setCvv(rs.getInt(10));
                p.setDate(rs.getString(11));

            }
        }
        catch (Exception e) {
            System.out.println("Database cannot get a selected payment detail !");
        }

        return p;
    }

   //Insert Payment Details

    public void createPayment(Payments py){

        String sql = "INSERT INTO electrogrid.payment values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, py.getId());
            st.setString(2, py.getB_id());
            st.setString(3, py.getAccount_number());
            st.setString(4, py.getC_id());
            st.setString(5, py.getC_name());
            st.setDouble(6, py.getAmount());
            st.setString(7, py.getCard_number());
            st.setString(8, py.getBank_name());
            st.setString(9, py.getCard_exp_date());
            st.setInt(10, py.getCvv());
            st.setString(11, py.getDate());

            st.executeUpdate();

        }
        catch (Exception e) {
            System.out.println("Database cannot add Payments  !");
        }
    }

    //Update Payment Details
    public void updatePayment(Payments py) {

        String sql = "UPDATE electrogrid.payment SET b_id=?, account_number=?, c_id=?, c_name=?, amount=?, card_number=?, bank_name=?, card_exp_date=?, cvv=?, date=? WHERE id =?";

        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, py.getB_id());
            st.setString(2, py.getAccount_number());
            st.setString(3, py.getC_id());
            st.setString(4, py.getC_name());
            st.setDouble(5, py.getAmount());
            st.setString(6, py.getCard_number());
            st.setString(7, py.getBank_name());
            st.setString(8, py.getCard_exp_date());
            st.setInt(9, py.getCvv());
            st.setString(10, py.getDate());
            st.setInt(11, py.getId());

            st.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Database cannot update payments  !");
        }
    }

}
