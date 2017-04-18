package components.factories;

import components.impl.EngineImpl;
import components.services.EngineService;
import components.services.PlayerService;
import contract.EngineContract;

public class EngineFactory {

	private final static int	defaultHeight	= 768;
	private final static int	defaultWidth	= 1024;
	private final static int	defaultDistance	= defaultWidth / 4;

	public static EngineService defaultEngine() {
		
		EngineImpl engieImpl = new EngineImpl();
		EngineService engie = new EngineContract(engieImpl);
		FighterFactory factory=new FighterFactory(engie);
		PlayerService defaultPlayer1 = PlayerFactory.newBouchonGaucheDroite(factory);
		PlayerService defaultPlayer2 = PlayerFactory.newBouchonGaucheDroite(factory);


		


		engie.init(defaultHeight, defaultWidth, defaultDistance,
				defaultPlayer1, defaultPlayer2);
		
		return engie;
	}
}