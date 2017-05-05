package components.impl.techniques;

import components.services.TechService;

public abstract class TechImpl implements TechService {
	private int	damage;
	private int	hstun;
	private int	bstun;
	private int	sframe;
	private int	hframe;
	private int	rframe;

	public TechImpl(int damage, int hstun, int bstun, int sframe, int hframe,
			int rframe) {
		super();
		this.damage = damage;
		this.hstun = hstun;
		this.bstun = bstun;
		this.sframe = sframe;
		this.hframe = hframe;
		this.rframe = rframe;
	}

	@Override
	public int getDamage() {
		return damage;
	}

	@Override
	public int getHstun() {
		return hstun;
	}

	@Override
	public int getBstun() {
		return bstun;
	}

	@Override
	public int getSframe() {
		return sframe;
	}

	@Override
	public int getHframe() {
		return hframe;
	}

	@Override
	public int getRframe() {
		return rframe;
	}

}
