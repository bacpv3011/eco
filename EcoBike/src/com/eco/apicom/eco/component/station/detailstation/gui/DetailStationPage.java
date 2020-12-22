package com.eco.apicom.eco.component.station.detailstation.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import com.eco.apicom.eco.component.station.detailstation.controller.DetailStationPageController;
import com.eco.bean.Station;

public class DetailStationPage extends JPanel{
    private JLabel nameLabel;
    private JLabel addressLabel;
    private JLabel noBikeLabel;
    private JLabel noEBikeLabel;
    private JLabel noTBikelabel;
    private JLabel noEDockLabel;
    
	public DetailStationPage(DetailStationPageController controller) {
		JScrollPane scrollPane ;
		JPanel pane = new JPanel();


		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
		pane.setAlignmentX(Component.CENTER_ALIGNMENT);
		nameLabel = new JLabel();
		addressLabel = new JLabel();
		noBikeLabel = new JLabel();
		noEBikeLabel = new JLabel();
		noTBikelabel = new JLabel();
		noEDockLabel = new JLabel();
		JButton homeButton = new JButton("Home");
		add(homeButton);
		homeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				controller.getHomePage();
			}
		});
		pane.add(nameLabel);
		pane.add(addressLabel);
		pane.add(noBikeLabel);
		pane.add(noEBikeLabel);
		pane.add(noTBikelabel);
		pane.add(noEDockLabel);
		
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		scrollPane = controller.getDetailBikePane();
				
		this.add(pane);
		this.add(scrollPane);
		
		
		layout.putConstraint(SpringLayout.WEST, pane, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, pane, 5, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, pane, -5, SpringLayout.EAST, this);
		
		
		layout.putConstraint(SpringLayout.WEST, scrollPane, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scrollPane, 5, SpringLayout.SOUTH, pane);
		layout.putConstraint(SpringLayout.EAST, scrollPane, -5, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.SOUTH, scrollPane, -5, SpringLayout.SOUTH, this);
	}

	public void updateData(Station s) {
		nameLabel.setText(s.getName());
		addressLabel.setText("Address : " + s.getAddress());
		noBikeLabel.setText("number of Bikes : " +s.getNumberOfBikes());
		noEBikeLabel.setText("number of EBikes : " +s.getNumberOfEBikes());
		noTBikelabel.setText("number of TwinBikes : " +s.getNumberOfTwinBikes());
		noEDockLabel.setText("number of empty Docks : "+ s.getNumberOfEmptyDocks());
	}

}
