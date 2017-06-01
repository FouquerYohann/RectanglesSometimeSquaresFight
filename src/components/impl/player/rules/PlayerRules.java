package components.impl.player.rules;

import java.util.ArrayList;

import components.enums.Commande;
import components.impl.player.PlayerImpl;

public class PlayerRules extends PlayerImpl {
	private ArrayList<IRule> rules = new ArrayList<>();

	public PlayerRules() {
		super();
	}

	public void addRule(IRule r) {
		rules.add(r);
	}

	@Override
	public Commande getCommande() {
		Commande c = Commande.NEUTRAL;
		boolean b = false;
		for (IRule r : rules) {
			if (r.interprate()) {
				System.out.println(r.interprate());
				c = r.getCommande();
				b = true;
			}
			if (c != Commande.NEUTRAL && b) {
				break;
			}
		}
		return c;
	}

}
