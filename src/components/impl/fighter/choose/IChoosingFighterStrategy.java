package components.impl.fighter.choose;

import components.factories.FighterFactory;
import components.services.ActiveFighterService;

public interface IChoosingFighterStrategy {
	public ActiveFighterService chooseFighter(FighterFactory factory, boolean faceRight);
}
