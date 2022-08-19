package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.dao.anhyeuem.BuildingAnhyeuem;

public interface BuildingDao {
   
   List<BuildingAnhyeuem>findBuilding(Integer floorArea ,String name , String award,String street , String district,String type);
	
}
