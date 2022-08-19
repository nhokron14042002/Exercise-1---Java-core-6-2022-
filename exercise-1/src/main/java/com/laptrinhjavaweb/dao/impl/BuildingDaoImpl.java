package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dao.BuildingDao;
import com.laptrinhjavaweb.dao.anhyeuem.BuildingAnhyeuem;
import com.laptrinhjavaweb.utils.ConnectionUtils;
import com.laptrinhjavaweb.utils.StringUtils;

public class BuildingDaoImpl implements BuildingDao {

	@Override
	public  List<BuildingAnhyeuem> findBuilding(Integer floorArea, String name, String award, String street, String district,String type) {
		// TODO Auto-generated method stub
//		BuildingAnhyeuem[] results = new BuildingAnhyeuem[2];
		
		 List<BuildingAnhyeuem> results = new ArrayList<>();
		 Connection conn = null;
    	 Statement  stmt= null;
    	 ResultSet rs = null;
//    	 ResultSetMetaData rsmd = null;
    	 
         // Open a connection
         try {
//        	 String sql = "select * from building "+ SystemConstant.ONE_EQUAL_ONE;
        	 StringBuilder sql = new StringBuilder("select * from building");
        	  
        	 if(floorArea!=null) {
//        		 sql+= "and floorarea ="+floorArea+"";
        		 sql.append(" floorarea ="+floorArea+"");
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
        	 if(!StringUtils.isNullOrEmpty(type)) {
//        		 sql+= "and district like '%"+district+"%'";
        		 sql.append("and district like '%"+type+"%'");
        	 }
        	 
            conn = ConnectionUtils.getConnection();
            stmt = conn.createStatement();
//            rs = stmt.executeQuery(sql);
            rs = stmt.executeQuery(sql.toString());
//            rsmd = rs.getMetaData();
//            int i=0;
            while (rs.next()) {
        	 BuildingAnhyeuem buildingAnhyeuem = new BuildingAnhyeuem();
        	 buildingAnhyeuem.setName(rs.getString("name"));
        	 buildingAnhyeuem.setStreet(rs.getNString("street"));
        	 buildingAnhyeuem.setAward(rs.getString("award"));
        	 buildingAnhyeuem.setDistrict(rs.getString("district"));
        	 buildingAnhyeuem.setFloorArea(rs.getInt("floorarea"));
        	 buildingAnhyeuem.setType(rs.getString("type"));
        	 
//        		results[i]= buildingAnhyeuem;
//        		i++;
        	  results.add(buildingAnhyeuem);
        	  
          }
           conn.close();
           stmt.close();
           rs.close();
         } catch ( SQLException  e) {
            e.printStackTrace();
         } catch ( Exception  e) {
             e.printStackTrace();
         }
		return new ArrayList<>();
	}
    
}
