package contract.decorator;

import components.services.HitboxService;
import components.services.TechService;

public class TechDecorator implements TechService {
	private TechService delegate;

	public TechDecorator(TechService delegate) {
		super();
		this.delegate = delegate;
	}
	
	@Override
	public int getDamage() {
		return delegate.getDamage();
	}
	
	@Override
	public int getHstun() {
		return delegate.getHstun();
	}
	
	@Override
	public int getBstun() {
		return delegate.getBstun();
	}
	
	@Override
	public int getSframe() {
		return delegate.getSframe();
	}
	
	@Override
	public int getHframe() {
		return delegate.getHframe();
	}
	
	@Override
	public int getRframe() {
		return delegate.getRframe();
	}

	@Override
	public HitboxService getHitbox(int x, int y) {
		return delegate.getHitbox(x, y);
	}
	
	
	
	
	
	
}
