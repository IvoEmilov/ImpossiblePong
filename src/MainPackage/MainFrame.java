package MainPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;
import java.util.Scanner;
import java.util.Timer;

import javax.swing.*;

public class MainFrame extends JFrame implements KeyListener{
	
	Scanner sc=new Scanner(System.in);
	PlayPanel playPanel = new PlayPanel();
	Paddle paddle = new Paddle();
	Ball ball = new Ball();
	JLabel pauseLabel = new JLabel();
	String choice="";
	int paddleX=100,paddleY=225,ballX=690,ballY=290;
	int VelocityX=1, VelocityY=1;
	MainFrame(){
		
		this.setSize(1400,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.addKeyListener(this);
		this.setResizable(false);
		
		playPanel.add(paddle);
		playPanel.add(ball);	
		
		this.add(playPanel, BorderLayout.CENTER);
		this.add(new PointsPanel(), BorderLayout.SOUTH);
		
		newGame();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getKeyCode());//e=69, q=81 Enter=10, ESC=27
		if(e.getKeyCode()==10) {
			if(pauseLabel.isVisible()) {
				Timer timer = new Timer();
				TimerTask task = new TimerTask() {

					@Override
					public void run() {
						while(true) {
						if(ballMovement()==-1) {
							timer.cancel();
							timer.purge();
							ball.setLocation(690, 290);
							paddle.setLocation(100, 225);
							pauseLabel.setText("Game Over!");
							pauseLabel.setBounds(550, 400, 1200, 200);
							pauseLabel.setVisible(true);
							break;
							}
						}
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						closeGame();
					}
				};
				timer.schedule(task, 1000);
				pauseLabel.setVisible(false);
			}
		}
		if(e.getKeyCode()==27) {
			if(pauseLabel.isVisible()) {
				this.dispose();
				System.exit(0);	
			}
		}
		if(e.getKeyCode()==38)
		{
			if(paddleY-25>-10) {
				paddle.setLocation(paddleX, paddleY=paddleY-25);	
			}	
		}
		else if(e.getKeyCode()==40)
		{
			if(paddleY+25<525) {
				paddle.setLocation(paddleX, paddleY=paddleY+25);	
			}	
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void newGame() {
		pauseLabel.setText("Press Enter to start. Press ESC to quit.");
		pauseLabel.setFont(new Font("TimesRoman", Font.BOLD, 52));
		pauseLabel.setForeground(Color.white);
		pauseLabel.setBounds(300, 400, 1200, 200);
		playPanel.add(pauseLabel);
	}
	
	public int ballMovement() {
		if(ballX==110) {
			if(ballY>paddleY&&ballY<paddleY+75) {
				VelocityX=-VelocityX;
				VelocityY=-VelocityY;
			}
		}
		if(ballX==1380) {
			VelocityX=-VelocityX;
		}
		if(ballY==0||ballY==550) {
			VelocityY=-VelocityY;
		}
		if(ballX==0) {
			return -1;
		}
	//	System.out.println(paddleY);//225 default, paddle length is 75, so between 225 and 300
		ballX+=VelocityX;
		ballY+=VelocityY;
		ball.setLocation(ballX, ballY);
		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}
	
	private void closeGame() {
		this.dispose();
		new MainFrame();

	}
	
}
