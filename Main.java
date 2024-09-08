package main;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
	
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Gay and friends");
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		GameBoard gameboard = new GameBoard();
		window.add(gameboard);
		window.pack();
		
}
}