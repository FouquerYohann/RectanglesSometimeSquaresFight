package contract;

import components.enums.Commande;
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
	public int getX() {
		// TODO Auto-generated method stub
		return super.getX();
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return super.getY();
	}

	@Override
	public EngineService getEngine() {
		// TODO Auto-generated method stub
		return super.getEngine();
	}

	@Override
	public HitboxService getHitbox() {
		// TODO Auto-generated method stub
		return super.getHitbox();
	}

	@Override
	public int getLife() {
		// TODO Auto-generated method stub
		return super.getLife();
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return super.getSpeed();
	}

	@Override
	public boolean isFacingRight() {
		// TODO Auto-generated method stub
		return super.isFacingRight();
	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return super.isDead();
	}

	@Override
	public void init(int life, int speed, boolean lookRight,
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

		super.init(life, speed, lookRight, unrealEngine);
		checkInvariant();

		if (getLife() != life)
			throw new PostconditionError(service, method,
					"life mal initialisé " + getLife());

		if (getSpeed() != speed)
			throw new PostconditionError(service, method,
					"speed mal initialisé " + getSpeed());

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
	public void step(Commande c) {
		FighterService clone=super.clone();
		checkInvariant();
		super.step(c);
		checkInvariant();
		
		
	}

}
