package contract.decorator;

import components.enums.Commande;
import components.services.ActiveFighterService;
import components.services.EngineService;
import components.services.FighterService;
import components.services.HitboxService;
import components.services.TechService;

public class ActiveFighterDecorator implements ActiveFighterService {
	private ActiveFighterService	delegate;

	public ActiveFighterDecorator(ActiveFighterService delegate) {
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

	public void init(int life, int speed, int height, int width,
			boolean lookRight, EngineService unrealEngine) {
		delegate.init(life, speed, height, width, lookRight, unrealEngine);
	}

	public int getLife() {
		return delegate.getLife();
	}

	public int getSpeed() {
		return delegate.getSpeed();
	}

	public int getHeight() {
		return delegate.getHeight();
	}

	public int getWidth() {
		return delegate.getWidth();
	}

	public boolean isDead() {
		return delegate.isDead();
	}

	public void moveLeft() {
		delegate.moveLeft();
	}

	public void moveRight() {
		delegate.moveRight();
	}

	public void jump() {
		delegate.jump();
	}

	public void crouch() {
		delegate.crouch();
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

	public boolean isBlockint() {
		return delegate.isBlockint();
	}

	public boolean isBlockstunned() {
		return delegate.isBlockstunned();
	}

	public boolean isHitstunned() {
		return delegate.isHitstunned();
	}

	public boolean isTeching() {
		return delegate.isTeching();
	}

	public TechService tech() {
		return delegate.tech();
	}

	public boolean techFrame() {
		return delegate.techFrame();
	}

	public boolean isFacingRight() {
		return delegate.isFacingRight();
	}

	public boolean techHasAlreadyHit() {
		return delegate.techHasAlreadyHit();
	}

	public void startTech(TechService tech) {
		delegate.startTech(tech);
	}

	@Override
	public String toString() {
		return delegate.toString();
	}
}
