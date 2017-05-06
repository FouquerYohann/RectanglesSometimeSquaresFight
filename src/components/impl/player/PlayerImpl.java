package components.impl.player;

import components.enums.Commande;
import components.factories.FighterFactory;
import components.impl.fighter.choose.IChoosingFighterStrategy;
import components.services.ActiveFighterService;
import components.services.PlayerService;
import tools.Controls;

public class PlayerImpl implements PlayerService {
	private String						name;
	private IChoosingFighterStrategy	strategy;
	private Controls controlleur;
	

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Commande getCommande() {
		return controlleur.getCurrent();
	}

	@Override
	public void init(String name, IChoosingFighterStrategy strategy) {
		this.name = name;
		this.strategy=strategy;
	}

	@Override
	public ActiveFighterService chooseFighter(FighterFactory factory,boolean faceRight) {
		return strategy.chooseFighter(factory,faceRight);
	}

	public void setControlleur(Controls controlleur) {
	    this.controlleur = controlleur;
	}
	
}
