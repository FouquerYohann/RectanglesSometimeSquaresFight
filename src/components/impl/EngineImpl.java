package components.impl;

import components.enums.Commande;
import components.services.EngineService;
import components.services.FighterService;
import components.services.PlayerService;
import contract.FighterContract;
import contract.PlayerContract;

public class EngineImpl implements EngineService {
    private static int height;
    private static int width;
    private static int distance;
    private FighterService fighter1;
    private FighterService fighter2;
    private PlayerService player1;
    private PlayerService player2;
    
       
    private final static int defaultHeight=768;
    private final static int defaultWidth=1024;
    private final static int defaultDistance=defaultWidth/4;
    private final static PlayerService defaultPlayer1=new PlayerContract(new PlayerImpl("Yohann"));
    private final static PlayerService defaultPlayer2=new PlayerContract(new PlayerImpl());;
    
    
    
    public EngineImpl() {
	super();
	init(defaultHeight,defaultWidth,defaultDistance,defaultPlayer1,defaultPlayer2);
	
    }

    @Override
    public int getHeight() {
	return height;
    }

    @Override
    public int getWidth() {
	return width;
    }

    @Override
    public FighterService getFighter(int i) {
	return (i==1)?fighter1:fighter2;
    }

    @Override
    public PlayerService getPlayer(int i) {
	return (i==1)?player1:player2;
    }

    @Override
    public boolean isGameOver() {
	return (fighter1.isDead() || fighter2.isDead());
    }

    @Override
    public void init(int height, int width, int distance, PlayerService p1,
	    PlayerService p2) {
	this.height=height;
	this.width=width;
	this.distance=distance;
	this.player1=p1;
	this.player2=p2;
	this.fighter1=new FighterContract(new FighterImpl());
	this.fighter2=new FighterContract(new FighterImpl());
    }

    @Override
    public void step(Commande comP1, Commande comP2) {
	fighter1.step(comP1);
	fighter2.step(comP2);

    }

}
