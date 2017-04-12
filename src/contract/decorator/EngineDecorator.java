package contract.decorator;

import components.services.EngineService;
import components.services.FighterService;
import components.services.PlayerService;

public class EngineDecorator implements EngineService {
    private EngineService delegate;
    
    
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
    public FighterService getChar(int i) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public PlayerService getPlayer(int i) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void init(int height, int width, int distance, PlayerService p1,
	    PlayerService p2) {
	// TODO Auto-generated method stub

    }

}
