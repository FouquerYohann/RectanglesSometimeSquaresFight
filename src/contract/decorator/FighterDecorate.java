package contract.decorator;

import components.services.EngineService;
import components.services.FighterService;
import components.services.HitboxService;

public class FighterDecorate implements FighterService {
    private FighterService delegate;

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

    public void step() {
	delegate.step();
    }
    
    
}
