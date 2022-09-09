package main;

import javax.swing.*;

public class Main{
	
	public static void main (String[] args) {
		
		JFrame window = new JFrame();
		
		//lets the window properly close when user clicks the 'x' button
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//size of window can't be changed
		window.setResizable(false);
		
		window.setTitle("2D League");

		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);

		//causes the window to be sized to fit the preferred size and layouts of its subcomponents.
		window.pack();
		
		//window will be displayed in the center of the screen
		window.setLocationRelativeTo(null);
		
		//We can see the window when the game is running
		window.setVisible(true);
		
		gamePanel.setUp();
		gamePanel.start();
	}
}
