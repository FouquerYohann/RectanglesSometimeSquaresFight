package test.postConditionTest;


import com.sun.xml.internal.ws.api.pipe.Engine;
import components.factories.FighterFactory;
import components.factories.PlayerFactory;
import components.impl.game.EngineImpl;
import components.services.EngineService;
import components.services.PlayerService;
import contract.EngineContract;
import org.junit.Before;
import org.junit.Test;
import test.implBug.EngineImplBug;

public class EnginePostTest {

    private EngineService engine;

    @Before
    public void beforeTest(){
        EngineImplBug engieBug=new EngineImplBug();
        EngineService engie = new EngineContract(engieBug);
        FighterFactory factory=new FighterFactory(engie);
        PlayerService defaultPlayer1 = PlayerFactory.newBouchonGaucheDroite();
        PlayerService defaultPlayer2 = PlayerFactory.newBouchonGaucheDroite();




        engie.init(768 , 1024, 256,
                defaultPlayer1, defaultPlayer2,factory);

        engine= engie;
    }


    @Test
    public void testInitHeight(){

    }

}
