package components.impl.player;

import components.enums.CommandeMovement;
import components.factories.FighterFactory;
import components.impl.fighter.IChoosingFighterStrategy;
import components.services.FighterService;
import components.services.PlayerService;

public class PlayerImpl implements PlayerService {
	private String						name;
	private IChoosingFighterStrategy	strategy;

	public PlayerImpl() {}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public CommandeMovement getCommande() {
		return CommandeMovement.NEUTRAL;
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

}
