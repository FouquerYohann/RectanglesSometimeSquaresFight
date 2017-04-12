package components.services;

public interface HitboxService {

	// Observator
	/**
	 * @return position x of the hitbox <p>
	 */
	int getPositionX();

	/**
	 * @return position y of the hitbox
	 */
	int getPositionY();

	/**
	 * @param x
	 * @param y
	 */
	boolean belongsTo(int x, int y);

	/**
	 * @param hitbox
	 */
	boolean collidesWith(HitboxService hitbox);

	/**
	 * */
	boolean equalsTo(HitboxService hitbox);

	// Constructeur
	/**
	 * @param x
	 *            position x of the hitbox
	 * @param y
	 *            position y of the hitbox
	 * @post x == positionX() && y == positionY()
	 */
	void init(int x, int y);

	// Operator
	/**
	 * move the hitbox in x y
	 * 
	 * @param x
	 * @param y
	 * @post moveTo(x,y); x == positionX() && y == positionY() <p>
	 * /forall int u,v
	 *       H.belongsTo(u,v) <=>
	 *       H.belongsTo(u-(x-H.positionX()),v-(y-H.positionY()))
	 */
	void moveTo(int x, int y);

	// Invariants
	/*
	 * H1.collidesWith(H2) <=> /exist int x,y
	 * H1.belongsTo(x,y)^H2.belongsTo(x,y)
	 * 
	 * H1.equalsTo(H2) <=> /forall int x,y H1.belongsTo(x,y)==H2.belongsTo(x,y)
	 */
}
