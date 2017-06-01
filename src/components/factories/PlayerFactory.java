package components.factories;

import components.enums.Commande;
import components.impl.fighter.choose.ChoosingRandomFighterStrategy;
import components.impl.fighter.choose.IChoosingFighterStrategy;
import components.impl.player.PlayerBouchon;
import components.impl.player.PlayerImpl;
import components.impl.player.PlayerRandom;
import components.impl.player.rules.PlayerRules;
import components.services.EngineService;
import components.services.PlayerService;

public class PlayerFactory {

	public static PlayerService newHumanPlayer(String name,
	        IChoosingFighterStrategy strategy) {
		PlayerService player = new PlayerImpl();
		player.init(name, strategy);
		return player;
	}

	public static PlayerService newHumanPlayer(String name) {
		PlayerService player = new PlayerImpl();

		player.init(name, new ChoosingRandomFighterStrategy());
		return player;
	}

	public static PlayerService newBouchonGaucheDroite() {
		PlayerBouchon b = new PlayerBouchon();
		b.addCommande(Commande.LEFT);
		b.addCommande(Commande.LEFT);
		b.addCommande(Commande.LEFT);
		b.addCommande(Commande.LEFT);
		b.addCommande(Commande.LEFT);
		b.addCommande(Commande.LEFT);
		b.addCommande(Commande.RIGHT);
		b.addCommande(Commande.RIGHT);
		b.addCommande(Commande.RIGHT);
		b.addCommande(Commande.RIGHT);
		b.addCommande(Commande.RIGHT);
		IChoosingFighterStrategy strategy = new ChoosingRandomFighterStrategy();
		b.init(strategy);
		return b;
	}

	public static PlayerService punchAndMove() {
		PlayerBouchon b = new PlayerBouchon();
		b.addCommande(Commande.PUNCH);
		b.addCommande(Commande.LEFT);
		IChoosingFighterStrategy strategy = new ChoosingRandomFighterStrategy();
		b.init(strategy);
		return b;
	}

	public static PlayerService randomPlayer() {
		PlayerRandom b = new PlayerRandom();
		IChoosingFighterStrategy strategy = new ChoosingRandomFighterStrategy();
		b.init(strategy);
		return b;
	}

	public static PlayerService newRulesPlayer(String name, EngineService engine, int fighter) {
		PlayerRules player = new PlayerRules();
		player.addRule(RulesFactory.newDistRulesPunch(engine, fighter));

		player.init(name, new ChoosingRandomFighterStrategy());

		return player;
	}

}
