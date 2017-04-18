package components.services;

import components.enums.CommandeMovement;
import components.enums.FighterName;
import components.factories.FighterFactory;

public interface PlayerService {
	/**
	 * @return name of the player
	 */
	String getName();

	/**
	 * @return current Commande
	 */
	CommandeMovement getCommande();

	/**
	 * @param name
	 *            the name of the player
	 */
	void init(String name, FighterFactory factory);
	
	/**
	 * @return name of the fighter
	 * */
	FighterName chooseFighter();
}
