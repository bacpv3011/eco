package com.eco.component.rentbike.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.eco.app.user.EcoUserController;
import com.eco.bean.Vehicle;
import com.eco.component.rentbike.gui.RentPane;
import com.eco.component.rentbike.gui.RentingDialog;
import com.eco.component.rentbike.gui.RentingPane;


public class RentingController {
	private RentingDialog rentingDialog;
	private RentingPane rentingPane;
    private Vehicle rentingVehicle = new Vehicle();
    private RentPane rentPane;
    private EcoUserController controller;
    public RentingController(EcoUserController controller) {
    	this.controller = controller;
    	rentingPane = new RentingPane(this);
    	rentingDialog = new RentingDialog(this);
    	updateStatus(rentingVehicle);
    }
    
	public void showRentingDialog() {
		rentingDialog.setVisible(true);
	}
	public void closeRentingDialog() {
		rentingDialog.setVisible(false);
	}

	public JPanel getRentingPane() {
		return rentingPane;
	}

	public JPanel getRentPane() {
		if(rentingVehicle.getBarcode() != null) 
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


	public Vehicle searchVehicle(Map<String, String> params) {
		ArrayList<Vehicle> list = controller.searchVehicle(params);
		if(list.isEmpty()) return null;
		return list.get(0);
	}

	public void getHomePage() {
		controller.getHomePage();
		
	}

	public void updateStatus(Vehicle v) {
		rentingVehicle = v;
		rentingPane.updateStatus(rentingVehicle);
    	rentingDialog.updateStatus(rentingVehicle);
	}

	public Vehicle getRentingVehicle() {
		return rentingVehicle;
	}

	public void deleteRentingVehicle() {
		rentingVehicle = new Vehicle();
		updateStatus(rentingVehicle);
	}
}
