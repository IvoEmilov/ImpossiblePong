package MainPackage;

import java.awt.Color;

import javax.swing.JLabel;

public class Paddle extends JLabel{
	int x=100,y=225;
	Paddle(){
		this.setOpaque(true);
		this.setBackground(Color.white);
		this.setBounds(x,y,10,75);

	}
}
