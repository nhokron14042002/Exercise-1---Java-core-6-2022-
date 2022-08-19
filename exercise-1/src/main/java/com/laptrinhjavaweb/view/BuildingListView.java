package com.laptrinhjavaweb.view;

import java.util.List;

import com.laptrinhjavaweb.controller.BuildingController;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.input.BuildingSearchInput;
import com.laptrinhjavaweb.output.BuildingOutput;

public class BuildingListView {
	
	
	public static void main(String[] args) {
		Integer floorArea =null;
		 String name = null;
		 String award = null;
		 String street = null;
		 String district = null;
		 String type = null;
		 
//	 BuildingSearchInput:dữ liệu đầu vào     BuildingSearchInput 
		 BuildingSearchInput buildingSearch = new BuildingSearchInput();
		 buildingSearch.setFloorArea(floorArea);
		 buildingSearch.setName(name);
		 buildingSearch.setAward(award);
		 buildingSearch.setStreet(street);
		 buildingSearch.setDistrict(district);
		 buildingSearch.setType(type);
		 
		 
		 BuildingController buildingController = new BuildingController();
		// BuildingOutput: đầu ra
     	   List<BuildingOutput> buildings = buildingController.findBuilding(buildingSearch);
     	   System.out.println("test");
     	  for ( BuildingOutput item:buildings) {
     		  
     		System.out.println(item);  
     	  }

	}
	 
	 
}
