package components.services;

import components.enums.Commande;

public interface FighterService {
    //Observator
    /**
     * @return x position of the fighter
     */
    public int getX();
    /**
     * @return y position of the fighter
     */
    public int getY();
    /**
     * @return the engine in which the fighter is
     */
    public EngineService getEngine();
    /**
     * @return the hitbox of the fighter
     */
    public HitboxService getHitbox();
    /**
     * @return life points of the fighter
     */
    public int getLife();
    /**
     * @return the speed of the fighter
     */
    public int getSpeed();
    /**
     * @return true if fighter is facing right
     */
    public boolean isFacingRight();
    /**
     * @return true if fighter is dead
     */
    public boolean isDead();
    
    
    //Invariant
    /*
     * getX()>0 && getX()<getEngine.getWidth()
     * getY()>0 && getY()<getEngine.getHeight()
     * isDead() == !(getLife()>0)
     * 
     */
    
    //Constructors
    /**
     * 
     * @param life
     * @param speed
     * @param lookRight
     * @param unrealEngine
     * 
     * @require life >0 && speed >0
     * 
     * @post 
     * 		getLife()=life     && <p>
     * 		getSpeed()= speed  && <p>
     * 		isFacingRight() == lookRight && <p>
     * 		getEngine()== unrealEngine && <p>
     * 		∃ hitbox H such as getHitbox()==H
     * 
     */
    public void init(int life,int speed,boolean lookRight,EngineService unrealEngine);
    
    
    //Operators
    public void moveLeft();
    public void moveRight();
    public void switchSide();
    public void step(Commande c);
    
}
