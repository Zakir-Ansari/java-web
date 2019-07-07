package com.feereport.dao;


import java.sql.DriverManager;
import com.mysql.jdbc.Connection;


public class DB {
	public static Connection getCon() {
		java.sql.Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/fee_management", "root", "Zakir@12345");
		}
		catch (Exception e) {
			// Handle errors for Class.forName
			System.out.println("Error while connecting to database..");
			e.printStackTrace();
		}	
		return (Connection) connection;
	}
}

