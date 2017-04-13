package components.services;

import components.enums.Commande;

public interface PlayerService {
	/**
	 * @return name of the player
	 */
	String getName();

	/**
	 * @return current Commande*/
	Commande getCommande();

	/**
	 * @param name the name of the player*/
	void init(String name);
}
