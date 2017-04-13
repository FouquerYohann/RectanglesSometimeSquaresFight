package components.services;

import components.enums.COMMANDE;

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
     * 		∃ hitbox H, such as getHitbox()==H
     * 
     */
    public void init(int life,int speed,boolean lookRight,EngineService unrealEngine);
    
    
    //Operators
    /**
     * @post
     * 		∃ i such as getEngine().getFighter(i) != this && <p>
     * 		getHitbox().collidesWith(getEngine().getFighter(i).getHitbox())  => getX() == @pre getX() <p>
     * 		getX() > getSpeed() &&
     * 		∀ i getEngine().getFighter(i) != this => !getHitbox().collidesWith(getEngine().getFighter(i).getHitox()) => getX()== @pre getX() - getSpeed() 
     * 		getX() <= getSpeed() && 
     * 		∀ i getEngine().getFighter(i) != this => !getHitbox().collidesWith(getEngine().getFighter(i).getHitox()) => getX()== 0
     * 		isFacingRight() == @pre isFacingRight() && getLife() == @pre getLife()
     * 		getY()= @pre getY()
     */
    public void moveLeft();
    /**
     * @post
     * 		∃ i such as getEngine().getFighter(i) != this && <p>
     * 		getHitbox().collidesWith(getEngine().getFighter(i).getHitbox())  => getX() == @pre getX() <p>
     * 		getX() >= getEngine().getWidth() - getSpeed() &&
     * 		∀ i getEngine().getFighter(i) != this => !getHitbox().collidesWith(getEngine().getFighter(i).getHitox()) => getX()== getEngine().getWidth() 
     * 		getX() < getEngine().getWidth() - getSpeed() && 
     * 		∀ i getEngine().getFighter(i) != this => !getHitbox().collidesWith(getEngine().getFighter(i).getHitox()) => getX()== @pre getX() - getSpeed()
     * 		isFacingRight() == @pre isFacingRight() && getLife() == @pre getLife()
     * 		getY()= @pre getY()
     */
    
    public void moveRight();
    
    /**
     * 	@post
     * 		isFacingRight() != @pre isFacingRight()
     * 		getX() = @pre getX() && getY() = @pre getY()
     */
    public void switchSide();
    
    /**
     * 
     * @param c COMMANDE
     *      
     * @post 
     * 		step(LEFT)  == moveLeft()
     * 		step(RIGHT) == moveRight()
     * 		step(NEUTRAL) == this
     */
    
    public void step(COMMANDE c);
    
}
