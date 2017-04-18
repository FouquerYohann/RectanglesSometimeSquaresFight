package contract.decorator;

import components.enums.CommandeMovement;
import components.factories.FighterFactory;
import components.services.PlayerService;

public class PlayerDecorator implements PlayerService {
	PlayerService	delegate;

	public PlayerDecorator(PlayerService delegate) {
		super();
		this.delegate = delegate;
	}

	public String getName() {
		return delegate.getName();
	}

	public CommandeMovement getCommande() {
		return delegate.getCommande();
	}

	public void init(String name, FighterFactory factory) {
		delegate.init(name, factory);
	}

}
