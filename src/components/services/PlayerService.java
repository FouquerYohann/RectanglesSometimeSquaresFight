package components.services;

import components.enums.CommandeMovement;

public interface PlayerService {
	/**
	 * @return name of the player
	 */
	String getName();

	/**
	 * @return current Commande*/
	CommandeMovement getCommande();

	/**
	 * @param name the name of the player*/
	void init(String name);
}
