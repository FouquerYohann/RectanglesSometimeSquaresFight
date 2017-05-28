package components.factories;

import components.impl.game.EngineImpl;
import components.services.EngineService;
import components.services.PlayerService;

public class EngineFactory {

	private final static int	defaultHeight	= 768;
	private final static int	defaultWidth	= 1024;
	private final static int	defaultDistance	= defaultWidth / 4;

	public static EngineService defaultBotEngine() {

		EngineImpl engieImpl = new EngineImpl();
		FighterFactory factory = new FighterFactory(engieImpl);
		PlayerService defaultPlayer1 = PlayerFactory.newBouchonGaucheDroite();
		PlayerService defaultPlayer2 = PlayerFactory.newBouchonGaucheDroite();

		engieImpl.init(defaultHeight, defaultWidth, defaultDistance,
		        defaultPlayer1, defaultPlayer2, factory);

		return engieImpl;
	}

	public static EngineService defaultEngine() {

		EngineImpl engieImpl = new EngineImpl();
		FighterFactory factory = new FighterFactory(engieImpl);
		PlayerService defaultPlayer1 = PlayerFactory.newHumanPlayer("coucou");
		PlayerService defaultPlayer2 = PlayerFactory.newHumanPlayer("azeazedqsd");

		engieImpl.init(defaultHeight, defaultWidth, defaultDistance,
		        defaultPlayer1, defaultPlayer2, factory);

		return engieImpl;
	}

	public static EngineService randomEngine() {

		EngineImpl engieImpl = new EngineImpl();
		FighterFactory factory = new FighterFactory(engieImpl);
		PlayerService defaultPlayer1 = PlayerFactory.randomPlayer();
		PlayerService defaultPlayer2 = PlayerFactory.randomPlayer();

		engieImpl.init(defaultHeight, defaultWidth, defaultDistance,
		        defaultPlayer1, defaultPlayer2, factory);

		return engieImpl;
	}
}
