package components.impl.player;

import components.enums.Commande;
import components.impl.fighter.choose.IChoosingFighterStrategy;

import java.util.ArrayList;
import java.util.Collection;

public class PlayerBouchon extends PlayerImpl {
	private ArrayList<Commande>	listBouchon	= new ArrayList<Commande>();
	private static int					cpt			= 0;

	
	

	@Override
	public Commande getCommande() {
		if (listBouchon.isEmpty())
			return Commande.NEUTRAL;
		return listBouchon.remove(0);
	}

	public void addCommande(Commande c) {
		listBouchon.add(c);

	}

	public void addAllCommand(Collection<Commande> l) {
		listBouchon.addAll(l);
	}

	public void init( IChoosingFighterStrategy strategy) {
		super.init("Bouchon" + cpt,  strategy);
		cpt++;
	}
}
