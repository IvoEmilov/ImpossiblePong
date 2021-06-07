package MainPackage;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

public class HighScore extends JLabel{
	
	private String score="0.000";	
	
	HighScore(){
		this.setOpaque(true);
		this.setForeground(Color.white);
		this.setBackground(Color.DARK_GRAY);
		this.setFont(new Font("TimesRoman", Font.BOLD, 24));
		this.setBounds(600,100,500,50);
	}
	public void loadScore() {
		try {
		File f = new File("highscore.txt");
		if(f.createNewFile()) {
			
		}
		Scanner sc = new Scanner(f);
		while(sc.hasNextLine()) {
			score = sc.nextLine();
		}
		sc.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			this.setText("Best Time: "+score);
		}
	}
	public void saveScore() {
		try {
			FileWriter fw = new FileWriter("highscore.txt");
			if(Double.parseDouble(score)<Double.parseDouble(MainFrame.currentTime.getText().substring(15))) {
				score=MainFrame.currentTime.getText().substring(15);
				fw.write(score);
				this.setText("Best Time: "+score);
			}
			fw.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
}
