package test.implBug;

import components.enums.Commande;
import components.factories.FighterFactory;
import components.services.ActiveFighterService;
import components.services.EngineService;
import components.services.PlayerService;

public class EngineImplBug implements EngineService {
	private static final long	TIME	= 50;
	private int height;
	private int width;

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public void setTimer(long timer) {
		this.timer = timer;
	}

	public void setFighter1(ActiveFighterService fighter1) {
		this.fighter1 = fighter1;
	}

	public void setFighter2(ActiveFighterService fighter2) {
		this.fighter2 = fighter2;
	}

	public void setPlayer1(PlayerService player1) {
		this.player1 = player1;
	}

	public void setPlayer2(PlayerService player2) {
		this.player2 = player2;
	}

	private int distance;
	private long timer=-1;
	private ActiveFighterService fighter1;
	private ActiveFighterService fighter2;
	private PlayerService player1;
	private PlayerService player2;

	public EngineImplBug() {
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
		return (fighter1.isDead() || fighter2.isDead() || getTime()<0 );
	}

	@Override
	public void init(int height, int width, int distance, PlayerService p1, PlayerService p2, FighterFactory factory) {

	}

	@Override
	public void step(Commande comP1, Commande comP2) {
		if(comP1 == Commande.NEUTRAL && comP2==Commande.NEUTRAL)
		    return;
        fighter1.step(comP1);
        fighter2.step(comP2);
        fighter2.step(comP2);
        fighter1.step(comP1);
        fighter1.step(comP1);

    }

	@Override
	public int getDistance() {
		return distance;
	}

	@Override
	public long getTime() {
		long timeNow=System.currentTimeMillis();
		
		return (TIME- (timeNow-timer)/1000);
	}
}
