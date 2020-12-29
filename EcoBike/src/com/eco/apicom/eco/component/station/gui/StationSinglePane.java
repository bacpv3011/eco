package com.eco.apicom.eco.component.station.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.eco.apicom.eco.component.station.controller.UserStationPageController;
import com.eco.bean.Station;

@SuppressWarnings("serial")
public class StationSinglePane extends JPanel{
	private JLabel nameLabel;
	private JLabel addressLabel;
	private Station station;
    public StationSinglePane() {
    	super();
    }
	public StationSinglePane(UserStationPageController controller) {
		super();
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    	JPanel pane = new JPanel();
    	pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
    	nameLabel = new JLabel();
    	pane.add(nameLabel);
    	addressLabel = new JLabel();
    	pane.add(addressLabel);

    	JButton button1 = new JButton("Xem");
    	pane.add(button1);
    	
    	button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.getDetailStationPage(station);
			}
		});
    	JButton button2 = new JButton("Trả xe");
    	pane.add(button2);
    	
    	button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(controller.checkVehicle()) {
					controller.deleteRentingVehicle();
					JPanel frame = new JPanel();
					add(frame);
					 JOptionPane.showMessageDialog(frame,
						    "Trả xe thành công",
						    "Trả xe",
						    JOptionPane.PLAIN_MESSAGE);
				}else {
					JPanel frame = new JPanel();
					add(frame);
					 JOptionPane.showMessageDialog(frame,
						    "Bạn đã thuê xe đâu",
						    "Từ từ",
						    JOptionPane.ERROR_MESSAGE);
				}
				    
			}
		});
        
    	add(pane);
	}
	public void updateData(Station t) {
		nameLabel.setText("Tên bãi xe : "+t.getName());
		addressLabel.setText("Địa chỉ : "+t.getAddress());
	}
	public void setStation(Station t) {
		this.station = t;
	}

}
