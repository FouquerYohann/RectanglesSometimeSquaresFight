package test.implBug;

import components.enums.Commande;
import components.impl.fighter.FighterImpl;
import components.impl.hitbox.HitboxRectangleImpl;
import components.services.*;
import components.techniques.Punch;
import contract.HitboxRectangleContract;

public class ActiveFighterImplBug extends FighterImpl implements
        ActiveFighterService {
    private boolean blocking  = false,
            blockstunned      = false,
            teching           = false,
            techFrame         = false,
            crouch            = false,
            hitstunned        = false,
            techHasAlreadyHit = false;

    private int                    stunnCpt     = 0;

    private int                    techCpt      = 0;
    private ActiveFighterService   otherFighter = null;
    private HitboxRectangleService hbCrouch     = null;
    private TechService tech;
    public ActiveFighterImplBug() {
    }


    @Override
    public boolean isBlocking() {
        return blocking;
    }

    public ActiveFighterService getOtherFighter() {
        if (otherFighter == null)
            otherFighter = (getEngine().getFighter(1).equals(this)) ? getEngine()
                    .getFighter(2) : getEngine().getFighter(1);
        return otherFighter;
    }

    @Override
    public void startTech(TechService tech) {
        this.tech = tech;
        tech.moveTo(this);
    }

    @Override
    public void step(Commande c) {

        if (c == Commande.PUNCH) {
            startTech(new Punch());
        } else {
            super.step(c);
        }
    }

    @Override
    public FighterService clone() {
        ActiveFighterImplBug clone = new ActiveFighterImplBug();
        clone.init(getLife(), getSpeed(), getHeight(), getWidth(),
                isFacingRight(), getEngine());
        clone.x = x;
        clone.y = y;
        clone.hitbox = new HitboxRectangleContract(new HitboxRectangleImpl(
                hitbox.getPositionX(), hitbox.getPositionY(), getHeight(),
                getWidth()));
        clone.blocking = blocking;
        clone.blockstunned = blockstunned;
        clone.teching = teching;
        clone.techFrame = techFrame;
        clone.crouch = crouch;
        clone.hitstunned = hitstunned;
        clone.techHasAlreadyHit = techHasAlreadyHit;
        clone.tech = tech;
        clone.techCpt = techCpt;
        clone.stunnCpt = stunnCpt;
        clone.hbCrouch = hbCrouch;
        return clone;
    }

    @Override
    public boolean isBlockstunned() {
        return blockstunned;
    }

    @Override
    public boolean isHitstunned() {
        return hitstunned;
    }

    @Override
    public boolean isTeching() {
        return teching;
    }

    @Override
    public TechService tech() {
        return tech;
    }

    @Override
    public boolean techFrame() {
        return techFrame;
    }

    @Override
    public boolean techHasAlreadyHit() {
        return techHasAlreadyHit;
    }

    @Override
    public void crouch() {
        if (hbCrouch == null)
            hbCrouch = new HitboxRectangleImpl(hitbox.getPositionX(),
                    hitbox.getPositionY(), hitbox.getHeight() / 2,
                    hitbox.getWidth());
        else
            hbCrouch.moveTo(hitbox.getPositionX(), hitbox.getPositionY());

    }

    @Override
    public void jump() {
        System.out.println("Jump forest jump");
    }

    @Override
    public int getHeight() {
        if (crouch)
            return super.getHeight() / 2;
        return super.getHeight();
    }

    public int getStunnCpt() {
        return stunnCpt;
    }

    @Override
    public HitboxService getHitbox() {
        if (crouch)
            return hbCrouch;
        return super.getHitbox();
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

    public void setHeight(int height) {
        this.height = height;
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


    public void setBlocking(boolean blocking) {
        this.blocking = blocking;
    }

    public void setBlockstunned(boolean blockstunned) {
        this.blockstunned = blockstunned;
    }

    public void setTeching(boolean teching) {
        this.teching = teching;
    }

    public void setTechFrame(boolean techFrame) {
        this.techFrame = techFrame;
    }

    public void setCrouch(boolean crouch) {
        this.crouch = crouch;
    }

    public void setHitstunned(boolean hitstunned) {
        this.hitstunned = hitstunned;
    }

    public void setTechHasAlreadyHit(boolean techHasAlreadyHit) {
        this.techHasAlreadyHit = techHasAlreadyHit;
    }

    public void setStunnCpt(int stunnCpt) {
        this.stunnCpt = stunnCpt;
    }

    public void setTechCpt(int techCpt) {
        this.techCpt = techCpt;
    }

    public void setOtherFighter(ActiveFighterService otherFighter) {
        this.otherFighter = otherFighter;
    }

    public void setHbCrouch(HitboxRectangleService hbCrouch) {
        this.hbCrouch = hbCrouch;
    }

    public void setTech(TechService tech) {
        this.tech = tech;
    }
}
