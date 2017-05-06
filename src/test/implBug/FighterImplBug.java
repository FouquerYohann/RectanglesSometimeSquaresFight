package test.implBug;

import components.enums.Commande;
import components.impl.hitbox.HitboxRectangleImpl;
import components.services.EngineService;
import components.services.FighterService;
import components.services.HitboxRectangleService;
import components.services.HitboxService;
import contract.HitboxRectangleContract;

public class FighterImplBug implements FighterService {

	protected int						x;
	protected int						y;
	protected int							speed;
	protected int						life;
	protected int							height;
	protected int							width;

	public void setHeight(int height) {
		this.height = height;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setFaceRight(boolean faceRight) {
		this.faceRight = faceRight;
	}

	public void setUnrealEngine(EngineService unrealEngine) {
		this.unrealEngine = unrealEngine;
	}

	public void setOtherFighter(FighterService otherFighter) {
		this.otherFighter = otherFighter;
	}

	protected boolean						faceRight;
	public EngineService				unrealEngine;
	protected HitboxRectangleService	hitbox;
	private FighterService				otherFighter	= null;

	public FighterImplBug() {}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public EngineService getEngine() {
		return unrealEngine;
	}

	@Override
	public HitboxService getHitbox() {
		return hitbox;
	}

	@Override
	public int getLife() {
		return life;
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public boolean isFacingRight() {
		return faceRight;
	}

	@Override
	public boolean isDead() {
		return life <= 0;
	}

	public void setHitbox(HitboxRectangleService hitbox) {
		this.hitbox = hitbox;
	}

	public FighterService getOtherFighter() {
		if (otherFighter == null)
			otherFighter = (unrealEngine.getFighter(1).equals(this)) ? unrealEngine
					.getFighter(2) : unrealEngine.getFighter(1);
		return otherFighter;
	}

	@Override
	public void init(int life, int speed, int height, int width,
			boolean lookRight, EngineService unrealEngine) {

	}

	@Override
	public void moveLeft() {
		x-=speed;
	}

	@Override
	public void moveRight() {

	}

	@Override
	public void jump() {

	}

	@Override
	public void crouch() {

	}

	@Override
	public void switchSide() {

	}

	@Override
	public void step(Commande c) {
		if(c==Commande.LEFT)
			moveLeft();
	}

	@Override
	public FighterService clone() {
		FighterImplBug clone = new FighterImplBug();
		clone.init(life, speed, height, width, faceRight, unrealEngine);
		clone.x = x;
		clone.y = y;
		clone.hitbox = new HitboxRectangleContract(new HitboxRectangleImpl(
				hitbox.getPositionX(), hitbox.getPositionY(), height, width));

		return clone;
	}

	@Override
	public boolean equals(FighterService fighter) {
		if (fighter == null)
			return false;
		if (this == fighter)
			return true;

		return (this.x == fighter.getX()) && (this.y == fighter.getY())

		&& (this.faceRight == fighter.isFacingRight())
				&& (this.speed == fighter.getSpeed())
		/*
		 * && (this.hitbox.equalsTo(fighter.getHitbox())) && (this.life ==
		 * fighter.getLife())
		 */;
	}

	@Override
	public String toString() {
		return "FighterImpl [x=" + x + ", y=" + y + ", speed=" + speed
				+ ", life=" + life + ", faceRight=" + faceRight
				+ ", unrealEngine=" + unrealEngine + ", hitbox=" + hitbox + "]";
	}

}
