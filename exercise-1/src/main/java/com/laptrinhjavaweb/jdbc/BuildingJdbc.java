package com.laptrinhjavaweb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.utils.ConnectionUtils;
import com.laptrinhjavaweb.utils.StringUtils;

public class BuildingJdbc {
//	
//	   static final String DB_URL = "jdbc:mysql://localhost:3306/javasql62022";
//	   static final String USER = "root";
//	   static final String PASS = "0387002171";

     public static void main(String[] args) {
    	 System.out.println("Connecting to a selected database...");
    	 Integer floorArea =null;
    	 String name = null;
    	 String award = null;
    	 String street = null;
    	 String district = null;
    	 Connection conn = null;
    	 Statement  stmt= null;
    	 ResultSet rs = null;
    	 ResultSetMetaData rsmd = null;
    	 
         // Open a connection
         try {
//        	 String sql = "select * from building "+ SystemConstant.ONE_EQUAL_ONE;
        	 StringBuilder sql = new StringBuilder("select * from building where 1=1 ");
        	  
        	 if(floorArea!=null) {
//        		 sql+= "and floorarea ="+floorArea+"";
        		 sql.append("and floorarea ="+floorArea+"");
        	 }
        	 if(!StringUtils.isNullOrEmpty(name)) {
//        		 sql+= "and name like '%"+name+"%'";
        		 sql.append("and name like '%"+name+"%'");
        	 }
        	 if(!StringUtils.isNullOrEmpty(award)) {
//        		 sql+= "and award like '%"+award+"%'";
        		 sql.append("and award like '%"+award+"%'");
        	 }
        	 if(!StringUtils.isNullOrEmpty(street)) {
//        		 sql+= "and street like '%"+street+"%'";
        		 sql.append("and street like '%"+street+"%'");
        	 }
        	 if(!StringUtils.isNullOrEmpty(district)) {
//        		 sql+= "and district like '%"+district+"%'";
        		 sql.append("and district like '%"+district+"%'");
        	 }
        	 
            conn = ConnectionUtils.getConnection();
            stmt = conn.createStatement();
//            rs = stmt.executeQuery(sql);
            rs = stmt.executeQuery(sql.toString());
            rsmd = rs.getMetaData();
          while (rs.next()) {
        	  System.out.print("ID: "+rs.getString("id")+ "-type: "+rsmd.getColumnType(1));
        	  System.out.print(", NAME: "+rs.getString("name")+"-type: "+rsmd.getColumnType(2));
        	  System.out.println(", STREET: "+rs.getString("street")+"-type: "+rsmd.getColumnType(3));
        	  
        	  
          }
           conn.close();
           stmt.close();
           rs.close();
         } catch ( SQLException  e) {
            e.printStackTrace();
         } 
      }
	}

