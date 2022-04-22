package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PowerConsumption {
	
	//Database Connection
	private Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ElectroGrid", "root", "");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//Insert data into database - Create Operation
	public String insertPowerConsumption( String billId, int usedUnits) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into notices (`billId`,`usedUnits`,`unitCost`)"
					+ " values (?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setInt(2, usedUnits);
			preparedStmt.setString(3, unitCost);
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the notices.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
}
