package components.factories;

import components.enums.Commande;
import components.impl.player.rules.DistanceRule;
import components.services.EngineService;

public class RulesFactory {

	public static DistanceRule newDistRulesPunch(EngineService engine, int fighter) {
		return new DistanceRule(fighter, engine, 200, Commande.PUNCH);
	}
}
