package MainPackage;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class CurrentTime extends JLabel{
	CurrentTime(){
		this.setOpaque(true);
		this.setForeground(Color.white);
		this.setBackground(Color.DARK_GRAY);
		this.setFont(new Font("TimesRoman", Font.BOLD, 24));
		this.setBounds(580,50,500,50);
	}
}
