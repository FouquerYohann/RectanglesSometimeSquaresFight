package test.postConditionTest;


import components.factories.EngineFactory;
import components.factories.FighterFactory;
import components.factories.PlayerFactory;
import components.impl.game.EngineImpl;
import components.impl.hitbox.HitboxRectangleImpl;
import components.services.EngineService;
import components.services.FighterService;
import components.services.HitboxRectangleService;
import contract.FighterContract;
import contract.util.PostconditionError;
import org.junit.Before;
import org.junit.Test;
import test.implBug.ActiveFighterImplBug;

import static junit.framework.TestCase.fail;

public class ActiveFighterPostTest {

    private FighterService fighter;
    private ActiveFighterImplBug guru   = new ActiveFighterImplBug();
    private EngineService        engine = new EngineImpl();

    @Before
    public void beforeTest() {
        engine.init(100, 100, 100, PlayerFactory.newBouchonGaucheDroite(), PlayerFactory.newBouchonGaucheDroite(), new FighterFactory(EngineFactory.defaultBotEngine()));
        fighter = new FighterContract(guru);
    }

    public void fakeInit() {
        guru.setX(10);
        guru.setY(10);
        guru.setSpeed(10);
        guru.setLife(10);
        guru.setHeight(10);
        guru.setWidth(10);
        guru.setUnrealEngine(engine);
        guru.setFaceRight(false);
        guru.setBlockint(false);
        guru.setBlockstunned(false);
        guru.setTeching(false);
        guru.setTechFrame(false);
        guru.setCrouch(false);
        guru.setHitstunned(false);
        guru.setTechHasAlreadyHit(false);
        guru.setStunnCpt(0);
        guru.setTechCpt(0);
        guru.setOtherFighter(null);
        guru.setTech(null);
        HitboxRectangleService hitbox = new HitboxRectangleImpl(10, 10, 10, 10);
        hitbox.init(10, 10);
        guru.setHitbox(hitbox);
    }



    @Test
    public void testInvariant(){
        fakeInit();
        guru.setBlockint(true);
        guru.setBlockstunned(true);

    }

    @Test
    public void testInitPositif() {
        try {
            fakeInit();

            fighter.init(10, 10, 10, 10, false, engine);

        } catch (PostconditionError e) {
            fail();
        }
        return;
    }

    @Test
    public void testInitLife() {
        try {
            fakeInit();
            guru.setLife(20);
            fighter.init(10, 10, 10, 10, false, engine);
            fail();
        } catch (PostconditionError e) {

        }
    }

    @Test
    public void testInitSpeed() {
        try {
            fakeInit();
            guru.setSpeed(20);
            fighter.init(10, 10, 10, 10, false, engine);
            fail();
        } catch (PostconditionError e) {

        }
    }

    @Test
    public void testInitHeight() {
        try {
            fakeInit();
            guru.setHeight(20);
            fighter.init(10, 10, 10, 10, false, engine);
            fail();
        } catch (PostconditionError e) {

        }
    }

    @Test
    public void testInitWidth() {
        try {
            fakeInit();
            guru.setWidth(20);
            fighter.init(10, 10, 10, 10, false, engine);
            fail();
        } catch (PostconditionError e) {

        }
    }

    @Test
    public void testInitFaceRight() {
        try {
            fakeInit();
            guru.setFaceRight(true);
            fighter.init(10, 10, 10, 10, false, engine);
            fail();
        } catch (PostconditionError e) {

        }
    }

    @Test
    public void testInitUnrealEngine() {
        try {
            fakeInit();
            EngineService en = new EngineImpl();
            en.init(120, 120, 20, PlayerFactory.newBouchonGaucheDroite(), PlayerFactory.newBouchonGaucheDroite(), new FighterFactory(EngineFactory.defaultBotEngine()));
            guru.setUnrealEngine(en);
            fighter.init(10, 10, 10, 10, false, engine);
            fail();
        } catch (PostconditionError e) {

        }
    }

    @Test
    public void testInitEqualUnrealEngine() {
        try {
            fakeInit();
            EngineService nEngine = new EngineImpl();
            nEngine.init(110, 110, 10, PlayerFactory.newBouchonGaucheDroite(), PlayerFactory.newBouchonGaucheDroite(), new FighterFactory(EngineFactory.defaultEngine()));
            guru.setUnrealEngine(nEngine);
            fighter.init(10, 10, 10, 10, false, engine);
            fail();
        } catch (PostconditionError e) {

        }
    }


}
