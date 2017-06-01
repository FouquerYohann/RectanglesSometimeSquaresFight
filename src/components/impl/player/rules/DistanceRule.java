package components.impl.player.rules;

import components.enums.Commande;
import components.services.EngineService;
import components.services.FighterService;

public class DistanceRule implements IRule {
	private int				fighter;
	private EngineService	engine;
	private int				value;
	private int				priority	= 0;
	private Commande		commande;

	public DistanceRule(int fighter, EngineService engine, int value, Commande commande) {
		super();
		this.fighter = fighter;
		this.engine = engine;
		this.value = value;
		this.commande = commande;
	}

	public DistanceRule(int fighter, EngineService engine, int value, Commande commande,
	        int priority) {
		this(fighter, engine, value, commande);
		this.priority = priority;
	}

	@Override
	public boolean interprate() {
		FighterService f = engine.getFighter(fighter);
		FighterService otherFighter = engine.getFighter(fighter == 1 ? 2 : 1);
		int valPlus = f.isFacingRight() ? 0 : f.getWidth();
		int dist = f.getX() + valPlus - otherFighter.getX();
		return dist < value;
	}

	@Override
	public int priority() {
		return priority;
	}

	@Override
	public Commande getCommande() {
		return commande;
	}

}
