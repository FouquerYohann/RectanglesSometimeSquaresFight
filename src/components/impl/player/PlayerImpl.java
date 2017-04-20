package components.impl.player;

import tools.Controls;
import components.enums.CommandeMovement;
import components.factories.FighterFactory;
import components.impl.fighter.choose.IChoosingFighterStrategy;
import components.services.FighterService;
import components.services.PlayerService;

public class PlayerImpl implements PlayerService {
	private String						name;
	private IChoosingFighterStrategy	strategy;
	private Controls controlleur;
	

	@Override
	public String getName() {
		return name;
	}

	@Override
	public CommandeMovement getCommande() {
		return controlleur.getCurrent();
	}

	@Override
	public void init(String name, IChoosingFighterStrategy strategy) {
		this.name = name;
		this.strategy=strategy;
	}

	@Override
	public FighterService chooseFighter(FighterFactory factory,boolean faceRight) {
		return strategy.chooseFighter(factory,faceRight);
	}

	public void setControlleur(Controls controlleur) {
	    this.controlleur = controlleur;
	}
	
}
