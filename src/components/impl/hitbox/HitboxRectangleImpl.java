package components.impl.hitbox;

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
		return ((this.getPositionX() <= x && this.getPositionX() + getWidth() >= x) && (this
				.getPositionY() <= y && this.getPositionY() + getHeight() >= y));
	}

	@Override
	public boolean collidesWith(HitboxService hitbox) {
		
		if (hitbox.belongsTo(this.getPositionX(), this.getPositionY())
				|| hitbox.belongsTo(this.getPositionX() + width,
						this.getPositionY())
				|| hitbox.belongsTo(this.getPositionX(), this.getPositionY()
						+ height)
				|| hitbox.belongsTo(this.getPositionX() + width,
						this.getPositionY() + height))
			return true;
		for (int x = getPositionX(); x < getPositionX() + getWidth(); x++) {
			if(hitbox.belongsTo(x, getPositionY())||hitbox.belongsTo(x, getPositionY()+height))return true;
		}
		for (int y = getPositionY(); y < getPositionY() + getHeight(); y++) {
			if(hitbox.belongsTo(getPositionX(), y)||hitbox.belongsTo(getPositionX()+width, y))return true;
		}
		return false;
	}
}
