package components.impl.player;

import java.util.ArrayList;
import java.util.Collection;

import tools.Controls;
import components.enums.CommandeMovement;
import components.impl.fighter.choose.IChoosingFighterStrategy;

public class PlayerBouchon extends PlayerImpl {
	private ArrayList<CommandeMovement>	listBouchon	= new ArrayList<CommandeMovement>();
	private static int					cpt			= 0;

	
	

	@Override
	public CommandeMovement getCommande() {
		if (listBouchon.isEmpty())
			return CommandeMovement.NEUTRAL;
		return listBouchon.remove(0);
	}

	public void addCommande(CommandeMovement c) {
		listBouchon.add(c);

	}

	public void addAllCommand(Collection<CommandeMovement> l) {
		listBouchon.addAll(l);
	}

	public void init( IChoosingFighterStrategy strategy) {
		super.init("Bouchon" + cpt,  strategy);
		cpt++;
	}
}
