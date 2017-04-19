package components.impl.fighter;

import components.factories.FighterFactory;
import components.services.FighterService;

public interface IChoosingFighterStrategy {
	public FighterService chooseFighter(FighterFactory factory, boolean faceRight);
}
