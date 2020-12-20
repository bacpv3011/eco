package main;


import javax.swing.JOptionPane;
import javax.swing.JPanel;

import address.AddressController;
import station.UserStationPageController;

public class EcoUserController {
	private AddressController addressController;
	public EcoUserController() {
		addressController = new AddressController();
	}
	
	public JPanel getAddressPane() {
		return addressController.getAddressPane();
	}
	
	public JPanel getStationPage() {
		if(getAddress().equals("")) {
			return getNotice();
		}
		else {
			UserStationPageController controller = new  UserStationPageController(getAddress());
			return controller.getStationPane();
		}

	}

	private JPanel getNotice() {
		JPanel frame = new JPanel();
		 JOptionPane.showMessageDialog(frame,
			    "Quay lại nhập địa chỉ đi",
			    "Từ từ",
			    JOptionPane.ERROR_MESSAGE);
		 return frame;
	}

	public String getAddress() {
		return addressController.getAddress();
	}
	
}
