package com.electrogrid.power_consumption.repository;

import com.electrogrid.power_consumption.model.PowerConsumption;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class PowerConsumptionRepository {


    //Creating the Database Connection
    Connection con = null;

    public PowerConsumptionRepository() {

        String url = "jdbc:mysql://localhost:3306/electrogrid_db";
        String userName = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, userName, password);

            System.out.println("Database is successfully Connected!!!");
        }
        catch (Exception e) {
            System.out.println("Error while Connecting to database!!");
        }
    }

    //Implementing a method for retrive data for display
    public List<PowerConsumption> getPowerConsumptions(){

        List<PowerConsumption> powerCon = new ArrayList<>();
        String sql = "SELECT * FROM electrogrid_db.powercon";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                PowerConsumption pc = new PowerConsumption();
                pc.setId(rs.getInt(1));
                pc.setAccountNo(rs.getString(2));
                pc.setInvoiceNo(rs.getString(3));
                pc.setUserName(rs.getString(4));
                pc.setUsedUnit(rs.getInt(5));
                pc.setTotalCost(rs.getFloat(6));

                powerCon.add(pc);
            }
        }
        catch (Exception e) {
            System.out.println("Error while fetching data!");
        }

        return  powerCon;
    }


    //Implementing a method for retrive data for search operation
    public PowerConsumption getPowerConsumption(int id) {

        String sql = "SELECT * FROM electrogrid_db.powercon WHERE id="+id;
        PowerConsumption pc = new PowerConsumption();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if(rs.next()){
                pc.setId(rs.getInt(1));
                pc.setAccountNo(rs.getString(2));
                pc.setInvoiceNo(rs.getString(3));
                pc.setUserName(rs.getString(4));
                pc.setUsedUnit(rs.getInt(5));
                pc.setTotalCost(rs.getFloat(6));

            }
        }
        catch (Exception e) {
            System.out.println("Error in Serching data!!!");
        }

        return pc;
    }

    //Implementing a method for Create data for Create Operation
    public void createPowerConsumption(PowerConsumption pc1) {

        String sql = "INSERT INTO electrogrid_db.powercon VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, pc1.getId());
            st.setString(2, pc1.getAccountNo());
            st.setString(3, pc1.getInvoiceNo());
            st.setString(4, pc1.getUserName());
            st.setInt(5, pc1.getUsedUnit());
            st.setFloat(6, pc1.getTotalCost());

            st.executeUpdate();

        }
        catch (Exception e) {
            System.out.println("adding data into database went wrong!");
        }

    }

    //Implementing a method for update data for update operation
    public void updatePowerConsumption(PowerConsumption pc1) {

        String sql = "UPDATE electrogrid_db.powercon SET accountNo=?, invoiceNo=?, usedUnits=?, totalCost=?, WHERE id =?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, pc1.getAccountNo());
            st.setString(2, pc1.getInvoiceNo());
            st.setString(3, pc1.getUserName());
            st.setInt(4, pc1.getUsedUnit());
            st.setFloat(5, pc1.getTotalCost());


            st.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Database cannot update Power Consumption details !");
        }
    }

    //Implementing a method for Delete data for delete operation
    public void deletePowerConsumption(int id) {

        String sql = "DELETE FROM electrogrid_db.powercon WHERE id =?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("Successfully deleted the Power Consumption Entry!!!");
        }
        catch (Exception e) {
            System.out.println("Error While Deleting !");
        }

    }
}
