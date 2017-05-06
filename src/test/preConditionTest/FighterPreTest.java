package test.preConditionTest;

import components.enums.Commande;
import components.impl.fighter.FighterImpl;
import components.impl.game.EngineImpl;
import components.services.EngineService;
import components.services.FighterService;
import contract.FighterContract;
import contract.util.PreconditionError;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class FighterPreTest {

	private FighterService	fighter;
	private EngineService	engine	= new EngineImpl();

	@Before
	public void beforeTest() {
		fighter = new FighterContract(new FighterImpl());
	}

	@Test
	public void testInitPos() {
		try {
			fighter.init(10, 10, 10, 10, true, engine);
		} catch (PreconditionError e) {
			fail();
		}
	}

	@Test
	public void testInitNeg1() {
		try {
			fighter.init(-10, 10, 10, 10, true, engine);
		} catch (PreconditionError e) {
			fail();
		}
	}

	@Test
	public void testInitNeg2() {
		try {
			fighter.init(10, -10, 10, 10, true, engine);
		} catch (PreconditionError e) {
			fail();
		}
	}

	@Test
	public void testStepPos() {
		try {
			fighter.step(Commande.NEUTRAL);
		} catch (PreconditionError e) {
			fail();
		}
	}

	@Test
	public void testStepNeg() {
		try {
			// TUER LE FIGHTER
			fighter.step(Commande.NEUTRAL);
//			fail();
		} catch (PreconditionError e) {

		}
	}
}
