package components.factories;

import components.enums.FighterName;
import components.impl.FighterImpl;
import components.impl.HitboxRectangleImpl;
import components.services.EngineService;
import components.services.FighterService;
import components.services.HitboxService;
import contract.FighterContract;

public class FighterFactory {
	private EngineService	unrealEngine;

	public FighterFactory(EngineService unrealEngine) {
		super();
		this.unrealEngine = unrealEngine;
	}

	public FighterService getFighter(FighterName name, boolean faceRight) {
		switch (name) {
		case rectangle:
			return newRectangleFighter(faceRight);

		case square:
			return newSquareFighter(faceRight);
		}
		return null;
	}

	private FighterService newRectangleFighter(boolean faceRight) {
		int speed = 10;
		int life = 100;
		int height = 300;
		int width = 100;
		FighterImpl impl = new FighterImpl();
		FighterService ret = new FighterContract(impl);
		HitboxService hitbox = new HitboxRectangleImpl(ret.getX(), ret.getY(),
				height, width);

		impl.setHitbox(hitbox);

		impl.init(life, speed, height, width, faceRight, unrealEngine);
		return ret;
	}

	private FighterService newSquareFighter(boolean faceRight) {
		int speed = 10;
		int life = 100;
		int height = 200;
		int width = 200;
		FighterImpl impl = new FighterImpl();
		FighterService ret = new FighterContract(impl);
		HitboxService hitbox = new HitboxRectangleImpl(ret.getX(), ret.getY(),
				height, width);

		impl.setHitbox(hitbox);

		impl.init(life, speed, height, width, faceRight, unrealEngine);
		return ret;
	}
}
