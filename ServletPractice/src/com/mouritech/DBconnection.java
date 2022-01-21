package com.mouritech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection {
	static Connection conn; // = null;
	static Statement stmt; // = null;

	public static Connection getDBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// step 2 => Establish the connection to DB
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/product", "root", "root");

		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return conn;
	}
}