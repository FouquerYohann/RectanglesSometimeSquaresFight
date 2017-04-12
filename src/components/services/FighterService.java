package components.services;

public interface FighterService {
    public int getX();
    public int getY();
    public EngineService getEngine();
    public HitboxService getHitbox();
    public int getLife();
    public int getSpeed();
    public boolean isFacingRight();
    public boolean isDead();
    public void init(int life,int speed,boolean lookRight,EngineService unrealEngine);
    public void moveLeft();
    public void moveRight();
    public void switchSide();
    public void step();
    
}
