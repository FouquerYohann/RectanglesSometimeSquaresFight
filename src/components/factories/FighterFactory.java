package components.factories;

import components.enums.FighterName;
import components.impl.fighter.ActiveFighterImpl;
import components.impl.hitbox.HitboxRectangleImpl;
import components.services.ActiveFighterService;
import components.services.EngineService;
import components.services.HitboxRectangleService;

public class FighterFactory {
	private EngineService unrealEngine;

	public FighterFactory(EngineService unrealEngine) {
		super();
		this.unrealEngine = unrealEngine;
	}

	public ActiveFighterService getFighter(FighterName name, boolean faceRight) {
		switch (name) {
			case rectangle:
				return newRectangleFighter(faceRight);

			case square:
				return newSquareFighter(faceRight);
		}
		return null;
	}

	private ActiveFighterService newRectangleFighter(boolean faceRight) {
		int speed = 10;
		int life = 20;
		int height = 300;
		int width = 100;
		ActiveFighterImpl impl = new ActiveFighterImpl();

		HitboxRectangleService hitbox = new HitboxRectangleImpl(impl.getX(), impl.getY(), height,
		        width);

		impl.setHitbox(hitbox);

		impl.init(life, speed, height, width, faceRight, unrealEngine);
		return impl;
	}

	private ActiveFighterService newSquareFighter(boolean faceRight) {
		int speed = 10;
		int life = 20;
		int height = 200;
		int width = 200;
		ActiveFighterImpl impl = new ActiveFighterImpl();

		HitboxRectangleService hitbox = new HitboxRectangleImpl(impl.getX(), impl.getY(), height,
		        width);

		impl.setHitbox(hitbox);

		impl.init(life, speed, height, width, faceRight, unrealEngine);
		return impl;
	}
}
