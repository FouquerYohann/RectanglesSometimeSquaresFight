package components.services;

public interface HitboxRectangleService extends HitboxService{

	/**
	 * 
	 * @return height of rectangle
	 */
	public int getHeight();
	/**
	 * 
	 * @return width of rectangle
 	 */
	public int getWidth();
	
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param height
	 * @param width
	 * 
	 * @pre
	 * 		height>0 && width >0
	 * @post
	 * 	getHeight()==height
	 *  getWidth()==width
	 */
	public void init(int x,int y, int height, int width);
	
}
