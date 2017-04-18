package components.factories;

import components.impl.FighterImpl;
import components.services.EngineService;
import components.services.FighterService;

public class FighterFactories {

	
	public static FighterService newFighter(boolean faceRight, EngineService unrealEngine){
		return new FighterImpl(10, 100, 300, 100, faceRight, unrealEngine);
	}
	
	public static FighterService newGroFighter(boolean faceRight, EngineService unrealEngine){
		return new FighterImpl(10, 100, 250, 200, faceRight, unrealEngine);
	}
}
