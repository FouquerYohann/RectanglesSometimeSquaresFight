package components.impl;

import components.enums.CommandeMovement;
import components.services.EngineService;
import components.services.FighterService;
import components.services.PlayerService;

public class EngineImpl implements EngineService {
	private int				height;
	private int				width;
	private int				distance;
	private FighterService	fighter1;
	private FighterService	fighter2;
	private PlayerService	player1;
	private PlayerService	player2;

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
	public FighterService getFighter(int i) {
		return (i == 1) ? fighter1 : fighter2;
	}

	@Override
	public PlayerService getPlayer(int i) {
		return (i == 1) ? player1 : player2;
	}

	@Override
	public boolean isGameOver() {
		return (fighter1.isDead() || fighter2.isDead());
	}

	@Override
	public void init(int height, int width, int distance, PlayerService p1,
			PlayerService p2) {
		this.height = height;
		this.width = width;
		this.distance = distance;
		this.player1 = p1;
		this.player2 = p2;
		
		
	}

	@Override
	public void step(CommandeMovement comP1, CommandeMovement comP2) {
		fighter1.step(comP1);
		fighter2.step(comP2);

	}

	@Override
	public int getDistance() {
		return distance;
	}
}
