package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection getC() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			PGSimpleDataSource ds = new PGSimpleDataSource();
//			ds.setUrl("jdbc:postgresql://nurse-pegasus-1694.7s5.cockroachlabs.cloud:26257/defaultdb?sslmode=verify-full");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mentor_mentee?useSSL=false&allowPublicKeyRetrieval=true", "root", "Mysql@123");			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
}
