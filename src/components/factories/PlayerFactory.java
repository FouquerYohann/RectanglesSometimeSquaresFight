package components.factories;

import components.enums.CommandeMovement;
import components.impl.PlayerBouchon;
import components.impl.PlayerImpl;
import components.services.PlayerService;
import contract.PlayerContract;

public class PlayerFactory {

	public static PlayerService newHumanPlayer(String name,
			FighterFactory factory) {
		PlayerService player = new PlayerContract(new PlayerImpl());
		player.init(name, factory);
		return player;
	}

	public static PlayerService newBouchonGaucheDroite(FighterFactory factory) {
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
		b.init(factory);
		PlayerService s=new PlayerContract(b);
		return s;
	}
}
