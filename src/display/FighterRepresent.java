package display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class FighterRepresent extends JPanel{
    private int xPos, yPos;
    private int xMovement, yMovement;
    private int xSize, ySize;
    private int xParent, yParent;
    private Color color;

    public FighterRepresent(int xPos, int xSize, int ySize, int xParent,
	    int yParent,Color color) {
	super();
	this.xSize = xSize;
	this.ySize = ySize;
	this.xParent = xParent;
	this.yParent = yParent;
	this.yPos = 0;
	this.xPos = xPos;
	this.xMovement = 0;
	this.yMovement = 0;
	this.color=color;
    }

    public void paintComponent(Graphics g) {
	
	Graphics2D g2 = (Graphics2D) g;
	
	g2.setColor(color);
	g2.fillRect(xPos, yPos, xSize, ySize);
	
    }

    public void refresh() {
	xPos+=xMovement;
	yPos+=yMovement;
	paintComponent(getGraphics());
    }

    
   
    public void move(int xMov,int yMov){
	xMovement=xMov;
	yMovement=yMov;
	refresh();
    }
    
    public void stop(boolean horizontal){
	if(horizontal)
	    xMovement=0;
	else
	    yMovement=0;
    }

    public void punch() {
	// TODO Auto-generated method stub
	
    }

	

}
