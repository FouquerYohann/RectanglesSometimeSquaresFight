package contract;

import components.services.HitboxService;
import contract.decorator.HitboxDecorator;

public class HitboxContract extends HitboxDecorator {
	private final static String	service	= "Hitbox";
	private int					w, h;

	public HitboxContract(HitboxService delegate, int w, int h) {
		super(delegate);
		this.w = w;
		this.h = h;
	}

	public void checkInvariant() {
		for (int i = 0; i < w * h; i++) {
			int x=i/h;
			int y=i%h;
		}
	}

	public void checkInvariant(HitboxService hb, int w, int h) {
		new HitboxContract(hb, w, h).checkInvariant();
	}

	@Override
	public int getPositionX() {
		return super.getPositionX();
	}

	@Override
	public int getPositionY() {

		return super.getPositionY();
	}

	@Override
	public boolean belongsTo(int x, int y) {
		return super.belongsTo(x, y);
	}

	@Override
	public boolean collidesWith(HitboxService hitbox) {
		return super.collidesWith(hitbox);
	}

	@Override
	public boolean equalsTo(HitboxService hitbox) {
		return super.equalsTo(hitbox);
	}

	@Override
	public void init(int x, int y) {
		super.init(x, y);
	}

	@Override
	public void moveTo(int x, int y) {
		super.moveTo(x, y);
	}

}
