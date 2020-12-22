package com.eco.component.rentbike.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.eco.app.user.EcoUserController;
import com.eco.bean.RentingVehicle;
import com.eco.bean.Vehicle;
import com.eco.component.rentbike.gui.RentPane;
import com.eco.component.rentbike.gui.RentingDialog;
import com.eco.component.rentbike.gui.RentingPane;


public class RentingController {
	private RentingDialog rentingDialog;
	private RentingPane rentingPane;
    private RentingVehicle vehicle;
    private RentPane rentPane;
    private EcoUserController controller;
    public RentingController(EcoUserController controller) {
    	this.controller = controller;
    	
    	if(rentingPane == null)
    	    rentingPane = new RentingPane(this);
    	
    	
    	vehicle = new RentingVehicle();
    	
    }
    
	public void showRentingDialog() {
		if(rentingDialog == null)
        	rentingDialog = new RentingDialog();
		rentingDialog.setController(this);
		rentingDialog.setVisible(true);
	}
	public void closeRentingDialog() {
		rentingDialog.setVisible(false);
	}

	public JPanel getRentingPane() {
		return rentingPane;
	}

	public JPanel getRentPane() {
		if(this.vehicle.getVehicle().getBarcode() != null) 
			return getNotice();
		return new RentPane(this);
	}

	private JPanel getNotice() {
		JPanel frame = new JPanel();
		 JOptionPane.showMessageDialog(frame,
			    "Thuê xe rồi mà",
			    "Từ từ",
			    JOptionPane.ERROR_MESSAGE);
		 return null;
	}

	public RentingVehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(RentingVehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Vehicle searchVehicle(Map<String, String> params) {
		ArrayList<Vehicle> list = controller.searchVehicle(params);
		if(list.isEmpty()) return null;
		return list.get(0);
	}

	public void getHomePage() {
		controller.getHomePage();
		
	}

	public void updateStatus(Vehicle v) {
		this.vehicle.setVehicle(v);
    	rentingPane.updateStatus(this.vehicle);
    	if(rentingDialog == null)
        	rentingDialog = new RentingDialog();
    	rentingDialog.updateStatus(this.vehicle.getVehicle());
	}
}
