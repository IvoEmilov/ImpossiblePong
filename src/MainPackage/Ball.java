package MainPackage;

import java.awt.Color;
import java.util.Random;

import javax.swing.JLabel;

public class Ball extends JLabel{
	
	private int positionX=690;
	private int positionY=290;
	private int VelocityX=1, VelocityY=1;
	Random random = new Random();
	
	Ball() {
		this.setOpaque(true);
		this.setBackground(Color.white);
		this.setBounds(positionX,positionY,10,10);

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
		this.positionX=690;
		this.positionY=290;
		this.setLocation(positionX, positionY);
	}
	public int move() {
		if(positionX==110) {
			if(positionY>MainFrame.player.getPositionY()&&positionY<MainFrame.player.getPositionY()+75) {
				VelocityX=-VelocityX;
				VelocityY=-(random.nextInt(4)+1);
			}
		}
		if(positionX==1285) {
			VelocityX=-VelocityX;
			VelocityY=(random.nextInt(4)+1);
		}
		if((positionY>=0&&positionY<=5)||(positionY>=545&&positionY<=550)) {
			VelocityY=-VelocityY;
		}
		if(positionX==0) {
			return -1;
		}
	//	System.out.println(paddleY);//225 default, paddle length is 75, so between 225 and 300
		positionX+=VelocityX;
		positionY+=VelocityY;
		this.setLocation(positionX, positionY);
		if(this.getPositionX()>=900){
			MainFrame.opponent.setLocation(1280,this.getPositionY()-35);
		}
		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

}
