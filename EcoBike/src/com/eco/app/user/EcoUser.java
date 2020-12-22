package com.eco.app.user;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class EcoUser extends JFrame {
	private JPanel  current;
	public static final int WINDOW_WIDTH = 300;
	public static final int WINDOW_HEIGHT = 350;
	private EcoUserController controller;
	public EcoUser(EcoUserController controller) {
		this.controller = controller;
		getHomePage();
	}

	public void getHomePage() {
		JPanel panel = new JPanel();
		JLabel jLabel1 = new JLabel();
		JButton jButton2 = new JButton();
		JButton jButton3 = new JButton();
		
        jLabel1.setIcon(new ImageIcon(getClass().getResource("/image/images.png")));
	    jButton2.setText("Thuê xe");
        jButton3.setText("Tìm kiếm bãi xe");
        current = panel;
        this.add(current);
        panel.setMinimumSize(new Dimension(400,400));
        panel.setLayout( new BoxLayout(panel,BoxLayout.Y_AXIS));
        
        JPanel bottom = controller.getRentingPane();
        
        panel.add(bottom);
        
        JPanel center = new JPanel();
        center.setLayout( new BoxLayout(center,BoxLayout.Y_AXIS));
        center.setAlignmentX(Component.CENTER_ALIGNMENT);
        center.add(jLabel1);
        
        panel.add(center);
        center.add(Box.createRigidArea(new Dimension(0,10)));
        
        JPanel up = new JPanel();
        up.setLayout( new BoxLayout(up,BoxLayout.X_AXIS));
        up.setAlignmentX(Component.CENTER_ALIGNMENT);
        up.add(jButton3);
        up.add(Box.createRigidArea(new Dimension(15, 0)));
        up.add(jButton2);

        panel.add(up);
        
        jButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.getStationPage();
				
			}
		});
        jButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.getRentPage();
			}
		});
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("EcoBike");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setVisible(true);
		
	}

	protected void addPanel(JPanel pane) {
		current.setVisible(false);
		add(pane);
		current = pane;
	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				EcoUserController controller = new EcoUserController();
			    controller.setUser(new EcoUser(controller));
			}
		});
	}
}