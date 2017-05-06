package test.preConditionTest;

import components.enums.Commande;
import components.factories.EngineFactory;
import components.factories.FighterFactory;
import components.factories.PlayerFactory;
import components.services.EngineService;
import components.services.PlayerService;
import contract.EngineContract;
import contract.util.InvariantError;
import contract.util.PreconditionError;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EnginePreTest {

	private EngineService	engine;

	@Before
	public void beforeTest() {
		engine = new EngineContract(EngineFactory.defaultBotEngine());
	}

	@Test
	public void testInvariant() {
		try {
			EngineContract.checkInvariant(engine);
			if (engine.getFighter(1).isDead() == true)
				if (engine.isGameOver() == false)
					Assert.fail();
			if (engine.getFighter(2).isDead() == true)
				if (engine.isGameOver() == false)
					Assert.fail();
		} catch (InvariantError ie) {

		}
	}

	@Test
	public void testGetFighterPos() {
		try {
			engine.getFighter(1);
			engine.getFighter(2);
		} catch (PreconditionError e) {
			Assert.fail();
		}
	}

	@Test
	public void testGetFighterNeg1() {
		try {
			engine.getFighter(0);
			Assert.fail();
		} catch (PreconditionError e) {

		}
	}

	@Test
	public void testGetFighterNeg2() {
		try {
			engine.getFighter(3);
			Assert.fail();
		} catch (PreconditionError e) {

		}
	}

	@Test
	public void testGetPlayerPos() {
		try {
			engine.getPlayer(1);
			engine.getPlayer(2);
		} catch (PreconditionError e) {
			Assert.fail();
		}
	}

	@Test
	public void testGetPlayerNeg1() {
		try {
			engine.getPlayer(0);
			Assert.fail();
		} catch (PreconditionError e) {

		}
	}

	@Test
	public void testGetPlayerNeg2() {
		try {
			engine.getPlayer(3);
			Assert.fail();
		} catch (PreconditionError e) {

		}
	}

	@Test
	public void testInitPos() {
		try {
			engine.init(100, 100, 10, PlayerFactory.newHumanPlayer("lolo"),
					PlayerFactory.newHumanPlayer("bo"), new FighterFactory(
							engine));

		} catch (PreconditionError e) {
			Assert.fail();
		}
	}

	@Test
	public void testInitNeg1() {
		try {
			engine.init(-2, 100, 10, PlayerFactory.newHumanPlayer("lolo"),
					PlayerFactory.newHumanPlayer("bo"), new FighterFactory(
							engine));
			Assert.fail();
		} catch (PreconditionError e) {

		}
	}

	@Test
	public void testInitNeg2() {
		try {
			engine.init(100, -2, -3, PlayerFactory.newHumanPlayer("lolo"),
					PlayerFactory.newHumanPlayer("bo"), new FighterFactory(
							engine));
			Assert.fail();
		} catch (PreconditionError e) {

		}
	}

	@Test
	public void testInitNeg3() {
		try {
			engine.init(100, 100, 1000, PlayerFactory.newHumanPlayer("lolo"),
					PlayerFactory.newHumanPlayer("bo"), new FighterFactory(
							engine));
			Assert.fail();
		} catch (PreconditionError e) {

		}
	}

	@Test
	public void testInitNeg4() {
		try {
			PlayerService p1 = PlayerFactory.newHumanPlayer("lolo");
			engine.init(100, 100, 1000, p1, p1, new FighterFactory(engine));
			Assert.fail();
		} catch (PreconditionError e) {

		}
	}

	@Test
	public void testStepPos() {
			try {
				engine.step(Commande.NEUTRAL, Commande.NEUTRAL);

			} catch (PreconditionError e) {
				Assert.fail();
			}
	}

	@Test
	public void testStepzNeg() {
		try {
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {}
			engine = EngineFactory.defaultBotEngine();
			engine.step(Commande.NEUTRAL, Commande.NEUTRAL);
			Assert.fail();
		} catch (PreconditionError e) {

		}
	}

}
