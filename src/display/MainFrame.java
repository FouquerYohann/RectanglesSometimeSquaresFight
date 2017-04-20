package display;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import components.factories.EngineFactory;
import components.impl.game.EngineImpl;
import components.impl.game.Game;
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
		game = new Game(ue);
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
		g2.setColor(Color.BLUE);
		g2.fillRect(f1.getX(), f1.getY(), f1.getWidth(), f1.getHeight());
		setVisible(true);
		g2.setColor(Color.RED);
		g2.fillRect(f2.getX(), f2.getY(), f2.getWidth(), f2.getHeight());
		setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Game) {
			refresh();
		} else {
			System.out.println(o.getClass());
		}

	}

	public static void main(String[] args) {
		MainFrame fenetre = new MainFrame("RectanglesSometimeSquaresFight",
				EngineFactory.defaultEngine());

		fenetre.game.Routine(1000);

	}

}