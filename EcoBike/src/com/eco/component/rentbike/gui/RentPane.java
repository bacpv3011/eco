package com.eco.component.rentbike.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import com.eco.bean.Vehicle;
import com.eco.component.rentbike.controller.RentingController;

public class RentPane extends JPanel{
	private JTextField barcodeField;
	private JPanel panel;
	private JLabel statusLabel;
	private JLabel nameLabel = new JLabel();
	private JLabel typeLabel = new JLabel();
	private JLabel weightLabel = new JLabel();
	private JLabel costLabel = new JLabel();
	private JLabel lienceLabel = new JLabel();
	private JLabel manuafLabel = new JLabel();
	private JLabel producerLabel = new JLabel();
	private JButton rentButton = new JButton("Thuê Xe");
	private JButton acceptButton = new JButton("Xác nhận");
	
	private RentingController controller;
    public RentPane(RentingController controller) {
    	this.controller = controller;
    	JPanel pane1 = new JPanel();
    	panel = new JPanel();
    	this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    	pane1.setLayout(new BoxLayout(pane1,BoxLayout.X_AXIS));
    	pane1.add(new JLabel("Nhập mã xe:"));
    	barcodeField = new JTextField();
    	barcodeField.setMaximumSize(new Dimension(300,30));
    	pane1.add(barcodeField);
    	
    	statusLabel = new JLabel();
    	
    	pane1.setMaximumSize(new Dimension(400,80));
    	
    	acceptButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!barcodeField.getText().trim().equals("")) {
					Map<String, String> params = new HashMap<String, String>();
					params.put("barcode", barcodeField.getText());
					updateData(controller.searchVehicle(params));
				}
			}
		});
    	JButton home = new JButton("Home");
    	
    	add(home);
    	this.add(pane1);
    	add(acceptButton);
    	add(statusLabel);
    	statusLabel = new JLabel();
    	add(statusLabel);
    	pane1.setMaximumSize(new Dimension(400,80));
    	
    	home.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				controller.getHomePage();
			}
		});
    }
	protected void updateData(Vehicle vehicle) {
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.add(panel);
		if(vehicle == null) {
			panel.setVisible(false);
			statusLabel.setText("Check lại mã xem nào");
		}
		else {
			controller.updateStatus(vehicle);
			panel.setVisible(true);
			statusLabel.setText("");
			nameLabel.setText("Name : "+vehicle.getName());
	    	panel.add(nameLabel);
	    	typeLabel.setText("Type of Bike : "+vehicle.getTypeBike());
	    	panel.add(typeLabel);
	    	weightLabel.setText("Weight : "+vehicle.getWeight());
	    	panel.add(weightLabel);
	    	costLabel.setText("Cost : "+vehicle.getCost());
	    	panel.add(costLabel);
	    	lienceLabel.setText("license plate : "+vehicle.getLicensePlate());
	    	panel.add(lienceLabel);
	    	manuafLabel.setText("Manuafacturing date : "+vehicle.getManuafacturingDate());
	    	panel.add(manuafLabel);
	    	producerLabel.setText("Producer : "+vehicle.getProducer());
	    	panel.add(producerLabel);
	    	panel.add(rentButton);
	    	rentButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JPanel frame = new JPanel();
					if(vehicle.getTypeBike().equals("bike")) {
						 JOptionPane.showMessageDialog(frame,
							    "normal-bike : hết 400k",
							    "Nộp tiền cọc nào",
							    JOptionPane.PLAIN_MESSAGE);
					}
					else if(vehicle.getTypeBike().equals("ebike")) {
						JOptionPane.showMessageDialog(frame,
								"E-bike : hết 700k",
							    "Nộp tiền cọc nào",
							    JOptionPane.PLAIN_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(frame,
								"normal-bike : hết 550k",
							    "Nộp tiền cọc nào",
							    JOptionPane.PLAIN_MESSAGE);
					}
					controller.updateStatus(vehicle);
					remove(acceptButton);
					panel.remove(rentButton);
					repaint();
				}
			});
		}
	}
}
