package test.postConditionTest;


import com.sun.xml.internal.ws.api.pipe.Engine;
import components.factories.FighterFactory;
import components.factories.PlayerFactory;
import components.impl.fighter.choose.ChoosingRandomFighterStrategy;
import components.impl.fighter.choose.IChoosingFighterStrategy;
import components.impl.game.EngineImpl;
import components.services.EngineService;
import components.services.PlayerService;
import contract.EngineContract;
import org.junit.Before;
import org.junit.Test;
import test.implBug.EngineImplBug;

public class EnginePostTest {

    private FighterFactory fFact= new FighterFactory();
    private IChoosingFighterStrategy icfs= new ChoosingRandomFighterStrategy();
    private EngineImplBug enBug=new EngineImplBug();
    private EngineService engine;

    @Before
    public void beforeTest(){

    }

    public void fakeInit(){
        enBug.setHeight(10);
        enBug.setWidth(10);
        enBug.setDistance(10);
        enBug.setPlayer1(PlayerFactory.newBouchonGaucheDroite());
        enBug.setPlayer2(PlayerFactory.newBouchonGaucheDroite());
        enBug.setTimer(300);
        enBug.setFighter1(icfs.chooseFighter(fFact,true));
        enBug.setFighter2(icfs.chooseFighter(fFact,false));
        engine=new EngineContract(enBug);
    }


    @Test
    public void testInitHeight(){

    }

}
