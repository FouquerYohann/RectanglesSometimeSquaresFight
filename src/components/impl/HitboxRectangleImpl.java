package components.impl;

import components.services.HitboxService;

public class HitboxRectangleImpl extends HitboxImpl {
	private int	height;
	private int	width;

	public HitboxRectangleImpl(int x, int y, int height, int width) {
		super(x, y);
		this.height = height;
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	@Override
	public boolean belongsTo(int x, int y) {
		return ((this.getPositionX() >= x && this.getPositionX() + getWidth() < x) && (this
				.getPositionY() >= y && this.getPositionY() + getHeight() < y));
	}

	@Override
	public boolean collidesWith(HitboxService hitbox) {
		return this.belongsTo(hitbox.getPositionX(), hitbox.getPositionY());
	}
}
