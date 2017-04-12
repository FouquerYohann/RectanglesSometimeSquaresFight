package display;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
    private static FighterRepresent fighter1;
    private static FighterRepresent fighter2;
    private static int              frameHeight   = 768;
    private static int              frameWidth    = 1024;
    private static int              fighterHeight = 300;
    private static int              fighterWidth  = 100;

    public MainFrame(String titre) {
	super(titre);
	fighter1 = new FighterRepresent(0, fighterWidth, fighterHeight,
	        frameWidth, frameHeight, Color.BLUE);
	fighter2 = new FighterRepresent(frameWidth - fighterWidth,
	        fighterWidth, fighterHeight, frameWidth, frameHeight, Color.RED);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(frameWidth, frameHeight);
	add(fighter1);
	setVisible(true);
	add(fighter2);
	setVisible(true);
    }

    private void refresh() {
	paint(getGraphics());
        fighter1.refresh();
        fighter2.refresh();
        
    }
    
    public static void main(String[] args) {
	MainFrame fenetre = new MainFrame("RectanglesSometimeSquaresFight");

	
	fenetre.addKeyListener(new KeyListener() {

	    @Override
	    public void keyTyped(KeyEvent e) {

	    }

	    @Override
	    public void keyPressed(KeyEvent e) {
		System.out.println("keypressed");
		switch (e.getKeyCode()) {
		    case KeyEvent.VK_LEFT:
			fighter2.move(-1, 0);
			break;
		    case KeyEvent.VK_RIGHT:
			fighter2.move(1, 0);
			break;
		    case KeyEvent.VK_UP:
			fighter2.move(0, -1);
			break;
		    case KeyEvent.VK_DOWN:
			fighter2.move(0, 1);
			break;
		    		    
		    case KeyEvent.VK_Q:
			fighter1.move(-1, 0);
			break;
		    case KeyEvent.VK_D:
			fighter1.move(1, 0);
			break;
		    case KeyEvent.VK_Z:
			fighter1.move(0, -1);
			break;
		    case KeyEvent.VK_S:
			fighter1.move(0, 1);
			break;

		    default:
			break;
		}
		fenetre.refresh();
	    }

	   

	    @Override
	    public void keyReleased(KeyEvent e) {
		System.out.println("keyreleased");
		switch (e.getKeyCode()) {
		    case KeyEvent.VK_LEFT:
			fighter2.stop(true);
			break;
		    case KeyEvent.VK_RIGHT:
			fighter2.stop(true);
			break;
		    case KeyEvent.VK_UP:
			fighter2.stop(false);
			break;
		    case KeyEvent.VK_DOWN:
			fighter2.stop(false);
			break;
		    case KeyEvent.VK_Q:
			fighter1.stop(true);
			break;
		    case KeyEvent.VK_D:
			fighter1.stop(true);
			break;
		    case KeyEvent.VK_Z:
			fighter1.stop(false);
			break;
		    case KeyEvent.VK_S:
			fighter1.stop(false);
			break;

		    default:
			break;
		}

	    }
	});

	fenetre.addNotify();
	fenetre.requestFocus();

    }
}
