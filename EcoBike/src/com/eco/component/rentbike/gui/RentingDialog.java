package com.eco.component.rentbike.gui;

import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.eco.bean.Vehicle;
import com.eco.component.rentbike.controller.RentingController;

@SuppressWarnings("serial")
public class RentingDialog extends JDialog {
    private RentingController controller;
	private JLabel statusLabel;
	private JPanel panel = new JPanel();
	private JLabel nameLabel = new JLabel();
	private JLabel typeLabel = new JLabel();
	private JLabel weightLabel = new JLabel();
	private JLabel costLabel = new JLabel();
	private JLabel lienceLabel = new JLabel();
	private JLabel manuafLabel = new JLabel();
	private JLabel producerLabel = new JLabel();
    public RentingDialog(RentingController controller) {
    	this.controller = controller;
    	this.setTitle("Xe đang thuê");
    	this.setMinimumSize(new Dimension(400,150));
    	statusLabel = new JLabel();
    	this.revalidate();
		this.repaint();
		this.pack();
		this.setResizable(false);
     }

	public void updateStatus(Vehicle vehicle) {
		this.add(panel);
		panel.repaint();
		panel.revalidate();
		panel.removeAll();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		statusLabel.setText("Empty!!!!!!");
		panel.add(statusLabel);
		if(vehicle.getBarcode() == null) return;
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
	}
}