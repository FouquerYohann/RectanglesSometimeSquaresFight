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
	    System.out.println("other : "+x+" "+y);
	    System.out.println("this  : "+ this.getPositionX()+" "+this.getPositionY());
	    System.out.println("this2 : "+ (this.getPositionX()+width)+" "+(this.getPositionY()+height));
		 //TODO other.height
		return ( x <= this.getPositionX() && this.getPositionX() <= x+width ) 
		     && (y <= this.getPositionY() && this.getPositionY() <= y+height);
	}

	@Override
	public boolean collidesWith(HitboxService hitbox) {
	   return belongsTo(hitbox.getPositionX(), hitbox.getPositionY());
	}
	
}
