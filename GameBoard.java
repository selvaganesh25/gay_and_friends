package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GameBoard extends JPanel implements Runnable{

	
final int OriginalPSize=16;//one pixel mari
final int Scale =3;

final int PSize= OriginalPSize * Scale;// scaling for viewing

final int col=16;
final int row=12;

final int ScreenWidth = PSize*col;
final int ScreenHeight = PSize*row;

Thread gameThread;
int playerX = 100; // Player position
int playerY = 100; // Player position



KeyHandler keyHandler; // KeyHandler reference

public GameBoard(KeyHandler keyHandler) {
    this.keyHandler = keyHandler;
    this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
    this.setBackground(Color.black);
    this.setDoubleBuffered(true);
    this.addKeyListener(keyHandler);
    this.setFocusable(true);
}

public void startGameTheard() {
	gameThread = new Thread(this);
	gameThread.start();
}
@Override
public void run() {
	final int FPS = 60;
    final double timeStep = 1000000000.0 / FPS; // Fixed time step for game logic
    double accumulator = 0;
    long lastTime = System.nanoTime();
	
	while (gameThread != null) {
		long currentTime;
        
        while (gameThread != null) {
            currentTime = System.nanoTime();
            double elapsedTime = currentTime - lastTime;
            lastTime = currentTime;
            accumulator += elapsedTime;

            // Update game state with fixed time steps
            while (accumulator >= timeStep) {
                update();  // Update game logic
                accumulator -= timeStep;
            }
		repaint();
	}
        
}
}
public void update() {
	if (keyHandler.upPressed) {
        playerY -= PSize; // Move up
    }
    if (keyHandler.downPressed) {
        playerY += PSize; // Move down
    }
    if (keyHandler.leftPressed) {
        playerX -= PSize; // Move left
    }
    if (keyHandler.rightPressed) {
        playerX += PSize;
    }
}

public void paintComponent(Graphics g) {
	
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D)g;
	
	g2.setColor(Color.white);
	g2.fillRect(playerX, playerY, PSize, PSize);
	g2.dispose();
}









}

