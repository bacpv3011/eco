package com.eco.component.rentbike.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.eco.bean.Vehicle;
import com.eco.component.rentbike.controller.RentingController;

@SuppressWarnings("serial")
public class RentingPane extends JPanel{
    private JLabel statusLabel;
    public RentingPane(RentingController controller) {
    	this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    	
    	JPanel panel1 = new JPanel();
    	panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
        
    	statusLabel = new JLabel();
        JButton change = new JButton("Xe đang thuê");
        change.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.showRentingDialog();
			}
		});

        panel1.add(change);
        panel1.add(Box.createRigidArea(new Dimension(10, 0)));
        panel1.add(statusLabel);
        
        add(panel1);
    	
    	
    }
	public void updateStatus(Vehicle vehicle) {
		statusLabel.setText("Xe đang thuê : ");
		if(vehicle != null)
		statusLabel.setText("Xe đang thuê : "+ vehicle.getName());
	}

}
