package components.techniques;

import components.impl.hitbox.HitboxRectangleImpl;
import components.services.HitboxService;

public class Punch extends TechImpl {

	public Punch() {
		super(10, 10, 5, 5, 10, 15);
	}

	@Override
	public HitboxService getHitbox(int x, int y) {
		HitboxService hb = new HitboxRectangleImpl(x, y, 20, 40);
		return hb;
	}

}
