package contract;

import components.enums.CommandeMovement;
import components.impl.FighterImpl;
import components.services.EngineService;
import components.services.FighterService;
import components.services.HitboxService;
import contract.decorator.FighterDecorator;
import contract.util.InvariantError;
import contract.util.PostconditionError;
import contract.util.PreconditionError;

public class FighterContract extends FighterDecorator {
	private final static String	service	= "Fighter";

	public FighterContract(FighterService delegate) {
		super(delegate);
	}

	public void checkInvariant() {
		if (getX() < 0 || (getX() >= getEngine().getWidth()))
			throw new InvariantError(service, "x out of bound :" + getX());

		if (getY() < 0 || (getY() >= getEngine().getHeight()))
			throw new InvariantError(service, "y out of bound :" + getY());

		if (isDead() && (getLife() > 0))
			throw new InvariantError(service, "dead but have still life :"
					+ getLife());

		if (!isDead() && (getLife() <= 0))
			throw new InvariantError(service, "omagad zombie");

	}

	public void checkInvariant(FighterService delegate) {
		new FighterContract(delegate).checkInvariant();
	}


	@Override
	public void init(int life, int speed,int height, int width, boolean lookRight,
			EngineService unrealEngine) {
		String method = "init";
		checkInvariant();

		// PRECONDITION
		if (life <= 0)
			throw new PreconditionError(service, method,
					"life must be positive :" + life);

		if (speed <= 0)
			throw new PreconditionError(service, method,
					"speed must be positive :" + speed);
		
		if(height <= 0 || height > getEngine().getHeight()/4)
		    	throw new PreconditionError(service, method, "height is not right :"+ height);

		if(width <=0 || width > getEngine().getWidth()/6)
		    	throw new PreconditionError(service, method, "width is not right :"+ width);

		
		super.init(life, speed,height, width, lookRight, unrealEngine);
		checkInvariant();

		if (getLife() != life)
			throw new PostconditionError(service, method,
					"life mal initialisé " + getLife());

		if (getSpeed() != speed)
			throw new PostconditionError(service, method,
					"speed mal initialisé " + getSpeed());
		if (getHeight() != height)
			throw new PostconditionError(service, method,
					"speed mal initialisé " + getHeight());
		if (getWidth() != width)
			throw new PostconditionError(service, method,
					"width mal initialisé " + getWidth());		
		
		if (isFacingRight() == lookRight)
			throw new PostconditionError(service, method,
					"sens mal initialisé ");

		if (getEngine() == unrealEngine)
			throw new PostconditionError(service, method,
					"sens mal initialisé ");

		if (!unrealEngine.equals(getEngine()))
			throw new PostconditionError(service, method,
					"engine mal initialisé");
	}

	@Override
	public void moveLeft() {
		String method = "moveLeft";
		checkInvariant();
		// capture
		FighterService otherPlayer = getEngine().getFighter(1) == this ? getEngine()
				.getFighter(2) : getEngine().getFighter(1);
		int preX = getX();
		int preY = getY();
		boolean preRight = isFacingRight();
		int life = getLife();

		super.moveLeft();

		checkInvariant();

		// post
		if ((getHitbox().collidesWith(otherPlayer.getHitbox()))
				&& getX() != preX)
			throw new PostconditionError(service, method,
					"when collision X dont change");

		if (getX() > getSpeed())
			if ((!getHitbox().collidesWith(otherPlayer.getHitbox())))
				if (getX() != (preX - getSpeed()))
					throw new PostconditionError(service, method,
							"wrong x to move left");
		if (getX() <= getSpeed())
			if ((!getHitbox().collidesWith(otherPlayer.getHitbox())))
				if (getX() != 0)
					throw new PostconditionError(service, method,
							"collide wall x must be 0");

		if (isFacingRight() == preRight)
			throw new PostconditionError(service, method,
					"side must not change");

		if (getLife() == life)
			throw new PostconditionError(service, method,
					"life must not change");

		if (getY() != preY)
			throw new PostconditionError(service, method, "Y must not change");

	}

	@Override
	public void moveRight() {
		String method = "moveRight";
		checkInvariant();
		FighterService otherPlayer = getEngine().getFighter(1) == this ? getEngine()
				.getFighter(2) : getEngine().getFighter(1);
		int preX = getX();
		int preY = getY();
		boolean preRight = isFacingRight();
		int life = getLife();

		super.moveRight();

		checkInvariant();

		// post
		if ((getHitbox().collidesWith(otherPlayer.getHitbox()))
				&& getX() != preX)
			throw new PostconditionError(service, method,
					"when collision X dont change");

		if (getX() >= getEngine().getWidth() - getSpeed())
			if (!getHitbox().collidesWith(otherPlayer.getHitbox()))
				if (getX() != getEngine().getWidth())
					throw new PostconditionError(service, method,
							"must stop to the wall ");

		if (getX() < getEngine().getWidth() - getSpeed())
			if (!getHitbox().collidesWith(otherPlayer.getHitbox()))
				if (getX() != preX - getSpeed())
					throw new PostconditionError(service, method,
							"wrong deplacement ");

		if (isFacingRight() == preRight)
			throw new PostconditionError(service, method,
					"side must not change");

		if (getLife() == life)
			throw new PostconditionError(service, method,
					"life must not change");

		if (getY() != preY)
			throw new PostconditionError(service, method, "Y must not change");
	}
	
	@Override
	public void jump(){
	    checkInvariant();
	    
	    super.jump();
	    
	    checkInvariant();
	    //TODO POST
	    
	}
	
	@Override
	public void crouch(){
	    checkInvariant();
	    
	    super.crouch();
	    
	    checkInvariant();
	    //TODO POST
	}

	@Override
	public void switchSide() {
		String method = "switchSide";
		// capture
		boolean facingRight = isFacingRight();
		int preX = getX();

		checkInvariant();
		super.switchSide();
		checkInvariant();

		if (isFacingRight() == facingRight)
			throw new PostconditionError(service, method, "side must change");

		if (preX != getX())
			throw new PostconditionError(service, method, "x must not change");

	}

	@Override
	public void step(CommandeMovement c) {
		System.out.println("Commande " + c);
		String method = "step";
		FighterService clone = super.clone();
		checkInvariant();
		super.step(c);
		checkInvariant();

		switch (c) {
		case LEFT:
			clone.moveLeft();
			if (!super.equals(clone))
				throw new PostconditionError(service, method, "step(" + c
						+ ") must be equivalent to moveleft()");

			break;
		case RIGHT:
			clone.moveRight();
			if (!super.equals(clone))
				throw new PostconditionError(service, method, "step(" + c
						+ ") must be equivalent to moveRight()");
			break;
		case NEUTRAL:
			if (!super.equals(clone))
				throw new PostconditionError(service, method, "step(" + c
						+ ") must not change the fighter");

			break;
		}

	}

}
