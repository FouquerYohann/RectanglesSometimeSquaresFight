package contract.decorator;

import components.services.HitboxService;

public class HitboxDecorator implements HitboxService {

	private HitboxService	delegate;

	public HitboxDecorator(HitboxService delegate) {
		super();
		this.delegate = delegate;
	}

	@Override
	public int getPositionX() {
		return delegate.getPositionX();
	}

	@Override
	public int getPositionY() {

		return delegate.getPositionY();
	}

	@Override
	public boolean belongsTo(int x, int y) {
		return delegate.belongsTo(x, y);
	}

	@Override
	public boolean collidesWith(HitboxService hitbox) {
		return delegate.collidesWith(hitbox);
	}

	@Override
	public boolean equalsTo(HitboxService hitbox) {
		return delegate.equalsTo(hitbox);
	}

	@Override
	public void init(int x, int y) {
		delegate.init(x, y);
	}

	@Override
	public void moveTo(int x, int y) {
		delegate.moveTo(x, y);
	}

}
