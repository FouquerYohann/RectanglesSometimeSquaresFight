package components.impl.fighter;

import components.enums.Commande;
import components.impl.hitbox.HitboxRectangleImpl;
import components.services.ActiveFighterService;
import components.services.FighterService;
import components.services.HitboxRectangleService;
import components.services.HitboxService;
import components.services.TechService;
import components.techniques.Punch;
import contract.HitboxRectangleContract;

public class ActiveFighterImpl extends FighterImpl implements
		ActiveFighterService {
	private boolean					blockint		= false,
			blockstunned = false, teching = false, techFrame = false,
			crouch = false, hitstunned = false, techHasAlreadyHit = false;

	private int						stunnCpt		= 0;
	private int						techCpt			= 0;
	private ActiveFighterService	otherFighter	= null;
	private HitboxRectangleService	hbCrouch		= null;
	private TechService				tech;

	public ActiveFighterImpl() {}

	@Override
	public boolean isBlocking() {
		return blockint;
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
		teching = true;
		techCpt = 0;
		tech.moveTo(this);
	}

	@Override
	public void step(Commande c) {
		if (getOtherFighter().isTeching())
			if (otherFighter.techFrame()) {
				if (!otherFighter.techHasAlreadyHit()) {
					TechService tequila = otherFighter.tech();
					if (tequila.getHitbox().collidesWith(getHitbox())) {
						tech = null;
						teching = false;
						techCpt = -1;
						techFrame = false;
						if (this.isBlocking()) {
							stunnCpt = tequila.getBstun();
							blockstunned = true;
						} else {
							life -= tequila.getDamage();
							stunnCpt = tequila.getHstun();
							hitstunned = true;
						}
					}
				}
			}

		crouch = false;
		if (stunnCpt > 0)
			stunnCpt--;
		else
			hitstunned = blockstunned = false;

		if (techCpt != -1)
			techCpt++;

		if (isTeching()) {
			if (!techFrame()) {
				if (tech().getSframe() == techCpt) {
					techFrame = true;
					techCpt = 0;
				}
			} else {
				if (tech.getHitbox()
						.collidesWith(getOtherFighter().getHitbox())) {
					techHasAlreadyHit = true;
				}
				if (tech().getHframe() == techCpt) {
					techFrame = false;
					stunnCpt = tech().getRframe();
					blockstunned=true;
					teching = false;
					techCpt = -1;
					techHasAlreadyHit = false;
				}
			}
			return;
		}

		if (isHitstunned() || isBlockstunned())
			return;

		if (c == Commande.PUNCH) {
			startTech(new Punch());
		} else {
			super.step(c);
		}
	}

	@Override
	public FighterService clone() {
		ActiveFighterImpl clone = new ActiveFighterImpl();
		clone.init(getLife(), getSpeed(), getHeight(), getWidth(),
				isFacingRight(), getEngine());
		clone.x = x;
		clone.y = y;
		clone.hitbox = new HitboxRectangleContract(new HitboxRectangleImpl(
				hitbox.getPositionX(), hitbox.getPositionY(), getHeight(),
				getWidth()));
		clone.blockint = blockint;
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
	public int getStunnCpt() {
		return stunnCpt;
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
		crouch = true;
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

	@Override
	public HitboxService getHitbox() {
		if (crouch)
			return hbCrouch;
		return super.getHitbox();
	}

}
