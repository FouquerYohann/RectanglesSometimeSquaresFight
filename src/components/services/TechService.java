package components.services;

public interface TechService {
	int getDamage();

	int getHstun();

	int getBstun();

	int getSframe();

	int getHframe();

	int getRframe();

	HitboxService getHitbox(int x, int y);
}
