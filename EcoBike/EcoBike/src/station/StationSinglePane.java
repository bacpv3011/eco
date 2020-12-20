package station;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.eco.bean.Station;

@SuppressWarnings("serial")
public class StationSinglePane extends JPanel{
	@SuppressWarnings("unused")
	private UserStationPageController controller;
	private JLabel nameLabel;
	private JLabel addressLabel;
    public StationSinglePane() {
    	super();
    }
	public StationSinglePane(UserStationPageController controller) {
		super();
		this.controller = controller;
		this.setBackground(Color.green);
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    	JPanel pane = new JPanel();
    	pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
    	nameLabel = new JLabel();
    	pane.add(nameLabel);
    	addressLabel = new JLabel();
    	pane.add(addressLabel);

    	JButton button1 = new JButton("Xem");
    	pane.add(button1);
    	
    	add(pane);
	}
	public void updateData(Station t) {
		nameLabel.setText("Tên bãi xe : "+t.getName());
		addressLabel.setText("Địa chỉ : "+t.getAddress());
	}

}
