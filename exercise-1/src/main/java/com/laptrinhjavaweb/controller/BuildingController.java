package com.laptrinhjavaweb.controller;

import java.util.List;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.input.BuildingSearchInput;
import com.laptrinhjavaweb.output.BuildingOutput;
import com.laptrinhjavaweb.service.BuildingService;
import com.laptrinhjavaweb.service.impl.BuildingServiceImpl;

public class BuildingController {
       
	private BuildingService buildingService = new BuildingServiceImpl();
      //BuildingOutput: đầu ra            // BuildingSearchInput:dữ liệu đầu vào
	public  List <BuildingOutput> findBuilding (BuildingSearchInput buildingSearch){
  	    // BuildingOutput: đầu ra
		
		 List<BuildingOutput> results =buildingService.findBuilding(buildingSearch);
		 return results;
	}  
	// THÊM TÒA NHÀ MỚI 
	public BuildingDTO insert (BuildingDTO newBuilding) {
		return null;
	}
}
