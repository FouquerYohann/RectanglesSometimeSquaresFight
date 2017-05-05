package components.impl.techniques;

import components.impl.hitbox.HitboxRectangleImpl;
import components.services.FighterService;
import components.services.HitboxRectangleService;

/**
 * Created by 3305392 on 05/05/17.
 */
public class Boumtmort extends TechImpl{

    private HitboxRectangleService hitBox	= new HitboxRectangleImpl(0, 0,
            200, 2000);

    public Boumtmort() {
        super(100000, 1, 5, 5, 50, 1);
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
