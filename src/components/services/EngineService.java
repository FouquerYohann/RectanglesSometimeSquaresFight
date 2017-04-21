package components.services;

import java.util.function.LongToIntFunction;

import components.enums.CommandeMovement;
import components.factories.FighterFactory;

public interface EngineService {
	// Observator
	/**
	 * @return position height of stage
	 */
	public int getHeight();

	/**
	 * @return position width of stage
	 */
	public int getWidth();

	
	/**
	 * 
	 * @return return the time left for the fight
	 */
	public long getTime();
	/**
	 * @return distance from the wall
	 */
	public int getDistance();

	/**
	 * @require i==1 or i==2
	 * @return the i-th fighter
	 */
	public FighterService getFighter(int i);

	/**
	 * @require i==1 or i==2
	 * @return the i-th player
	 */
	public PlayerService getPlayer(int i);

	/**
	 * @return true if game is over false otherwise
	 */
	public boolean isGameOver();

	// Invariant
	/*
	 * this.isGameOver()= /exist i in {1,2} where getFighter(i).isDead==true || getTimer()<=0
	 */

	// Constructor
	/**
	 * @require height>0 and width>0 and distance< width/2 and p1!=p2
	 * 
	 * @param heigth
	 *            of stage
	 * @param width
	 *            of stage
	 * @param distance
	 *            from bounds
	 * @param p1
	 *            player 1
	 * @param p2
	 *            player 2
	 *
	 * @post getHeight(init(h,w,d,p1,p2))==h &&
	 *       <p>
	 *       getWidth(init(h,w,d,p1,p2))==w &&
	 *       <p>
	 *       getPlayer(init(h,w,d,p1,p2),1)==p1 &&
	 *       <p>
	 *       getPlayer(init(h,w,d,p1,p2),2)==p2 &&
	 *       <p>
	 *       getFighter(init(h,w,d,p1,p2),1).getX()==d &&
	 *       <p>
	 *       getFighter(init(h,w,d,p1,p2),2).getX()==w-d &&
	 *       <p>
	 *       getFighter(init(h,w,d,p1,p2),1).getY()==0 &&
	 *       <p>
	 *       getFighter(init(h,w,d,p1,p2),2).getY()==0 &&
	 *       <p>
	 *       getFighter(init(h,w,d,p1,p2),1).isFacingRight==true &&
	 *       <p>
	 *       getFighter(init(h,w,d,p1,p2),2).isFacingRight==false
	 *       <p>
	 *       getTime() != null
	 *
	 */
	public void init(int height, int width, int distance, PlayerService p1,
			PlayerService p2,FighterFactory factory);

	// Operator
	/**
	 * @require this.isGameOver() == false
	 * 
	 * @post getFighter(1)== @pre getFighter(1).step(comP1) getFighter(2)== @pre
	 *       getFighter(2).step(comP2)
	 * 
	 */
	public void step(CommandeMovement comP1, CommandeMovement comP2);

}
