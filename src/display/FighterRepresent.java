package display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class FighterRepresent extends JPanel implements KeyListener {
    private int xPos, yPos;
    private int xMovement, yMovement;
    private int xSize, ySize;
    private int xParent, yParent;

    public FighterRepresent(int xPos, int xSize, int ySize, int xParent,
	    int yParent) {
	super();
	this.xSize = xSize;
	this.ySize = ySize;
	this.xParent = xParent;
	this.yParent = yParent;
	this.yPos = 0;
	this.xPos = xPos;
	this.xMovement = 0;
	this.yMovement = 0;
	addKeyListener(this);
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	
	Graphics2D g2 = (Graphics2D) g;
	g2.setColor(Color.PINK);
	g2.fillRect(xPos, yPos, xSize, ySize);
	
    }

    private void refresh() {
	xPos+=xMovement;
	yPos+=yMovement;
	repaint();
    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
	switch (e.getKeyCode()) {
	    case KeyEvent.VK_LEFT:
		xMovement = -5;
		break;
	    case KeyEvent.VK_UP:
		yMovement = -5;
		break;
	    case KeyEvent.VK_RIGHT:
		xMovement = 5;
		break;
	    case KeyEvent.VK_DOWN:
		yMovement = 5;
		break;

	    default:
		break;
	}
	refresh();
    }

    @Override
    public void keyReleased(KeyEvent e) {
	
	switch (e.getKeyCode()) {
	    case KeyEvent.VK_LEFT:
		xMovement = 0;
		break;
	    case KeyEvent.VK_UP:
		yMovement = 0;
		break;
	    case KeyEvent.VK_RIGHT:
		xMovement = 0;
		break;
	    case KeyEvent.VK_DOWN:
		yMovement = 0;
		break;

	    default:
		break;
	}
	refresh();
    }

}
