package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
	
	public String insertPowerConsumption( int usedUnits, Float unitCost) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into powerCon (`billId`,`usedUnits`,`unitCost`)"
					+ " values (?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setInt(2, usedUnits);
			preparedStmt.setFloat(3, unitCost);
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the powerConsumption.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	//Read data from database - Read Operation
	
			public String readPowerConsumption() {
				String output = "";

				try {
					Connection con = connect();

					if (con == null) {
						return "Error while connecting the database for reading";
					}

					output = "<table border=\"1\"><tr><th>usedUnits</th><th>unitCost</th></tr>";

					String query = "select * from powerCon";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(query);

					while (rs.next()) {
						String billId = Integer.toString(rs.getInt("billId"));
						int usedUnits = rs.getInt("usedUnits");
						Float unitCost = rs.getFloat("unitCost");

						output += "<tr><td>" + usedUnits + "</td>";
						output += "<td>" + unitCost + "</td>";
						

						output += "<td><input name=\"btnUpdate\" type =\"button\" value = \"Update\" class = \"btn btn-secondary\"></td>"
								+ "<td><form method=\"post\" action=\"Notice.jsp\">"
								+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"
								+ "<input name=\"unitCost\" type=\"hidden\" value=\"" + billId + "\">" + "</form></td></tr>";

					}
					con.close();
					
					output += "</table>";
				} catch (Exception e) {
					output = "Error while reading PowerConsumption";
					System.err.println(e.getMessage());
				}
				return output;
			}

			
			//Update the database - Update Operation
			public String updatePowerConsumption(String billId, int usedUnits, float unitCost)
					{
				String output = "";
				try {
					Connection con = connect();
					if (con == null) {
						return "Error while connecting to the database for updating.";
					}
					// create a prepared statement
					String query = "UPDATE powerCon SET usedUnits=?,unitCost=?  WHERE billId=?";

					PreparedStatement preparedStmt = con.prepareStatement(query);
					// binding values
					preparedStmt.setInt(1, usedUnits);
					preparedStmt.setFloat(2, unitCost);
				    preparedStmt.setInt(3, Integer.parseInt(billId));
					// execute the statement
					preparedStmt.execute();
					con.close();
					output = "Updated successfully";
				} catch (Exception e) {
					output = "Error while updating the Power Consumption.";
					System.err.println(e.getMessage());
				}
				return output;
			}
		
			//Delete entry from the database - Delete Operation

			public String deleteNotice(String billId) {
				String output = "";
				try {
					Connection con = connect();
					if (con == null) {
						return "Error while connecting to the database for deleting.";
					}
					// create a prepared statement
					String query = "delete from powerCon where billId=?";
					PreparedStatement preparedStmt = con.prepareStatement(query);
					// binding values
					preparedStmt.setInt(1, Integer.parseInt(billId));
					// execute the statement
					preparedStmt.execute();
					con.close();
					output = "Deleted successfully";
				} catch (Exception e) {
					output = "Error while deleting a Power consumption.";
					System.err.println(e.getMessage());
				}
				return output;
			}
	
	
}
