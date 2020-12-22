package com.eco.app.user;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import com.eco.api.EcoApi;
import com.eco.apicom.eco.component.station.controller.UserStationPageController;
import com.eco.bean.Station;
import com.eco.bean.Vehicle;
import com.eco.component.rentbike.controller.RentingController;

public class EcoUserController {
	private EcoUser user;
	private UserStationPageController userStationPagecontroller ;
	private RentingController rentingController;
	public EcoUserController() {
	}
	
	public void getStationPage() {
		if(userStationPagecontroller == null)
		    userStationPagecontroller = new  UserStationPageController(this);
		addPanel(userStationPagecontroller.getStationPane());
	}

	public void addPanel(JPanel pane) {
		user.addPanel(pane);
	}
	public void setUser(EcoUser user) {
		this.user = user;
	}

	public JPanel getRentingPane() {
		if(rentingController == null)
		    rentingController = new RentingController(this);
		return rentingController.getRentingPane();
	}

	public void getRentPage() {
		if(rentingController.getRentPane() != null)
		addPanel(rentingController.getRentPane());
	}

	public ArrayList<Vehicle> searchVehicle(Map<String, String> params) {
		ArrayList<Vehicle> list = new EcoApi().getVehicles(params);
		return list;
	}

	public List<Station> searchStation(Map<String, String> queryParams) {
		List<Station> list = new EcoApi().getStations(queryParams);
		return list;
	}
	
	public void getHomePage() {
		user.repaint();
		user.getHomePage();
	}

	public boolean checkVehicle() {
		System.out.println(rentingController.getVehicle().getVehicle().getBarcode());
		if(rentingController.getVehicle().getVehicle().getBarcode() == null)
		    return false;
		return true;
	}

	public void updateReturnVehicle() {
		rentingController.getVehicle().setVehicle(null);	
	}
	
}
