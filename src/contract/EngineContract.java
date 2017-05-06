package contract;

import components.enums.Commande;
import components.factories.FighterFactory;
import components.services.ActiveFighterService;
import components.services.EngineService;
import components.services.PlayerService;
import contract.decorator.EngineDecorator;
import contract.util.InvariantError;
import contract.util.PostconditionError;
import contract.util.PreconditionError;

public class EngineContract extends EngineDecorator {

	public EngineContract(EngineService delegate) {
		super(delegate);
	}

	private final static String	service	= "Engine";

	public static void checkInvariant(EngineService delegate) {
		new EngineContract(delegate).checkInvariant();
	}

	@Override
	public ActiveFighterService getFighter(int i) {
		String method = "getFighter";
		if (i != 1 && i != 2)
			throw new PreconditionError(service, method, "i must be in {1,2}");
		return super.getFighter(i);
	}

	@Override
	public PlayerService getPlayer(int i) {
		String method = "getPlayer";
		if (i != 1 && i != 2)
			throw new PreconditionError(service, method, "i must be in {1,2}");
		return super.getPlayer(i);
	}

	public void checkInvariant() {
		for (int i = 1; i < 3; i++) {
			if (getFighter(i) == null)
				continue;
			if (getFighter(i).isDead() == true)
				if (isGameOver() == false)
					throw new InvariantError(service,
							"Game is not over even though one fighter is dead");
		}
		if (getTime() < 0 && isGameOver() == false)
			throw new InvariantError(service,
					"game is not over even thought time has run out");
	}

	@Override
	public void init(int height, int width, int distance, PlayerService p1,
			PlayerService p2, FighterFactory factory) {
		String method = "init";

		if (!(height > 0))
			throw new PreconditionError(service, method, " height < 0");
		if (!(width > 0))
			throw new PreconditionError(service, method, " width < 0");
		if (!(distance < width / 2))
			throw new PreconditionError(service, method, " distance < width/2");
		if (!(p1 != p2))
			throw new PreconditionError(service, method, "player 1 == player 2");

		super.init(height, width, distance, p1, p2, factory);

		checkInvariant();

		if (!(getHeight() == height))
			throw new PostconditionError(service, method,
					"height not initialized correctly");
		if (!(getWidth() == width))
			throw new PostconditionError(service, method,
					"width not initialized correctly");
		if (!(getPlayer(1) == p1))
			throw new PostconditionError(service, method,
					"player 1 not initilalized correctly");
		if (!(getPlayer(2) == p2))
			throw new PostconditionError(service, method,
					"player 2 not initilalized correctly");
		if (!(getFighter(1).getX() == distance))
			throw new PostconditionError(service, method,
					"fighter 1 x position not initilalized correctly "
							+ getFighter(1).getX());
		if (!(getFighter(2).getX() == width - distance))
			throw new PostconditionError(service, method,
					"fighter 2 x position not initilalized correctly");
		if (!(getFighter(1).getY() == 0))
			throw new PostconditionError(service, method,
					"fighter 1 y position not initilalized correctly");
		if (!(getFighter(2).getY() == 0))
			throw new PostconditionError(service, method,
					"fighter 2 y position not initilalized correctly");
		if (!(getFighter(1).isFacingRight() == true))
			throw new PostconditionError(service, method,
					"fighter 1 is not facing right");
		if (!(getFighter(2).isFacingRight() == false))
			throw new PostconditionError(service, method,
					"fighter 2 is not facing left");
		if ((getTime() < 0))
			throw new PostconditionError(service, method,
					"timer not initialized");

	}

	@Override
	public void step(Commande comP1, Commande comP2) {
		String method = "step";
		checkInvariant();

		ActiveFighterService preFighter1 = (ActiveFighterService) getFighter(1).clone();
		ActiveFighterService preFighter2 = (ActiveFighterService) getFighter(2).clone();

		if (!(isGameOver() == false))
			throw new PreconditionError(service, method, "Game is Over");
		
		
		
		preFighter1.step(comP1);
		super.step(comP1, comP2);
		preFighter2.step(comP2);
		
		if (!(getFighter(1).equals(preFighter1)))
			throw new PostconditionError(service, method,
					"step methods do not return same fighter 1\n"
							+ getFighter(1) + "\n" + preFighter1);
		if (!(getFighter(2).equals(preFighter2)))
			throw new PostconditionError(service, method,
					"step methods do not return same fighter 2\n"
							+ getFighter(2) + "\n" + preFighter2+"\n"+getFighter(2).getHitbox().getPositionX()+preFighter2.getHitbox().getPositionX());

		checkInvariant();
	}

}
