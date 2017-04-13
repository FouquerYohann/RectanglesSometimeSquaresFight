package contract.decorator;

import components.enums.Commande;
import components.services.EngineService;
import components.services.FighterService;
import components.services.HitboxService;

public class FighterDecorator implements FighterService {
	private FighterService	delegate;

	public FighterDecorator(FighterService delegate) {
		super();
		this.delegate = delegate;
	}

	public int getX() {
		return delegate.getX();
	}

	public int getY() {
		return delegate.getY();
	}

	public EngineService getEngine() {
		return delegate.getEngine();
	}

	public HitboxService getHitbox() {
		return delegate.getHitbox();
	}

	public int getLife() {
		return delegate.getLife();
	}

	public int getSpeed() {
		return delegate.getSpeed();
	}

	public boolean isFacingRight() {
		return delegate.isFacingRight();
	}

	public boolean isDead() {
		return delegate.isDead();
	}

	public void init(int life, int speed, boolean lookRight,
			EngineService unrealEngine) {
		delegate.init(life, speed, lookRight, unrealEngine);
	}

	public void moveLeft() {
		delegate.moveLeft();
	}

	public void moveRight() {
		delegate.moveRight();
	}

	public void switchSide() {
		delegate.switchSide();
	}

	public void step(Commande c) {
		delegate.step(c);
	}

	public FighterService clone() {
		return delegate.clone();
	}

	public boolean equals(FighterService fighter) {
		return delegate.equals(fighter);
	}

}
