package components.impl.player;

import java.util.Random;

import components.enums.Commande;
import components.impl.fighter.choose.IChoosingFighterStrategy;

public class PlayerRandom extends PlayerImpl {
	private int			cpt;
	private Random		rand	= new Random();
	private Commande	curr	= Commande.NEUTRAL;
	private final int	taux	= 80;
	private final int	refresh	= 20;

	public PlayerRandom(Random rand) {
		super();
		this.rand = rand;
	}

	public PlayerRandom() {
		super();
	}

	@Override
	public Commande getCommande() {
		if (cpt % refresh == 0 && rand.nextInt(100) > taux)
			curr = Commande.values()[rand.nextInt(Commande.values().length)];
		if(curr==Commande.JUMP||curr==Commande.KICK)curr=Commande.NEUTRAL;
		return curr;
	}
	
	public void init(IChoosingFighterStrategy strategy){
		super.init("random_guy", strategy);
	}
}