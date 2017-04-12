package contract;

import components.services.HitboxService;
import contract.decorator.HitboxDecorator;
import contract.util.PostconditionError;

public class HitboxContract extends HitboxDecorator {
	private final static String	service	= "Hitbox";

	public HitboxContract(HitboxService delegate) {
		super(delegate);
	}

	public void checkInvariant() {
		// rien a tester
	}

	@Override
	public int getPositionX() {
		return super.getPositionX();
	}

	@Override
	public int getPositionY() {
		return super.getPositionY();
	}

	@Override
	public boolean belongsTo(int x, int y) {
		return super.belongsTo(x, y);
	}

	@Override
	public boolean collidesWith(HitboxService hitbox) {
		return super.collidesWith(hitbox);
	}

	@Override
	public boolean equalsTo(HitboxService hitbox) {
		return super.equalsTo(hitbox);
	}

	@Override
	public void init(int x, int y) {
		String method = "init";
		super.init(x, y);
		if (getPositionX() != x)
			throw new PostconditionError(service, method, "x devrais valoir "
					+ x + "apres l'initialisation");

		if (getPositionY() != y)
			throw new PostconditionError(service, method, "y devrais valoir "
					+ y + "apres l'initialisation");
		checkInvariant();
	}

	@Override
	public void moveTo(int x, int y) {
		String method = "moveTo";
		// je valide pas ce truc c'est la correction du partiel
		checkInvariant();
		// Capture
		int preX = getPositionX();
		int preY = getPositionY();
		boolean pre = belongsTo(preX, preY);
		boolean pre100 = belongsTo(preX + 100, preY + 100);
		boolean preAbs = belongsTo(300, 0);

		super.moveTo(x, y);

		checkInvariant();

		if ((!belongsTo(getPositionX(), getPositionY()) == pre))
			throw new PostconditionError(service, method,
					"euh y a une erreur je suppose");

		if ((!belongsTo(getPositionX() + 100, getPositionY() + 100) == pre100))
			throw new PostconditionError(service, method,
					"euh y a une erreur je suppose mais +100 donc ça va ");

		if ((!belongsTo(300 + (x - preX), 0 + (y - preY)) == preAbs))
			throw new PostconditionError(service, method,
					"euh y a une erreur absolu quoi que ça veuille dire ");
	}

}
