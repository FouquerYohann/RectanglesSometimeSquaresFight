package components.impl;

import components.enums.Commande;
import components.services.EngineService;
import components.services.FighterService;
import components.services.PlayerService;

public class EngineImpl implements EngineService {
    private static int defaultHeight=768;
    private static int defaultWidth=1024;
    private static int defaultDistance=defaultWidth/4;
    //private static PlayerService defaultPlayer1=new Player;
    //private static PlayerService defaultPlayer2=new Player;
    
    
    
    public EngineImpl() {
	super();
	//TODO playerconstructor
	init(defaultHeight,defaultWidth,defaultDistance,null,null);
    }

    @Override
    public int getHeight() {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public int getWidth() {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public FighterService getFighter(int i) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public PlayerService getPlayer(int i) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public boolean isGameOver() {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public void init(int height, int width, int distance, PlayerService p1,
	    PlayerService p2) {
	// TODO Auto-generated method stub

    }

    @Override
    public void step(Commande comP1, Commande comP2) {
	// TODO Auto-generated method stub

    }

}
