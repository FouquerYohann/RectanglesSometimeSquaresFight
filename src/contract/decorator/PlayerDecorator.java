package contract.decorator;

import tools.Controls;
import components.enums.CommandeMovement;
import components.factories.FighterFactory;
import components.impl.fighter.choose.IChoosingFighterStrategy;
import components.services.FighterService;
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

	public void setControlleur(Controls controlleur) {
	    delegate.setControlleur(controlleur);
        }

	@Override
	public void init(String name, IChoosingFighterStrategy strategy) {
		delegate.init(name, strategy);
	}

	@Override
	public FighterService chooseFighter(FighterFactory factory,boolean faceRight) {
		return delegate.chooseFighter(factory,faceRight);
	}

}
