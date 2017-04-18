package components.factories;

import components.enums.CommandeMovement;
import components.impl.PlayerBouchon;
import components.impl.PlayerImpl;
import components.services.PlayerService;

public class PlayerFactory {

	public static PlayerService newHumanPlayer(String name) {
		return new PlayerImpl(name);
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
		return b;
	}
}
