package MainPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLayeredPane;

public class PlayPanel extends JLayeredPane{
	
	PlayPanel(){

		this.setLayout(null);
		this.setBounds(0,0,1400,600);
		this.setBackground(Color.black);
		this.setOpaque(true);		
	
	}

}

