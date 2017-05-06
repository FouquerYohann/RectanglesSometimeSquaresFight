package components.services;

import components.enums.Commande;
import components.factories.FighterFactory;
import components.impl.fighter.choose.IChoosingFighterStrategy;
import tools.Controls;

public interface PlayerService {
	/**
	 * @return name of the player
	 */
	String getName();

	/**
	 * @return current Commande
	 */
	Commande getCommande();

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
	ActiveFighterService chooseFighter(FighterFactory factory,boolean faceRight);
}
