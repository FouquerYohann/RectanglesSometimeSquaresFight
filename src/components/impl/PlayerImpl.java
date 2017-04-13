package components.impl;

import java.util.ArrayList;

import components.enums.Commande;
import components.services.PlayerService;

public class PlayerImpl implements PlayerService{
    private String name;
    private ArrayList<Commande> list_bouchon;
    
    public PlayerImpl(){
	init("Bouchon");
	list_bouchon.add(Commande.LEFT);
	list_bouchon.add(Commande.LEFT);
	list_bouchon.add(Commande.LEFT);
	list_bouchon.add(Commande.LEFT);
	list_bouchon.add(Commande.LEFT);
	list_bouchon.add(Commande.LEFT);
	list_bouchon.add(Commande.RIGHT);
	list_bouchon.add(Commande.RIGHT);
	list_bouchon.add(Commande.RIGHT);
	list_bouchon.add(Commande.RIGHT);
	list_bouchon.add(Commande.RIGHT);
	
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
	return list_bouchon.remove(0);
    }

    @Override
    public void init(String name) {
	this.name=name;
	this.list_bouchon=new ArrayList<Commande>();
    }

}
