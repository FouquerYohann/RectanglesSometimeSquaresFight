package components.impl;

import java.util.ArrayList;
import java.util.Collection;

import components.enums.CommandeMovement;
import components.factories.FighterFactory;

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
	
	public void init(FighterFactory factory){
		super.init("Bouchon" + cpt,factory);
		cpt++;
	}
}
