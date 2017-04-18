package components.impl;

import java.util.ArrayList;

import components.enums.CommandeMovement;
import components.services.PlayerService;

public class PlayerImpl implements PlayerService {
	private String				name;
	private ArrayList<CommandeMovement>	listBouchon;

	public PlayerImpl() {
		init("Bouchon");
		listBouchon.add(CommandeMovement.LEFT);
		listBouchon.add(CommandeMovement.LEFT);
		listBouchon.add(CommandeMovement.LEFT);
		listBouchon.add(CommandeMovement.LEFT);
		listBouchon.add(CommandeMovement.LEFT);
		listBouchon.add(CommandeMovement.LEFT);
		listBouchon.add(CommandeMovement.RIGHT);
		listBouchon.add(CommandeMovement.RIGHT);
		listBouchon.add(CommandeMovement.RIGHT);
		listBouchon.add(CommandeMovement.RIGHT);
		listBouchon.add(CommandeMovement.RIGHT);

	}

	public PlayerImpl(String name) {
		init(name);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public CommandeMovement getCommande() {
		if(listBouchon.isEmpty())return CommandeMovement.NEUTRAL;
		return listBouchon.remove(0);
	}

	@Override
	public void init(String name) {
		this.name = name;
		this.listBouchon = new ArrayList<CommandeMovement>();
	}

}
