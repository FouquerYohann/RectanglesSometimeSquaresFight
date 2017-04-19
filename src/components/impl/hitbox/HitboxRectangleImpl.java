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
	    return !(   x > this.getPositionX()+width
	             || x +/*sa largeur*/ < this.getPositionX()
	             || y > this.getPositionY()+height
	             || y +/*sa hauteur*/ <this.getPositionY() )
		
	}

	@Override
	public boolean collidesWith(HitboxService hitbox) {
	   return belongsTo(hitbox.getPositionX(), hitbox.getPositionY());
	}
	
}
