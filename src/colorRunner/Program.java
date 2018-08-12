package colorRunner;

import java.awt.event.*;
import ui.*;

public class Program extends Thread{	
	public Program() {}

	public static void main(String[]args) {
		Menu mainMenu = new Menu("Main menu");
		mainMenu.getStartButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Game().start();
			}
		});
	}
}
