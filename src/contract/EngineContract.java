package contract;

import components.enums.COMMANDE;
import components.services.FighterService;
import components.services.PlayerService;
import contract.decorator.EngineDecorator;
import contract.util.InvariantError;
import contract.util.PostconditionError;
import contract.util.PreconditionError;

public class EngineContract extends EngineDecorator {
    private final static String service="Engine";
    
    public void checkInvariant(){
	for(int i=1;i<3;i++){
	    if(getPlayer(i).isDead()==true)
		if(isGameOver()==false)
		    throw new InvariantError(service, "Game is not over even though one fighter is dead");
	}
    }
    
    
    @Override
    public int getHeight() {
	return super.getHeight();
    }

    @Override
    public int getWidth() {
	return super.getWidth();
    }

    @Override
    public FighterService getChar(int i) {
	return super.getChar(i);
    }

    @Override
    public PlayerService getPlayer(int i) {
	return super.getPlayer(i);
    }

    @Override
    public void init(int height, int width, int distance, PlayerService p1,
           PlayerService p2) {
	String method="init";
	checkInvariant();
	
	if(!(height>0))
	    throw new PreconditionError(service, method, " height < 0");
	if(!(width>0))
	    throw new PreconditionError(service, method, " width < 0");
	if(!(distance>0))
	    throw new PreconditionError(service, method, " distance < width/2");
	if(!(p1!=p2))
	    throw new PreconditionError(service, method, "player 1 == player 2");
	
	super.init(height, width, distance, p1, p2);
	
	if(!(getHeight()==height))
	    throw new PostconditionError(service, method, "height not initialized correctly");
	if(!(getWidth()==width))
	    throw new PostconditionError(service, method, "width not initialized correctly");
	if(!(getPlayer(1)==p1))
	    throw new PostconditionError(service, method, "player 1 not initilalized correctly");
	if(!(getPlayer(2)==p2))
	    throw new PostconditionError(service, method, "player 2 not initilalized correctly");
	if(!(getPlayer(1).getX()==p1))
	    throw new PostconditionError(service, method, "player 1 not initilalized correctly");
	if(!(getPlayer(2).getX==p2))
	    throw new PostconditionError(service, method, "player 2 not initilalized correctly");
	
    }

    @Override
    public boolean isGameOver() {
	// TODO Auto-generated method stub
	return super.isGameOver();
    }

    @Override
    public void step(COMMANDE comP1, COMMANDE comP2) {
	// TODO Auto-generated method stub
	super.step(comP1, comP2);
    }
    
}
