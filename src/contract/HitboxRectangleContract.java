package contract;

import components.services.HitboxRectangleService;
import components.services.HitboxService;
import contract.decorator.HitboxRectangleDecorator;

public class HitboxRectangleContract extends HitboxRectangleDecorator {

	private final static String	service	= "HitBoxRectangle";
	private HitboxContract		hcontrat;

	public HitboxRectangleContract(HitboxRectangleService delegate) {
		super(delegate);
		hcontrat = new HitboxContract(delegate);
	}

	public int getPositionX() {
		return hcontrat.getPositionX();
	}

	public void checkInvariant() {
		hcontrat.checkInvariant();
	}

	public int getPositionY() {
		return hcontrat.getPositionY();
	}

	public void init(int x, int y) {
		super.init(x, y, 0, 0);
	}

	
	@Override
	public int getHeight() {
		return super.getHeight();
	}

	@Override
	public int getWidth() {
		return super.getWidth();
	}

	@Override
	public void init(int x, int y, int height, int width) {
		super.init(x, y, height, width);
	}

	public boolean belongsTo(int x, int y) {
		return super.belongsTo(x, y);
	}

	public boolean collidesWith(HitboxService hitbox) {
		return super.collidesWith(hitbox);
	}

	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public boolean equalsTo(HitboxService hitbox) {
		return super.equalsTo(hitbox);
	}

	public void moveTo(int x, int y) {
		super.moveTo(x, y);
	}


}
