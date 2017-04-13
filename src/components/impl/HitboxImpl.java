package components.impl;

import components.services.HitboxService;

public class HitboxImpl implements HitboxService {
    private int x;
    private int y;
    
    
    
    public HitboxImpl(int x, int y) {
	super();
	init(x,y);
    }

    @Override
    public int getPositionX() {
	return x;
    }

    @Override
    public int getPositionY() {
	return y;
    }

    @Override
    public boolean belongsTo(int x, int y) {
	return (this.x==x && this.y==y);
    }

    @Override
    public boolean collidesWith(HitboxService hitbox) {
	return this.belongsTo(hitbox.getPositionX(), hitbox.getPositionY());
    }

    @Override
    public boolean equalsTo(HitboxService hitbox) {
	return (this==hitbox);
    }

    @Override
    public void init(int x, int y) {
	this.x=x;
	this.y=y;
    }

    @Override
    public void moveTo(int x, int y) {
	this.x=x;
	this.y=y;
    }

}
