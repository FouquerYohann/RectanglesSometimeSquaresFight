package components.impl.game;

import components.enums.Commande;
import components.factories.FighterFactory;
import components.services.ActiveFighterService;
import components.services.EngineService;
import components.services.PlayerService;
import tools.configuration.GameConfiguration;

public class EngineImpl implements EngineService {
	private static final long		TIME	= GameConfiguration.TIME;
	private int						height;
	private int						width;
	private int						distance;
	private long					timer	= -1;
	private ActiveFighterService	fighter1;
	private ActiveFighterService	fighter2;
	private PlayerService			player1;
	private PlayerService			player2;

	public EngineImpl() {
		super();
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public ActiveFighterService getFighter(int i) {
		return (i == 1) ? fighter1 : fighter2;
	}

	@Override
	public PlayerService getPlayer(int i) {
		return (i == 1) ? player1 : player2;
	}

	@Override
	public boolean isGameOver() {
		return (fighter1.isDead() || fighter2.isDead() || getTime() < 0);
	}

	@Override
	public void init(int height, int width, int distance, PlayerService p1, PlayerService p2,
	        FighterFactory factory) {
		this.height = height;
		this.width = width;
		this.distance = distance;
		this.player1 = p1;
		this.player2 = p2;
		this.timer = System.currentTimeMillis();
		fighter1 = p1.chooseFighter(factory, true);
		fighter2 = p2.chooseFighter(factory, false);
	}

	@Override
	public void step(Commande comP1, Commande comP2) {

		fighter1.step(comP1);
		fighter2.step(comP2);

	}

	@Override
	public int getDistance() {
		return distance;
	}

	@Override
	public long getTime() {
		long timeNow = System.currentTimeMillis();

		return (TIME - (timeNow - timer) / 1000);
	}
}
