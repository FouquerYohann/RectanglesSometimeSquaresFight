package test.postConditionTest;


import components.enums.Commande;
import components.factories.FighterFactory;
import components.factories.PlayerFactory;
import components.impl.fighter.choose.ChoosingRandomFighterStrategy;
import components.impl.fighter.choose.IChoosingFighterStrategy;
import components.impl.player.PlayerImpl;
import components.services.EngineService;
import components.services.PlayerService;
import contract.EngineContract;
import contract.util.PostconditionError;
import org.junit.Before;
import org.junit.Test;
import test.implBug.EngineImplBug;

import static junit.framework.TestCase.fail;

public class EnginePostTest {

    private PlayerService p1;
    private PlayerService p2;
    private IChoosingFighterStrategy icfs = new ChoosingRandomFighterStrategy();
    private EngineImplBug enBug = new EngineImplBug();
    private FighterFactory fFact;
    private EngineService engine;

    @Before
    public void beforeTest() {
        fakeInit();
    }

    public void fakeInit() {
        enBug.setHeight(768);
        enBug.setWidth(1024);
        enBug.setDistance(10);
        enBug.setPlayer1(PlayerFactory.newBouchonGaucheDroite());
        p1 = enBug.getPlayer(1);
        enBug.setPlayer2(PlayerFactory.newBouchonGaucheDroite());
        p2 = enBug.getPlayer(2);
        enBug.setTimer(System.currentTimeMillis());

        fFact = new FighterFactory(enBug);
        enBug.setFighter1(icfs.chooseFighter(fFact, true));
        enBug.setFighter2(icfs.chooseFighter(fFact, false));

        engine = new EngineContract(enBug);
    }


    @Test
    public void testInitPositif() {
        try {
            fakeInit();
            engine.init(10, 30, 10, p1, p2, fFact);
        } catch (PostconditionError e) {
            System.out.println(e);
            fail();
        }
    }

    @Test
    public void testInitHeight() {
        try {
            fakeInit();
            enBug.setHeight(20);
            engine.init(10, 30, 10, p1, p2, fFact);
            fail();
        } catch (PostconditionError e) {
            System.out.println("Height " + e);
        }
    }

    @Test
    public void testInitWidth() {
        try {
            fakeInit();
            enBug.setWidth(20);
            engine.init(10, 30, 10, p1, p2, fFact);
            fail();
        } catch (PostconditionError e) {
            System.out.println("Width " + e);
        }
    }

    @Test
    public void testPlayer1() {
        try {
            fakeInit();
            enBug.setPlayer1(new PlayerImpl());
            engine.init(10, 30, 10, p1, p2, fFact);
            fail();
        } catch (PostconditionError e) {
            System.out.println("Player 1 " + e);
        }
    }

    @Test
    public void testInitPlayer2() {
        try {
            fakeInit();
            enBug.setPlayer2(new PlayerImpl());
            engine.init(10, 30, 10, p1, p2, fFact);
            fail();
        } catch (PostconditionError e) {
            System.out.println("Player 2 " + e);
        }
    }

    @Test
    public void testInitDistance() {
        try {
            fakeInit();
            enBug.setDistance(20);
            engine.init(10, 30, 10, p1, p2, fFact);
            fail();
        } catch (PostconditionError e) {
            System.out.println("Distance " + e);
        }
    }

//    @Test
//    public void testInitDistance2(){
//        try{
//            fakeInit();
//            enBug.getFighter(2);
//            engine.init(10,30,10,p1,p2,fFact);
//            fail();
//        }catch (PostconditionError e){
//        }
//    }


    @Test
    public void testInitFacingRight1() {
        try {
            fakeInit();
            enBug.setFighter1(icfs.chooseFighter(fFact, false));
            engine.init(10, 30, 10, p1, p2, fFact);
            fail();
        } catch (PostconditionError e) {
            System.out.println("Facing Right 1 " + e);
        }
    }

    @Test
    public void testInitFacingRight2() {
        try {
            fakeInit();
            enBug.setFighter2(icfs.chooseFighter(fFact, true));
            engine.init(10, 30, 10, p1, p2, fFact);
            fail();
        } catch (PostconditionError e) {
            System.out.println("FAcing Right 2" + e);
        }
    }

    @Test
    public void testInitTimer() {
        try {
            fakeInit();
            enBug.setTimer(-50);
            engine.init(10, 30, 10, p1, p2, fFact);
            fail();
        } catch (PostconditionError e) {
            System.out.println("TIMER " + e);
        }
    }

    @Test
    public void testStepPositif() {
        try {
            fakeInit();
            engine.step(Commande.NEUTRAL, Commande.NEUTRAL);
        } catch (PostconditionError e) {
            fail();
        }
    }


    @Test
    public void testStepComP1() {
        try {
            fakeInit();
            engine.step(Commande.RIGHT, Commande.NEUTRAL);
            fail();
        } catch (PostconditionError e) {
            System.out.println(e);
        }
    }

    @Test
    public void testStepComP2() {
        try {
            fakeInit();
            engine.step(Commande.NEUTRAL, Commande.LEFT);
            fail();
        } catch (PostconditionError e) {
            System.out.println(e);
        }
    }



}
