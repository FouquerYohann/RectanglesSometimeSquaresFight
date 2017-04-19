package contract;

import components.enums.CommandeMovement;
import components.impl.fighter.IChoosingFighterStrategy;
import components.services.PlayerService;
import contract.decorator.PlayerDecorator;

public class PlayerContract extends PlayerDecorator {

	public PlayerContract(PlayerService delegate) {
		super(delegate);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public CommandeMovement getCommande() {
		// TODO Auto-generated method stub
		return super.getCommande();
	}

	@Override
	public void init(String name, IChoosingFighterStrategy strategy) {
		// TODO Auto-generated method stub
		super.init(name, strategy);
	}

}
