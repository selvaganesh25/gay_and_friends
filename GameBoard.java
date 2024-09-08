package main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GameBoard extends JPanel
{
	
final int OriginalPSize=16;//one pixel mari
final int Scale =3;
final int PSize= OriginalPSize * Scale;// scaling for viewing
final int col=16;
final int row=12;

final int ScreenWidth = PSize*col;
final int ScreenHeight = PSize*row;



public GameBoard(){
	
	this.setPreferredSize(new Dimension(ScreenWidth,ScreenHeight));
	this.setBackground(Color.darkGray);
	this.setDoubleBuffered(true);
}

}
