package components.impl.fighter.choose;

import components.factories.FighterFactory;
import components.services.FighterService;

public interface IChoosingFighterStrategy {
	public FighterService chooseFighter(FighterFactory factory, boolean faceRight);
}
