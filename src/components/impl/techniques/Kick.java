package components.impl.techniques;

import components.impl.hitbox.HitboxRectangleImpl;
import components.services.FighterService;
import components.services.HitboxRectangleService;

public class Kick extends TechImpl {
    private HitboxRectangleService	hitBox	= new HitboxRectangleImpl(0, 0,
            50, 200);

    public Kick() {
        super(1, 10000, 5, 200, 50, 500);
    }

    @Override
    public HitboxRectangleService getHitbox() {
        return hitBox;
    }

    @Override
    public void moveTo(FighterService fighter) {
        if (fighter.isFacingRight())
            hitBox.moveTo(fighter.getX() + fighter.getWidth(), fighter.getY()
                    + fighter.getHeight()/2 - hitBox.getHeight());
        else
            hitBox.moveTo(fighter.getX() -hitBox.getWidth(), fighter.getY()
                    + fighter.getHeight()/2 - hitBox.getHeight());
    }

}
