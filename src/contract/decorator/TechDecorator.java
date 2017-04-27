package contract.decorator;

import components.services.FighterService;
import components.services.HitboxRectangleService;
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
	public HitboxRectangleService getHitbox() {
		return delegate.getHitbox();
	}

	@Override
	public void moveTo(FighterService fighter) {
		delegate.moveTo(fighter);		
	}
	
	
	
	
	
	
}
