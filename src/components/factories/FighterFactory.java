package components.factories;

import components.enums.FighterName;
import components.impl.fighter.FighterImpl;
import components.impl.hitbox.HitboxRectangleImpl;
import components.services.EngineService;
import components.services.FighterService;
import components.services.HitboxService;
import contract.FighterContract;
import contract.HitboxContract;

public class FighterFactory {
    private EngineService unrealEngine;

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

	HitboxService hitbox = new HitboxContract(new HitboxRectangleImpl(impl.getX(),
	        impl.getY(), height, width));

	impl.setHitbox(hitbox);

	impl.init(life, speed, height, width, faceRight, unrealEngine);
	FighterService ret = new FighterContract(impl);
	return ret;
    }

    private FighterService newSquareFighter(boolean faceRight) {
	int speed = 10;
	int life = 100;
	int height = 200;
	int width = 200;
	FighterImpl impl = new FighterImpl();

	HitboxService hitbox = new HitboxContract(new HitboxRectangleImpl(impl.getX(),
	        impl.getY(), height, width));

	impl.setHitbox(hitbox);

	impl.init(life, speed, height, width, faceRight, unrealEngine);
	FighterService ret = new FighterContract(impl);
	return ret;
    }
}
