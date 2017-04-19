package components.services;

import tools.Controls;
import components.enums.CommandeMovement;
import components.factories.FighterFactory;
import components.impl.fighter.IChoosingFighterStrategy;

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
	 * //TODO
	 * @param controlleur
	 */
	public void setControlleur(Controls controlleur);	
	/**
	 * @param name
	 *            the name of the player
	 */
	void init(String name,IChoosingFighterStrategy strategy);

	/**
	 * @return the fighter of the player
	 * */
	FighterService chooseFighter(FighterFactory factory,boolean faceRight);
}
