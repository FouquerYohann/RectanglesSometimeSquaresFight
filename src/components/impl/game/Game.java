package components.impl.game;

import java.util.Observable;

import components.enums.Commande;
import components.services.EngineService;

public class Game extends Observable {
	private EngineService	unrealEngine;
	private boolean			isGameOver	= false;

	public EngineService getUnrealEngine() {
		return unrealEngine;
	}

	public Game(EngineService unrealEngine) {
		super();
		this.unrealEngine = unrealEngine;

	}

	public void Routine(int delay) {
		new Thread(() -> {
			while (!unrealEngine.isGameOver()) {
				try {
					Thread.sleep(delay);
					Commande comP1 = unrealEngine.getPlayer(1).getCommande();
					Commande comP2 = unrealEngine.getPlayer(2).getCommande();
					// if (comP1 == CommandeMovement.NEUTRAL
					// && comP2 == CommandeMovement.NEUTRAL)
					// continue;
				unrealEngine.step(comP1, comP2);
				setChanged();
				notifyObservers();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("LE Jeu est game over");
		isGameOver = true;
		setChanged();
		notifyObservers();
	}	).start();
	}

	public boolean isGameOver() {
		return isGameOver;
	}

}
