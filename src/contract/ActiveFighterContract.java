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
		if (super.isBlocking())
			cpt++;

		if (super.isBlockstunned())
			cpt++;

		if (super.isHitstunned())
			cpt++;

		if (super.isTeching())
			cpt++;

		if (cpt > 1)
			throw new InvariantError(service, "too much states "
					+ super.isBlocking() + " " + super.isBlockstunned() + " "
					+ super.isHitstunned() + " " + super.isTeching());
	}

	@Override
	public void init(int life, int speed, int height, int width,
			boolean lookRight, EngineService unrealEngine) {
		String method = "init";

		fcontrat.init(life, speed, height, width, lookRight, unrealEngine);

		if (isBlocking() || isBlockstunned() || isHitstunned() || isTeching())
			throw new PostconditionError(service, method,
					"after init player must be neutral");
	}

	@Override
	public void startTech(TechService tech) {
		checkInvariant();
		String method = "startTech";

		if (isTeching())
			throw new PreconditionError(service, method,
					"fighter already teching");
		if (isBlocking())
			throw new PreconditionError(service, method,
					"fighter already Blocking");
		if (isHitstunned())
			throw new PreconditionError(service, method,
					"fighter already Hitstunned");
		if (isBlockstunned())
			throw new PreconditionError(service, method,
					"fighter already Blockstunned");

		super.startTech(tech);

		checkInvariant();

		if (!isTeching())
			throw new PostconditionError(service, method,
					"after startteching fighter must tech");
		if (techFrame())
			throw new PostconditionError(service, method,
					"after startteching fighter must be not be in tech frame");
		if (techHasAlreadyHit())
			throw new PostconditionError(service, method,
					"after startteching tech should not hit right now");
	}

	public void moveLeft() {

		checkInvariant();
		fcontrat.moveLeft();
		checkInvariant();
	}

	public boolean equals(Object obj) {
		return fcontrat.equals(obj);
	}

	public void moveRight() {
		checkInvariant();
		fcontrat.moveRight();
		checkInvariant();
	}

	@Override
	public void jump() {
		checkInvariant();
		fcontrat.jump();
		checkInvariant();
	}

	@Override
	public void crouch() {
		checkInvariant();
		fcontrat.crouch();
		checkInvariant();
	}

	public void switchSide() {
		checkInvariant();
		fcontrat.switchSide();
		checkInvariant();
	}

	public void step(Commande c) {
		String method = "step";

		int preX = this.getX();

		checkInvariant();
		super.step(c);
		checkInvariant();

		if (isBlocking() || isBlockstunned() || isHitstunned() || isTeching()) {
			if (preX != this.getX())
				throw new PostconditionError(service, method,
						"fighter should not have moved ");
		}
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

	public FighterService clone() {
		return fcontrat.clone();
	}

	public boolean equals(FighterService fighter) {
		return fcontrat.equals(fighter);
	}

}
