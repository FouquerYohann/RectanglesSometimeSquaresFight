package components.factories;

import components.impl.game.EngineImpl;
import components.services.EngineService;
import components.services.PlayerService;
import contract.EngineContract;

public class EngineFactory {

	private final static int	defaultHeight	= 768;
	private final static int	defaultWidth	= 1024;
	private final static int	defaultDistance	= defaultWidth / 4;

	public static EngineService defaultBotEngine() {
		
		EngineImpl engieImpl = new EngineImpl();
		EngineService engie = new EngineContract(engieImpl);
		FighterFactory factory=new FighterFactory(engie);
		PlayerService defaultPlayer1 = PlayerFactory.newBouchonGaucheDroite();
		PlayerService defaultPlayer2 = PlayerFactory.newBouchonGaucheDroite();

		


		engie.init(defaultHeight, defaultWidth, defaultDistance,
				defaultPlayer1, defaultPlayer2,factory);
		
		return engie;
	}


	public static EngineService defaultEngine() {
		
		EngineImpl engieImpl = new EngineImpl();
		EngineService engie = new EngineContract(engieImpl);
		FighterFactory factory=new FighterFactory(engie);
		PlayerService defaultPlayer1 = PlayerFactory.newHumanPlayer("coucou");
		PlayerService defaultPlayer2 = PlayerFactory.newHumanPlayer("lala");

		


		engie.init(defaultHeight, defaultWidth, defaultDistance,
				defaultPlayer1, defaultPlayer2,factory);
		
		return engie;
	}
}
