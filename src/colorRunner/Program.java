package colorRunner;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;

import javax.swing.JFrame;
import java.awt.event.*;
import ui.*;

public class Program extends Game{	
	public Program() {}
	
	public Graphics g;

	public static void main(String[]args) {
		Menu mainMenu = new Menu("Main menu");
		mainMenu.getStartButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Program().start();
			}
		});
	}

	@Override
	public void init() {
	}
	
	Point ovalPos = new Point(0, 0);
	@Override
	public void postTick(Graphics g) {
		g.fillOval(ovalPos.x, ovalPos.y, 25, 25);
		ovalPos.x += 1;
		ovalPos.y += 1;
	}
}
