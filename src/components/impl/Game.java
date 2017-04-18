package components.impl;

import java.util.Observable;

import components.services.EngineService;
import contract.EngineContract;

public class Game extends Observable {
	private EngineService	unrealEngine;

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
					unrealEngine.step(unrealEngine.getPlayer(1).getCommande(),
							unrealEngine.getPlayer(2).getCommande());
					setChanged();
					notifyObservers();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("LE Jeu est game over");
		}).start();
	}
}
