package contract;

import components.enums.Commande;
import components.services.ActiveFighterService;
import components.services.EngineService;
import components.services.FighterService;
import components.services.HitboxService;
import components.services.TechService;
import contract.decorator.ActiveFighterDecorator;
import contract.util.InvariantError;
import contract.util.PostconditionError;
import contract.util.PreconditionError;

public class ActiveFighterContract extends ActiveFighterDecorator {
	private final static String	service	= "ActiveFighter";
	private FighterContract		fcontrat;

	public ActiveFighterContract(ActiveFighterService delegate) {
		super(delegate);
		fcontrat = new FighterContract(delegate);
	}

	public void checkInvariant() {
		fcontrat.checkInvariant();
		int cpt = 0;
		if (super.isBlockint())
			cpt++;

		if (super.isBlockstunned())
			cpt++;

		if (super.isHitstunned())
			cpt++;

		if (super.isTeching())
			cpt++;

		if (cpt > 1)
			throw new InvariantError(service, "too much states");
	}

	@Override
	public void init(int life, int speed, int height, int width,
			boolean lookRight, EngineService unrealEngine) {
		String method = "init";

		fcontrat.init(life, speed, height, width, lookRight, unrealEngine);

		if (isBlockint() || isBlockstunned() || isHitstunned() || isTeching())
			throw new PostconditionError(service, method,
					"after init player must be neutral");
	}

	@Override
	public void startTech(TechService tech) {
		String method = "startTech";
		if (isTeching())
			throw new PreconditionError(service, method,
					"fighter already teching");
		super.startTech(tech);

		if (!isTeching())
			throw new PostconditionError(service, method,
					"after startTeching fighter must tech");
	}

	public int getX() {
		return fcontrat.getX();
	}

	public int getY() {
		return fcontrat.getY();
	}

	public EngineService getEngine() {
		return fcontrat.getEngine();
	}

	public HitboxService getHitbox() {
		return fcontrat.getHitbox();
	}

	public int getLife() {
		return fcontrat.getLife();
	}

	public int getSpeed() {
		return fcontrat.getSpeed();
	}

	public int getHeight() {
		return fcontrat.getHeight();
	}

	public int getWidth() {
		return fcontrat.getWidth();
	}

	public boolean isFacingRight() {
		return fcontrat.isFacingRight();
	}

	public void checkInvariant(FighterService delegate) {
		fcontrat.checkInvariant(delegate);
	}

	public boolean isDead() {
		return fcontrat.isDead();
	}

	public int hashCode() {
		return fcontrat.hashCode();
	}

	public FighterService clone() {
		return fcontrat.clone();
	}

	public boolean equals(FighterService fighter) {
		return fcontrat.equals(fighter);
	}

	public String toString() {
		return fcontrat.toString();
	}

	public void moveLeft() {
		fcontrat.moveLeft();
	}

	public boolean equals(Object obj) {
		return fcontrat.equals(obj);
	}

	public void moveRight() {
		fcontrat.moveRight();
	}

	@Override
	public void jump() {
		fcontrat.jump();
	}

	@Override
	public void crouch() {
		fcontrat.crouch();
	}

	public void switchSide() {
		fcontrat.switchSide();
	}

	public void step(Commande c) {
		String method = "step";
		if(isBlockint()||isTeching()||isBlockstunned()||isHitstunned()){
			super.step(c);return;
		}
		ActiveFighterService clone = (ActiveFighterService) super.clone();
		checkInvariant();
		super.step(c);
		checkInvariant();
		switch (c) {
		case LEFT:
			clone.moveLeft();
//			if (!super.equals(clone))
//				throw new PostconditionError(service, method, "step(" + c
//						+ ") must be equivalent to moveleft()\n"
//						+ clone.toString() + "\n" + super.toString());

			break;
		case RIGHT:
			clone.moveRight();
//			if (!super.equals(clone))
//				throw new PostconditionError(service, method, "step(" + c
//						+ ") must be equivalent to moveRight()\n"
//						+ clone.toString() + "\n" + super.toString());
			break;
		case NEUTRAL:
//			if (!super.equals(clone))
//				throw new PostconditionError(service, method, "step(" + c
//						+ ") must not change the fighter");

			break;
		default:
			break;
		}
	}

}
