package contract.decorator;

import components.enums.Commande;
import components.factories.FighterFactory;
import components.impl.fighter.choose.IChoosingFighterStrategy;
import components.services.ActiveFighterService;
import components.services.PlayerService;
import tools.Controls;

public class PlayerDecorator implements PlayerService {
	PlayerService	delegate;

	public PlayerDecorator(PlayerService delegate) {
		super();
		this.delegate = delegate;
	}

	public String getName() {
		return delegate.getName();
	}

	public Commande getCommande() {
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
	public ActiveFighterService chooseFighter(FighterFactory factory,boolean faceRight) {
		return delegate.chooseFighter(factory,faceRight);
	}

}
