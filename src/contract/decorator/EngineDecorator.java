package contract.decorator;

import components.enums.Commande;
import components.factories.FighterFactory;
import components.services.ActiveFighterService;
import components.services.EngineService;
import components.services.PlayerService;

public class EngineDecorator implements EngineService {
	private EngineService	delegate;

	public EngineDecorator(EngineService delegate) {
		super();
		this.delegate = delegate;
	}

	public int getHeight() {
		return delegate.getHeight();
	}

	public int getWidth() {
		return delegate.getWidth();
	}
	
	
	public long getTime() {
		return delegate.getTime();
	}

	public ActiveFighterService getFighter(int i) {
		return delegate.getFighter(i);
	}

	public PlayerService getPlayer(int i) {
		return delegate.getPlayer(i);
	}

	public void init(int height, int width, int distance, PlayerService p1,
			PlayerService p2, FighterFactory factory) {
		delegate.init(height, width, distance, p1, p2, factory);
	}

	public boolean isGameOver() {
		return delegate.isGameOver();
	}

	public void step(Commande comP1, Commande comP2) {
		delegate.step(comP1, comP2);
	}

	@Override
	public int getDistance() {
		return delegate.getDistance();
	}

}
