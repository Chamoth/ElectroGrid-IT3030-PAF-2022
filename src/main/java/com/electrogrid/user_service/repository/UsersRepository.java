package com.electrogrid.user_service.repository;

import com.electrogrid.user_service.model.Users;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class UsersRepository {

    Connection con = null;

    public UsersRepository() {

        String url = "jdbc:mysql://localhost:3306/electrogrid_db?useSSL=false";
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

    public List<Users> getUsers(){

        List<Users> users = new ArrayList<>();
        String sql = "SELECT * FROM electrogrid_db.users";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                Users u = new Users();
                u.setUserID(rs.getInt(1));
                u.setAccountNo(rs.getString(2));
                u.setUserName(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setMobileNo(rs.getString(5));
                u.setAddress(rs.getString(6));
                u.setUnits(rs.getString(7));

                users.add(u);
            }
        }
        catch (Exception e) {
            System.out.println("Database cannot get users!!!");
        }

        return  users;
    }

    public Users getUser(int userId) {

        String sql = "SELECT * FROM electrogrid_db.users WHERE userID="+userId;
        Users u = new Users();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if(rs.next()){
                u.setUserID(rs.getInt(1));
                u.setAccountNo(rs.getString(2));
                u.setUserName(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setMobileNo(rs.getString(5));
                u.setAddress(rs.getString(6));
                u.setUnits(rs.getString(7));

            }
        }
        catch (Exception e) {
            System.out.println("Database cannot get users!!!");
        }

        return u;
    }


    public void createUsers(Users u1) {

        String sql = "INSERT INTO electrogrid_db.users VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, u1.getUserID());
            st.setString(2, u1.getAccountNo());
            st.setString(3, u1.getUserName());
            st.setString(4, u1.getEmail());
            st.setString(5, u1.getMobileNo());
            st.setString(6, u1.getAddress());
            st.setString(7, u1.getUnits());

            st.executeUpdate();

        }
        catch (Exception e) {
            System.out.println("Database cannot add user!!!");
        }

    }

    public void updateUser(Users u1) {

        String sql = "UPDATE electrogrid_db.users SET accountNo=?, userName=?, email=?, mobileNo=?, address=?, units=? WHERE userID =?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, u1.getAccountNo());
            st.setString(2, u1.getUserName());
            st.setString(3, u1.getEmail());
            st.setString(4, u1.getMobileNo());
            st.setString(5, u1.getAddress());
            st.setString(6, u1.getUnits());
            st.setInt(7, u1.getUserID());

            st.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Database cannot update Users!!!");
        }
    }

    public void deleteUser(int userId) {

        String sql = "DELETE FROM electrogrid_db.users WHERE userID =?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, userId);
            st.executeUpdate();
            System.out.println("Database successfully delete the user!!!");
        }
        catch (Exception e) {
            System.out.println("Database cannot delete the user!!!");
        }

    }
}
