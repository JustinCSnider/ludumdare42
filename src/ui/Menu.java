package ui;

import javax.swing.JFrame;
import javax.swing.JButton;

public class Menu extends JFrame{
	
	JButton start;
	
	public Menu(String title) {
		setTitle(title);
		setBounds(400,400,1024,576);
		setVisible(true);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start = new JButton("Start");
		start.setBounds(410, 238, 200, 50);
		start.setVisible(true);
		
		add(start);
	}
	public JButton getStartButton() {
		return start;
	}
}