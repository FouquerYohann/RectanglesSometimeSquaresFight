package components.techniques;

import components.impl.hitbox.HitboxRectangleImpl;
import components.services.FighterService;
import components.services.HitboxRectangleService;

public class Punch extends TechImpl {
	private HitboxRectangleService	hitBox	= new HitboxRectangleImpl(0, 0,
													100, 400);

	public Punch() {
		super(1, 10, 5, 5, 50, 15);
	}

	@Override
	public HitboxRectangleService getHitbox() {
		return hitBox;
	}

	@Override
	public void moveTo(FighterService fighter) {
		if (fighter.isFacingRight())
			hitBox.moveTo(fighter.getX() + fighter.getWidth(), fighter.getY()
					+ fighter.getHeight() - hitBox.getHeight());
		else
			hitBox.moveTo(fighter.getX() -hitBox.getWidth(), fighter.getY()
					+ fighter.getHeight() - hitBox.getHeight());
	}

}
