package contract.decorator;

import components.enums.COMMANDE;
import components.services.EngineService;
import components.services.FighterService;
import components.services.PlayerService;

public class EngineDecorator implements EngineService {
    private EngineService delegate;

    public int getHeight() {
	return delegate.getHeight();
    }

    public int getWidth() {
	return delegate.getWidth();
    }

    public FighterService getChar(int i) {
	return delegate.getChar(i);
    }

    public PlayerService getPlayer(int i) {
	return delegate.getPlayer(i);
    }

    public void init(int height, int width, int distance, PlayerService p1,
            PlayerService p2) {
	delegate.init(height, width, distance, p1, p2);
    }

    public boolean isGameOver() {
	return delegate.isGameOver();
    }

    public void step(COMMANDE comP1, COMMANDE comP2) {
	delegate.step(comP1, comP2);
    }

   
    
   

}
