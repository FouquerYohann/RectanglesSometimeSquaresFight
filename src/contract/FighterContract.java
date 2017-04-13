package contract;

import components.enums.Commande;
import components.services.EngineService;
import components.services.HitboxService;

import contract.decorator.FighterDecorator;

public class FighterContract extends FighterDecorator {

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
	// TODO Auto-generated method stub
	super.init(life, speed, lookRight, unrealEngine);
    }

    @Override
    public void moveLeft() {
	// TODO Auto-generated method stub
	super.moveLeft();
    }

    @Override
    public void moveRight() {
	// TODO Auto-generated method stub
	super.moveRight();
    }

    @Override
    public void switchSide() {
	// TODO Auto-generated method stub
	super.switchSide();
    }

    @Override
    public void step(Commande c) {
	// TODO Auto-generated method stub
	super.step(c);
    }

}
