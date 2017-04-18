package display;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import components.impl.EngineImpl;
import components.impl.Game;
import components.services.EngineService;
import components.services.FighterService;
import contract.EngineContract;

public class MainFrame extends JFrame implements Observer {
	private static final long	serialVersionUID	= 1096504000554348122L;
	private Game				game;
	private final int			fighterHeight		= 300;
	private final int			fighterWidth		= 100;

	public MainFrame(String titre, EngineService ue) {
		super(titre);
		game=new Game(ue);
		game.addObserver(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(ue.getWidth(), ue.getHeight());
		setVisible(true);
	}

	private void refresh() {
		Graphics2D g2 = (Graphics2D) getGraphics();
		FighterService f1 = game.getUnrealEngine().getFighter(1);
		FighterService f2 = game.getUnrealEngine().getFighter(2);
		paint(g2);
		g2.fillRect(f1.getX(), f1.getY(), fighterWidth, fighterHeight);
		setVisible(true);
		g2.fillRect(f2.getX(), f2.getY(), fighterWidth, fighterHeight);
		setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Game) {
			refresh();
		}else{
			System.out.println(o.getClass());
		}

	}

	public static void main(String[] args) {
		MainFrame fenetre = new MainFrame("RectanglesSometimeSquaresFight",
				new EngineContract(new EngineImpl()));

		fenetre.game.Routine(1000);

		// fenetre.addKeyListener(new KeyListener() {
		//
		// @Override
		// public void keyTyped(KeyEvent e) {
		//
		// }
		//
		// @Override
		// public void keyPressed(KeyEvent e) {
		// System.out.println("keypressed");
		// switch (e.getKeyCode()) {
		// case KeyEvent.VK_LEFT:
		// fighter2.move(-1, 0);
		// break;
		// case KeyEvent.VK_RIGHT:
		// fighter2.move(1, 0);
		// break;
		// case KeyEvent.VK_UP:
		// fighter2.move(0, -1);
		// break;
		// case KeyEvent.VK_DOWN:
		// fighter2.move(0, 1);
		// break;
		//
		// case KeyEvent.VK_Q:
		// fighter1.move(-1, 0);
		// break;
		// case KeyEvent.VK_D:
		// fighter1.move(1, 0);
		// break;
		// case KeyEvent.VK_Z:
		// fighter1.move(0, -1);
		// break;
		// case KeyEvent.VK_S:
		// fighter1.move(0, 1);
		// break;
		//
		// default:
		// break;
		// }
		// fenetre.refresh();
		// }
		//
		// @Override
		// public void keyReleased(KeyEvent e) {
		// System.out.println("keyreleased");
		// switch (e.getKeyCode()) {
		// case KeyEvent.VK_LEFT:
		// fighter2.stop(true);
		// break;
		// case KeyEvent.VK_RIGHT:
		// fighter2.stop(true);
		// break;
		// case KeyEvent.VK_UP:
		// fighter2.stop(false);
		// break;
		// case KeyEvent.VK_DOWN:
		// fighter2.stop(false);
		// break;
		// case KeyEvent.VK_Q:
		// fighter1.stop(true);
		// break;
		// case KeyEvent.VK_D:
		// fighter1.stop(true);
		// break;
		// case KeyEvent.VK_Z:
		// fighter1.stop(false);
		// break;
		// case KeyEvent.VK_S:
		// fighter1.stop(false);
		// break;
		//
		// default:
		// break;
		// }
		//
		// }
		// });
		//
		// fenetre.addNotify();
		// fenetre.requestFocus();

	}

}
