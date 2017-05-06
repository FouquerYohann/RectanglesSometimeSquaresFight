package test.preConditionTest;

import components.impl.hitbox.HitboxImpl;
import components.services.HitboxService;
import contract.HitboxContract;
import contract.util.PostconditionError;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class HitboxPreTest {
	private HitboxService	hitbox;

	@Before
	public void beforeTest() {
		hitbox = new HitboxContract( new HitboxImpl(0, 0));
	}

	// INIT
	@Test
	public void TestInitPost() {
		try {
			int x = 0, y = 0;
			hitbox.init(x, y);
			if (x != hitbox.getPositionX() || y != hitbox.getPositionY())
				fail();
		} catch (PostconditionError e) {}
	}
	
	@Test
	public void TestMoveTo(){
		fail("test not implemented yet");
	}

}
