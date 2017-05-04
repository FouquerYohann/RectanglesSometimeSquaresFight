package components.services;

public interface ActiveFighterService extends FighterService {

	// OBSERVATORS

	boolean isBlocking();

	boolean isBlockstunned();

	boolean isHitstunned();

	boolean isTeching();

	int getStunnCpt();

	/** @require isTeching() */
	TechService tech();

	/** @require isTeching() */
	boolean techFrame();

	/** @require isTeching() */
	boolean techHasAlreadyHit();

	// OPERATOR

	/** @require !isTeching()
	 * @post isTeching() */
	void startTech(TechService tech);

	/**
	 * @require life>0 && speed>0 && height>0 && width>0
	 * @post !isBlocking(F) && !isBlockstunned(F) && !isHitstunned() && !isTeching()
	 */
	public void init(int life, int speed, int height, int width,
			boolean lookRight, EngineService unrealEngine);

	
	/*
	 * INVARIANT
	 * isBlocking(F) && !isBlockstunned(F) && !isHitstunned() && !isTeching()
	 * ||!isBlocking(F) && isBlockstunned(F) && !isHitstunned() && !isTeching()
	 * ||!isBlocking(F) && !isBlockstunned(F) && isHitstunned() && !isTeching()
	 * ||!isBlocking(F) && !isBlockstunned(F) && !isHitstunned() && isTeching()
	 * ||!isBlocking(F) && !isBlockstunned(F) && !isHitstunned() && !isTeching() */
	
}
