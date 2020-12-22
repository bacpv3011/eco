package com.eco.apicom.eco.component.station.detailstation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JScrollPane;

import com.eco.apicom.eco.component.station.controller.UserStationPageController;
import com.eco.apicom.eco.component.station.detailstation.gui.DetailBikePane;
import com.eco.bean.Vehicle;

public class DetailStationPageController {
    private DetailBikePane detailBikePane;
    private String stationId;
    private UserStationPageController controller;
	public DetailStationPageController(UserStationPageController controller, String id) {
		this.stationId = id;
		this.controller = controller;
		detailBikePane = new DetailBikePane();
		updateData();
	}

	private void updateData() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("title", stationId);
		List<Vehicle> list= controller.searchVehicle(params);
		detailBikePane.updateData(list);
	}

	public JScrollPane getDetailBikePane() {
		return detailBikePane;
	}

	public void getHomePage() {
		controller.getHomePage();
		
	}
    

}
