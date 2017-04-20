package components.impl.fighter.choose;

import java.util.Random;

import components.enums.FighterName;
import components.factories.FighterFactory;
import components.services.FighterService;

public class ChoosingRandomFighterStrategy implements IChoosingFighterStrategy {

	@Override
	public FighterService chooseFighter(FighterFactory factory,boolean faceRight) {
		int pick = new Random().nextInt(FighterName.values().length);
		return factory.getFighter(FighterName.values()[pick], faceRight);
	}

}
