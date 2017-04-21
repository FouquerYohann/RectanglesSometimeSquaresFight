package contract.decorator;

import components.services.HitboxRectangleService;
import components.services.HitboxService;

public class HitboxRectangleDecorator implements HitboxRectangleService {
	private HitboxRectangleService delegate;

	
	
	public HitboxRectangleDecorator(HitboxRectangleService delegate) {
		super();
		this.delegate = delegate;
	}

	public int getPositionX() {
		return delegate.getPositionX();
	}

	public int getHeight() {
		return delegate.getHeight();
	}

	public int getPositionY() {
		return delegate.getPositionY();
	}

	public int getWidth() {
		return delegate.getWidth();
	}

	public boolean belongsTo(int x, int y) {
		return delegate.belongsTo(x, y);
	}

	public boolean collidesWith(HitboxService hitbox) {
		return delegate.collidesWith(hitbox);
	}

	public boolean equalsTo(HitboxService hitbox) {
		return delegate.equalsTo(hitbox);
	}

	public void init(int x, int y) {
		delegate.init(x, y);
	}

	public void moveTo(int x, int y) {
		delegate.moveTo(x, y);
	}

	@Override
	public void init(int x, int y, int height, int width) {
		delegate.init(x, y, height, width);		
	}
	
	
}
