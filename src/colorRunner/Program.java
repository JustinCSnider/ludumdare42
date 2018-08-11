package colorRunner;

import java.awt.Graphics;

import javax.swing.JFrame;

public class Program {
	
	Graphics g;
	
	public Program() {
		JFrame game = new JFrame("Color Runner");
		game.setLayout(null);
		game.setBounds(400,400,1024,576);
		game.setVisible(true);
		g = game.getGraphics();
		game.paint(g);
	}
	
	public static void main(String[]args) {
		Program d = new Program();
	}
}
