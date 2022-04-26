package com.electrogrid.generate_bills.repository;

import com.electrogrid.generate_bills.model.Bills;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.Properties;

/***
 *
 * @author IT19976518
 * Ketipearachchi C. D.
 * it19976518@my.sliit.lk
 *
 */

public class BillsRepository {

    static Logger logger = Logger.getLogger(BillsRepository.class);

    Connection con = null;


    /***
     *
     * In here, declared the database connection and config
     *
     */
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

    }


    /***
     *
     * This method is used to create bills
     *
     */
    public String createBill(Bills b1) {

        String sql = "INSERT INTO electrogrid_db.bills VALUES (?,?,?,?,?,?,?,?,?)";

        String output ="";

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
            System.out.println("Database successfully added the bill");
            output = "Inserted Bill Details Saved to the System Successfully";

        }
        catch (Exception e) {
            System.out.println("Database cannot add bill details!!!");
            output = "Bill Created UnSuccessful.....!";
            System.err.println(e.getMessage());
        }

        return output;

    }


    /***
     *
     * This method is used to get all bills at the same time
     *
     */
    public List<Bills> getBills(){

        List<Bills> bills = new ArrayList<>();
        String sql = "SELECT * FROM electrogrid_db.bills";

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
//                System.out.println("Database successfully get all bills");
//                logger.debug("Database get bills!!!");

            }
        }
        catch (Exception e) {
            System.out.println("Database cannot get bills!!!");
            System.err.println(e.getMessage());
//            logger.debug("Database cannot get bills!!!");
        }

        return  bills;

    }


    /***
     *
     * This method is used to get one bill at a time
     *
     */
    public Bills getBill(int id) {

        String sql = "SELECT * FROM electrogrid_db.bills WHERE id="+id;
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

//                System.out.println("Database successfully get the bill");

            }
        }
        catch (Exception e) {
            System.out.println("Database cannot get bill!!!");
            System.err.println(e.getMessage());
        }

        return b;

    }


    /***
     *
     * This method is used to update bills
     *
     */
    public String updateBill(Bills b1) {

        String sql = "UPDATE electrogrid_db.bills SET invoiceNo=?, accountNo=?, userName=?, email=?, mobileNo=?, home=?, date=?, billAmount=? WHERE id =?";

        String output ="";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, b1.getInvoiceNo());
            st.setString(2, b1.getAccountNo());
            st.setString(3, b1.getUserName());
            st.setString(4, b1.getEmail());
            st.setString(5, b1.getMobileNo());
            st.setString(6, b1.getHome());
            st.setString(7, b1.getDate());
            st.setString(8, b1.getBillAmount());
            st.setInt(9, b1.getId());

            st.executeUpdate();
            System.out.println("Database successfully update the bill");
            output = "Updated Bill Details Saved to the System Successfully";
        }
        catch (Exception e) {
            System.out.println("Database cannot update bills!!!");
            output = "Bill Updated UnSuccessful.....!";
            System.err.println(e.getMessage());
        }

        return output;

    }


    /***
     *
     * This method is used to delete one bill at a time
     *
     */
    public String deleteBill(int id) {

        String sql = "DELETE FROM electrogrid_db.bills WHERE id =?";

        String output ="";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("Database successfully delete the bill");
            output = "Deleted Success";

        }
        catch (Exception e) {
            System.out.println("Database cannot delete the bill!!!");
            output = "Bill Deleted UnSuccessful.....!";
            System.err.println(e.getMessage());
        }

        return output;

    }

}
