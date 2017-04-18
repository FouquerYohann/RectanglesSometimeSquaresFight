package components.impl;

import components.enums.Commande;
import components.services.EngineService;
import components.services.FighterService;
import components.services.HitboxService;
import contract.HitboxContract;

public class FighterImpl implements FighterService {
	private int				x;
	private int				y;
	private int				speed;
	private int				life;
	private boolean			faceRight;
	private EngineService	unrealEngine;
	private HitboxService	hitbox;

	public FighterImpl(int speed, int life, boolean faceRight,
			EngineService unrealEngine) {
		init(life, speed, faceRight, unrealEngine);
	}

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
	public boolean isFacingRight() {
		return faceRight;
	}

	@Override
	public boolean isDead() {
		return life <= 0;
	}

	@Override
	public void init(int life, int speed, boolean lookRight,
			EngineService unrealEngine) {
		// TODO bien faire la distance
		if (lookRight)
			this.x = unrealEngine.getWidth() / 4;
		else
			this.x = 3 * unrealEngine.getWidth() / 4;
		this.y = 0;
		this.life = life;
		this.speed = speed;
		this.faceRight = lookRight;
		this.unrealEngine = unrealEngine;
		this.hitbox = new HitboxContract(new HitboxImpl(x, y));
	}

	@Override
	public void moveLeft() {
		x = (x - speed < 0) ? 0 : x - speed;
	}

	@Override
	public void moveRight() {
		x = (x + speed > unrealEngine.getWidth()) ? unrealEngine.getWidth() : x
				+ speed;
	}

	@Override
	public void switchSide() {
		faceRight = !faceRight;
	}

	@Override
	public void step(Commande c) {
		switch (c) {
		case LEFT:
			moveLeft();
			break;
		case RIGHT:
			moveRight();
			break;

		default:
			break;
		}
	}

	@Override
	public FighterService clone() {
		FighterImpl clone = new FighterImpl( speed,life, faceRight,
				unrealEngine);
		clone.x = x;
		clone.y = y;
		clone.hitbox = new HitboxContract(new HitboxImpl(hitbox.getPositionX(),
				hitbox.getPositionY()));
		return clone;
	}

	@Override
	public boolean equals(FighterService fighter) {
		if (fighter == null)
			return false;
		if (this == fighter)
			return true;

		return (this.x == fighter.getX()) && (this.y == fighter.getY())
				&& (this.life == fighter.getLife())
				&& (this.faceRight == fighter.isFacingRight())
				&& (this.speed == fighter.getSpeed());
	}

	@Override
	public String toString() {
		return "FighterImpl [x=" + x + ", y=" + y + ", speed=" + speed
				+ ", life=" + life + ", faceRight=" + faceRight
				+ ", unrealEngine=" + unrealEngine + ", hitbox=" + hitbox + "]";
	}

}
