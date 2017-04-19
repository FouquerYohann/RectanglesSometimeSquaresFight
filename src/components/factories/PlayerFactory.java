package components.factories;

import components.enums.CommandeMovement;
import components.impl.fighter.ChoosingRandomFighterStrategy;
import components.impl.fighter.IChoosingFighterStrategy;
import components.impl.player.PlayerBouchon;
import components.impl.player.PlayerImpl;
import components.services.PlayerService;
import contract.PlayerContract;

public class PlayerFactory {

	public static PlayerService newHumanPlayer(String name,
			IChoosingFighterStrategy strategy) {
		PlayerService player = new PlayerContract(new PlayerImpl());
		player.init(name, strategy);
		return player;
	}

	public static PlayerService newHumanPlayer(String name
		) {
	PlayerService player = new PlayerContract(new PlayerImpl());
	
	player.init(name, new ChoosingRandomFighterStrategy());
	return player;
}
	
	public static PlayerService newBouchonGaucheDroite() {
		PlayerBouchon b = new PlayerBouchon();
		b.addCommande(CommandeMovement.LEFT);
		b.addCommande(CommandeMovement.LEFT);
		b.addCommande(CommandeMovement.LEFT);
		b.addCommande(CommandeMovement.LEFT);
		b.addCommande(CommandeMovement.LEFT);
		b.addCommande(CommandeMovement.LEFT);
		b.addCommande(CommandeMovement.RIGHT);
		b.addCommande(CommandeMovement.RIGHT);
		b.addCommande(CommandeMovement.RIGHT);
		b.addCommande(CommandeMovement.RIGHT);
		b.addCommande(CommandeMovement.RIGHT);
		IChoosingFighterStrategy strategy = new ChoosingRandomFighterStrategy();
		b.init(strategy);
		PlayerService s = new PlayerContract(b);
		return s;
	}
}
