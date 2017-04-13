package contract;

import components.enums.Commande;
import components.services.EngineService;
import components.services.FighterService;
import components.services.PlayerService;
import contract.decorator.EngineDecorator;
import contract.util.InvariantError;
import contract.util.PostconditionError;
import contract.util.PreconditionError;

public class EngineContract extends EngineDecorator {
   
    
    public EngineContract(EngineService delegate) {
	super(delegate);
    }


    private final static String service="Engine";
    
    public void checkInvariant(){
	for(int i=1;i<3;i++){
	    if(getFighter(i).isDead()==true)
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
    public FighterService getFighter(int i) {
	return super.getFighter(i);
    }

    @Override
    public PlayerService getPlayer(int i) {
	return super.getPlayer(i);
    }

    @Override
    public boolean isGameOver() {
	// TODO Auto-generated method stub
	return super.isGameOver();
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
	
	checkInvariant();
	
	if(!(getHeight()==height))
	    throw new PostconditionError(service, method, "height not initialized correctly");
	if(!(getWidth()==width))
	    throw new PostconditionError(service, method, "width not initialized correctly");
	if(!(getPlayer(1)==p1))
	    throw new PostconditionError(service, method, "player 1 not initilalized correctly");
	if(!(getPlayer(2)==p2))
	    throw new PostconditionError(service, method, "player 2 not initilalized correctly");
	if(!(getFighter(1).getX()==distance))
	    throw new PostconditionError(service, method, "fighter 1 x position not initilalized correctly");
	if(!(getFighter(2).getX()==width-distance))
	    throw new PostconditionError(service, method, "fighter 2 x position not initilalized correctly");
	if(!(getFighter(1).getY()==0))
	    throw new PostconditionError(service, method, "fighter 1 y position not initilalized correctly");
	if(!(getFighter(2).getY()==0))
	    throw new PostconditionError(service, method, "fighter 2 y position not initilalized correctly");
	if(!(getFighter(1).isFacingRight()==true))
		throw new PostconditionError(service, method, "fighter 1 is not facing right");
	if(!(getFighter(2).isFacingRight()==false))
		throw new PostconditionError(service, method, "fighter 2 is not facing left");
	
	
    }

    
    @Override
    public void step(Commande comP1, Commande comP2) {
	String method="step";
	checkInvariant();

	//TODO clone method
	//FighterService preFighter1=(FighterContract)getFighter(1).clone();
	//FighterService preFighter2=(FighterContract)getFighter(1).clone();
	
	if(!(isGameOver()==false))
	    throw new PreconditionError(service, method, "Game is Over");
	
	
	super.step(comP1, comP2);
	
//	if(!(getFighter(1).equals(preFighter1.step(comP1))))
//	    throw new PostconditionError(service, method, "step methods do not return same fighter 1");
//	if(!(getFighter(1).equals(preFighter2.step(comP2))))
//	    throw new PostconditionError(service, method, "step methods do not return same fighter 2");
	
	checkInvariant();
    }
    
}
