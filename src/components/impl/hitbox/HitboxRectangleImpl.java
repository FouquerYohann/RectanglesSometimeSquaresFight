package components.impl.hitbox;

import components.services.HitboxRectangleService;
import components.services.HitboxService;

public class HitboxRectangleImpl extends HitboxImpl implements HitboxRectangleService {
	private int	height;
	private int	width;

	public HitboxRectangleImpl(int x, int y, int height, int width) {
		super(x, y);
		init(x, y, height, width);
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public void init(int x, int y, int height, int width) {
		super.init(x, y);
		this.height = height;
		this.width = width;

	}

	@Override
	public boolean belongsTo(int x, int y) {
		return (this.getPositionX() <= x && x <= this.getPositionX() + width &&
		        this.getPositionY() <= y && y <= this.getPositionY() + width);
	}

	@Override
	public boolean collidesWith(HitboxService hitbox) {
		HitboxRectangleService hRect = (HitboxRectangleService) hitbox;
		return !(this.getPositionX() > hRect.getPositionX() + hRect.getWidth() ||
		        this.getPositionX() + width < hRect.getPositionX() ||
		        this.getPositionY() > hRect.getPositionY() + hRect.getHeight() ||
		        this.getPositionY() + height < hRect.getPositionY());

	}

	@Override
	public boolean equalsTo(HitboxService hitbox) {
		HitboxRectangleService hRect = (HitboxRectangleService) hitbox;
		return (this.getPositionX() == hRect.getPositionX() &&
		        this.getPositionY() == hRect.getPositionY() /*
		                                                     * &&
		                                                     * this.getHeight()
		                                                     * ==
		                                                     * hRect.getHeight()
		                                                     */ &&
		        this.getWidth() == hRect.getWidth());

	}

}
