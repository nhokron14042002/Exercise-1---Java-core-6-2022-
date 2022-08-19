package com.laptrinhjavaweb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.laptrinhjavaweb.constant.SystemConstant;

public class CustomerJdbc {
	
	   static final String DB_URL = "jdbc:mysql://localhost:3306/javasql62022";
	   static final String USER = "root";
	   static final String PASS = "0387002171";

     public static void main(String[] args) {
    	 System.out.println("Connecting to a selected database...");
    	
    	 String fullname = null;
    	 Connection conn = null;
    	 Statement  stmt= null;
    	 ResultSet rs = null;
    	 ResultSetMetaData rsmd = null;
    	 
         // Open a connection
         try {
        	 String sql = "select * from customer" + SystemConstant.ONE_EQUAL_ONE;
        	 
        	 if(fullname !=null && fullname !="") {
        		 sql+= "name like '%"+fullname+"%'";
        	 }
        	 
//        	 if(floorArea!=null) {
//        		 sql+= "and floorarea ="+floorArea+"";
//        	 }
//        	 if(name !=null && name !="") {
//        		 sql+= "and name like '%"+name+"%'";
//        	 }
//        	 if(award !=null && award !="") {
//        		 sql+= "and award like '%"+award+"%'";
//        	 }
//        	 if(street !=null && street !="") {
//        		 sql+= "and street like '%"+street+"%'";
//        	 }
//        	 if(district !=null && district !="") {
//        		 sql+= "and district like '%"+district+"%'";
//        	 }
//        	 
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rsmd = rs.getMetaData();
          while (rs.next()) {
        	  System.out.print("ID: "+rs.getString("id")+ "-type: "+rsmd.getColumnType(1));
        	  System.out.print(", NAME: "+rs.getString("fullname")+"-type: "+rsmd.getColumnType(2));
        	  System.out.println(", PHONE: "+rs.getString("phone")+"-type: "+rsmd.getColumnType(3));
        	  
        	  
          }
           conn.close();
           stmt.close();
           rs.close();
         } catch ( SQLException  e) {
            e.printStackTrace();
         } 
      }
	}

