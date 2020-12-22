package com.eco.apicom.eco.component.station.detailstation.gui;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.eco.bean.Vehicle;

public class DetailBikePane extends JScrollPane{
	private LayoutManager layout;
	protected JPanel pane;
	public DetailBikePane() {
		pane = new JPanel();
		layout = new BoxLayout(pane, BoxLayout.Y_AXIS);
		pane.setLayout(layout);
		
		this.setViewportView(pane);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.getVerticalScrollBar().setUnitIncrement(20);
		this.getHorizontalScrollBar().setUnitIncrement(20);
	}
	public void updateData(List<Vehicle> list) {
		pane.removeAll();
		pane.revalidate();
		pane.repaint();
		
		for (Vehicle t: list) {
			JPanel singlePane= new JPanel();
			decorate(singlePane,t);
            pane.add(singlePane);
            pane.add(Box.createRigidArea(new Dimension(0, 40)));
        }
	}
	private void decorate(JPanel singlePane, Vehicle t) {
		singlePane.setLayout(new BoxLayout(singlePane, BoxLayout.Y_AXIS));
		singlePane.add(new JLabel("Name : "+t.getName()));
		singlePane.add(new JLabel("Type of Bike : "+t.getTypeBike()));
		singlePane.add(new JLabel("Weight : "+t.getWeight()));
		singlePane.add(new JLabel("Cost : "+t.getCost()));
		singlePane.add(new JLabel("license plate : "+t.getLicensePlate()));
		singlePane.add(new JLabel("Manuafacturing date : "+t.getManuafacturingDate()));
		singlePane.add(new JLabel("Producer : "+t.getProducer()));
	}
}
