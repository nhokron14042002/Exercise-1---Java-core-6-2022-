package com.laptrinhjavaweb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

	 private  static  String DB_URL = "jdbc:mysql://localhost:3306/javasql62022";
	 private  static  String USER = "root";
	 private  static  String PASS = "0387002171";
	 
	 
	 public static Connection getConnection() {
		 Connection conn = null;
		 
		 try {
			 conn=DriverManager.getConnection(DB_URL, USER, PASS);
			 return conn;
		} catch (SQLException e) {
			// TODO: handle exception
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	 }
}
