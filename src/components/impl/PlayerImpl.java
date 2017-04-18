package components.impl;

import components.enums.CommandeMovement;
import components.enums.FighterName;
import components.factories.FighterFactory;
import components.services.PlayerService;

public class PlayerImpl implements PlayerService {
	private String	name;

	public PlayerImpl() {
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public CommandeMovement getCommande() {
		return CommandeMovement.NEUTRAL;
	}

	@Override
	public void init(String name, FighterFactory factory) {
		this.name = name;
	}

	@Override
	public void chooseFighter(FighterName name) {
		
	}

}
