package MainPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class MainFrame extends JFrame implements KeyListener{

	PlayPanel playPanel = new PlayPanel();
	Paddle paddle = new Paddle();
	Ball ball = new Ball();
	int paddleX=100,paddleY=225;
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
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==38)
		{
			paddle.setLocation(paddleX, paddleY=paddleY-10);	
		}
		else if(e.getKeyCode()==40)
		{
			paddle.setLocation(paddleX, paddleY=paddleY+10);	
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
