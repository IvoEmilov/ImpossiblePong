package MainPackage;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class PointsPanel extends JLayeredPane {
	PointsPanel(){
		this.setPreferredSize(new Dimension(1400,200));
		this.setLayout(null);
		this.setBackground(Color.DARK_GRAY);
		this.setOpaque(true);	
		
	}

}
