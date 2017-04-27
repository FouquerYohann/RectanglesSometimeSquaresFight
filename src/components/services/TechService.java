package components.services;

public interface TechService {
	int getDamage();

	int getHstun();

	int getBstun();

	int getSframe();

	int getHframe();

	int getRframe();

	HitboxRectangleService getHitbox();
	
	void moveTo(FighterService fighter);
}
