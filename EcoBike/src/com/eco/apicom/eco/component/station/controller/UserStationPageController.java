package com.eco.apicom.eco.component.station.controller;

import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import com.eco.api.EcoApi;
import com.eco.apicom.eco.component.station.detailstation.controller.DetailStationPageController;
import com.eco.apicom.eco.component.station.detailstation.gui.DetailStationPage;
import com.eco.apicom.eco.component.station.gui.StationListPane;
import com.eco.apicom.eco.component.station.gui.StationPagePane;
import com.eco.apicom.eco.component.station.gui.StationSearchPane;
import com.eco.apicom.eco.component.station.gui.StationSinglePane;
import com.eco.app.user.EcoUserController;
import com.eco.bean.Station;
import com.eco.bean.Vehicle;

public class UserStationPageController {

    private StationPagePane pagePane;
    private StationListPane listPane;
    private StationSearchPane searchPane;
    private DetailStationPage detailStationPage;
    private DetailStationPageController detailStationPageController;
    private EcoUserController ecoUserController;
	public UserStationPageController() {
		super();
    }
	public UserStationPageController(EcoUserController ecoUserController) {
		super();
		this.ecoUserController = ecoUserController;
		listPane = new StationListPane();
		searchPane = new StationSearchPane();
		
		listPane.setController(this);
		searchPane.setController(this);

		searchPane.addressSearch(null);
		pagePane = new StationPagePane(listPane,searchPane);
	}
	public JPanel getStationPane() {
		pagePane.setVisible(true);
		return pagePane;
	}
	
	public void search(Map<String, String> queryParams) {
		List<Station> list = ecoUserController.searchStation(queryParams);
		listPane.updateData(list);
	}

	public StationSinglePane createSinglePane() {
		return new StationSinglePane(this);
	}
	public void getDetailStationPage(Station s) {
		detailStationPageController = new DetailStationPageController(this,s.getId());
		detailStationPage = new DetailStationPage(detailStationPageController);
		detailStationPage.updateData(s);
		ecoUserController.addPanel(detailStationPage);
	}
	public List<Vehicle> searchVehicle(Map<String, String> params) {
		List<Vehicle> list = ecoUserController.searchVehicle(params);
		return list;
	}
	public void deleteRentingVehicle() {
		ecoUserController.deleteRentingVehicle();
	}
	public boolean checkVehicle() {
		
		return ecoUserController.checkVehicle();
	}
	public void getHomePage() {
		pagePane.setVisible(false);
		ecoUserController.getHomePage();
	}

}
