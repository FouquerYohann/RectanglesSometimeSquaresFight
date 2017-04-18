package components.impl;

import java.util.ArrayList;

import components.enums.Commande;
import components.services.PlayerService;

public class PlayerImpl implements PlayerService {
	private String				name;
	private ArrayList<Commande>	listBouchon;

	public PlayerImpl() {
		init("Bouchon");
		listBouchon.add(Commande.LEFT);
		listBouchon.add(Commande.LEFT);
		listBouchon.add(Commande.LEFT);
		listBouchon.add(Commande.LEFT);
		listBouchon.add(Commande.LEFT);
		listBouchon.add(Commande.LEFT);
		listBouchon.add(Commande.RIGHT);
		listBouchon.add(Commande.RIGHT);
		listBouchon.add(Commande.RIGHT);
		listBouchon.add(Commande.RIGHT);
		listBouchon.add(Commande.RIGHT);

	}

	public PlayerImpl(String name) {
		init(name);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Commande getCommande() {
		if(listBouchon.isEmpty())return Commande.NEUTRAL;
		return listBouchon.remove(0);
	}

	@Override
	public void init(String name) {
		this.name = name;
		this.listBouchon = new ArrayList<Commande>();
	}

}
