package contract.util;

import components.services.HitboxService;

public class HitboxDecorator implements HitboxService {

	private HitboxService delegate;
	
	
	public HitboxDecorator(HitboxService delegate) {
		super();
		this.delegate = delegate;
	}

	@Override
	public int getPositionX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPositionY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean belongsTo(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean collidesWith(HitboxService hitbox) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean equalsTo(HitboxService hitbox) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void init(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub

	}

}
