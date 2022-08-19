package com.laptrinhjavaweb.view;

import com.laptrinhjavaweb.controller.BuildingController;
import com.laptrinhjavaweb.dto.BuildingDTO;

public class BuildingEditView {
       
	private static BuildingController buildingController = new BuildingController();
	public static void main(String[] args) {
		BuildingDTO newBuildingDTO = new BuildingDTO();
		buildingController.insert(newBuildingDTO);
	}
}
