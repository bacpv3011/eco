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
    private Vehicle rentingVehicle;
    private RentPane rentPane;
    private EcoUserController controller;
    public RentingController(EcoUserController controller) {
    	this.controller = controller;
    	rentingVehicle = new Vehicle("");
    	if(rentingPane == null)
    	    rentingPane = new RentingPane(this);
    	
    	
    	
    	
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
		if(!this.rentingVehicle.getBarcode().equals("")) 
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
		if(v.getBarcode().equals("")) {
			v = null;
		}
		rentingPane.updateStatus(v);
    	if(rentingDialog == null)
        	rentingDialog = new RentingDialog();
    	rentingDialog.updateStatus(v);
	}

	public Vehicle getRentingVehicle() {
		return rentingVehicle;
	}

	public void setRentingVehicle(Vehicle rentingVehicle) {
		this.rentingVehicle = rentingVehicle;
	}
}
