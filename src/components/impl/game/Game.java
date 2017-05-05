package components.impl.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.Observable;

import components.enums.Commande;
import components.services.EngineService;

public class Game extends Observable {
	private EngineService		unrealEngine;
	private boolean				isGameOver	= false;
	private int					cpt			= 0;
	private PrintStream	out;

	public EngineService getUnrealEngine() {
		return unrealEngine;
	}

	public Game(EngineService unrealEngine) {
		super();
		this.unrealEngine = unrealEngine;
		
		try {
			out=new PrintStream(new File("err_log"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void Routine(int delay) {
		new Thread(() -> {
			while (!unrealEngine.isGameOver() && unrealEngine.getTime() > 0) {
				try {
					Thread.sleep(delay);
					Commande comP1 = unrealEngine.getPlayer(1).getCommande();
					Commande comP2 = unrealEngine.getPlayer(2).getCommande();
					unrealEngine.step(comP1, comP2);
					setChanged();
					notifyObservers();
				} catch (Throwable e) {
					e.printStackTrace();
					break;
				}
			}
			System.out.println("Le Jeu est game over");
			isGameOver = true;
			setChanged();
			notifyObservers();
		}).start();
	}

	public boolean isGameOver() {
		return isGameOver;
	}

}
