package components.services;

import components.enums.COMMANDE;

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
     * @require i==1 or i==2
     * @return the i-th fighter
     */
    public FighterService getChar(int i);

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
     * this.isGameOver()= /exist i in {1,2} where getPlayer(i).isDead==true
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
     * @post 
     *       getHeight(init(h,w,d,p1,p2))==h<p>
     *       getWidth(init(h,w,d,p1,p2))==w<p>
     *       getPlayer(init(h,w,d,p1,p2),1)==p1<p>
     *       getPlayer(init(h,w,d,p1,p2),2)==p2<p>
     *       getPlayer(init(h,w,d,p1,p2),1).getX()==d<p>
     *       getPlayer(init(h,w,d,p1,p2),2).getX()==w-d<p>
     *       getPlayer(init(h,w,d,p1,p2),1).getY()==0<p>
     *       getPlayer(init(h,w,d,p1,p2),2).getY()==0<p>
     *       getPlayer(init(h,w,d,p1,p2),1).isFacingRight==true<p>
     *       getPlayer(init(h,w,d,p1,p2),2).isFacingRight==false<p>
     *
     */
    public void init(int height, int width, int distance, PlayerService p1,
	    PlayerService p2);

    // Operator
    /**
     * @require this.isGameOver() == false
     * 
     */
    public void step(COMMANDE comP1, COMMANDE comP2);

}
