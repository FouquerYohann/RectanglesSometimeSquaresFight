package components.impl;

import components.enums.CommandeMovement;
import components.services.EngineService;
import components.services.FighterService;
import components.services.HitboxService;
import contract.HitboxContract;

public class FighterImpl implements FighterService {
	private int				x;
	private int				y;
	private int				speed;
	private int				life;
	private int				height;
	private int				width;
	private boolean			faceRight;
	private EngineService	unrealEngine;
	private HitboxService	hitbox;

	public FighterImpl() {}

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

	@Override
	public void init(int life, int speed, int height, int width,
			boolean lookRight, EngineService unrealEngine) {
		// TODO bien faire la distance
		if (lookRight)
			this.x = unrealEngine.getDistance();
		else
			this.x = unrealEngine.getWidth() - unrealEngine.getDistance();
		this.y = 0;
		this.height = height;
		this.width = width;
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
	public void jump() {
		int size = speed / 2;
		y = (y - size < 0) ? 0 : y - size;
	}

	@Override
	public void crouch() {
		int size = speed / 2;
		y = (y + size > unrealEngine.getHeight()) ? 0 : y + size;
	}

	@Override
	public void switchSide() {
		faceRight = !faceRight;
	}

	@Override
	public void step(CommandeMovement c) {
		switch (c) {
		case LEFT:
			moveLeft();
			break;
		case RIGHT:
			moveRight();
			break;
		case JUMP:
			jump();
			break;
		case CROUCH:
			crouch();
			break;

		default:
			break;
		}
	}

	@Override
	public FighterService clone() {
		FighterImpl clone = new FighterImpl();
		clone.init(life, speed, height, width, faceRight, unrealEngine);
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

	public void setHitbox(HitboxService hitbox) {
		this.hitbox = hitbox;
	}
}
