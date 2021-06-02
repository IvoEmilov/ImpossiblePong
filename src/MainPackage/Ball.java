package MainPackage;

import java.awt.Color;

import javax.swing.JLabel;

public class Ball extends JLabel{
	
	private int positionX=690;
	private int positionY=290;
	private int VelocityX=1, VelocityY=1;
	
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
	public int move(Paddle paddle) {
		if(positionX==110) {
			if(positionY>paddle.getPositionY()&&positionY<paddle.getPositionY()+75) {
				VelocityX=-VelocityX;
				VelocityY=-VelocityY;
			}
		}
		if(positionX==1380) {
			VelocityX=-VelocityX;
		}
		if(positionY==0||positionY==550) {
			VelocityY=-VelocityY;
		}
		if(positionX==0) {
			return -1;
		}
	//	System.out.println(paddleY);//225 default, paddle length is 75, so between 225 and 300
		positionX+=VelocityX;
		positionY+=VelocityY;
		this.setLocation(positionX, positionY);
		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

}
