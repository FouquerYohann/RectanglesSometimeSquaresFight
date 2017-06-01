package components.impl.player.rules;

import components.enums.Commande;

public interface IRule {
	
	boolean interprate();
	
	int priority();
	
	Commande getCommande();
}
