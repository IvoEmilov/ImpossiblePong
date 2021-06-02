package MainPackage;

import java.awt.Color;

import javax.swing.JLabel;

public class Paddle extends JLabel{
	private int positionX=100;
	private int positionY=225;
	Paddle(){
		this.setOpaque(true);
		this.setBackground(Color.white);
		this.setBounds(positionX,positionY,10,75);

	}
	public int getPositionX() {
		return positionX;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	public void setDefaultPosition() {
		positionX=100;
		positionY=225;
		this.setLocation(positionX,positionY);
	}
}
