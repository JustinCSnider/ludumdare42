package ui;

import javax.swing.JFrame;

public class Menu {
	
	public Menu() {
		JFrame mainMenu = new JFrame("Main menu");
		mainMenu.setBounds(400,400,1024,576);
		mainMenu.setVisible(true);
		mainMenu.setLayout(null);
		mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}