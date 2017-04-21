package display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tools.Controls;

import components.factories.ControlsFactory;
import components.factories.EngineFactory;
import components.impl.game.Game;
import components.services.EngineService;
import components.services.FighterService;

public class MainFrame extends JPanel implements Observer {
    private static final long serialVersionUID = 1096504000554348122L;
    private Game              game;
    private final int         fighter1HealthMax;
    private final int         fighter2HealthMax;

    public MainFrame(EngineService ue) {
	super();
	game = new Game(ue);
	fighter1HealthMax = ue.getFighter(1).getLife();
	fighter2HealthMax = ue.getFighter(2).getLife();
	game.addObserver(this);
	setSize(ue.getWidth(), ue.getHeight());
	setVisible(true);
    }

    
    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(game.getUnrealEngine().getWidth(), game.getUnrealEngine().getHeight()));
    }

    
    @Override
    public void paintComponent(Graphics g) {
	EngineService ue = game.getUnrealEngine();
	int engineWidth = ue.getWidth();
	int engineHeight = ue.getHeight();
	FighterService f1 = ue.getFighter(1);
	FighterService f2 = ue.getFighter(2);
	
	g.clearRect(0, 0, getWidth(), getHeight());
	
	g.setColor(Color.BLUE);
	g.fillRect(f1.getX(), f1.getY(), f1.getWidth(), f1.getHeight());
	setVisible(true);
	g.setColor(Color.RED);
	g.fillRect(f2.getX(), f2.getY(), f2.getWidth(), f2.getHeight());
	setVisible(true);

	g.setColor(Color.BLACK);
	g.drawRect(20, 20, engineWidth / 3, engineHeight / 18);
	g.drawRect(2 * engineWidth / 3 - 20, 20, engineWidth / 3,
	        engineHeight / 18);

	Font timeFont=new Font("SansSerif", Font.BOLD, 120);
	g.setFont(timeFont);
	
	g.drawString(""+ue.getTime(), engineWidth / 2 ,  engineHeight / 9 );
    
	
	
	g.setColor(Color.RED);
	int longueur = f1.getLife() / fighter1HealthMax * engineWidth / 3;
	g.fillRect(21, 21, longueur, engineHeight / 18);

	longueur = f2.getLife() / fighter2HealthMax * engineWidth / 3;
	g.fillRect(2 * engineWidth / 3 - 20, 21, longueur, engineHeight / 18);
	}

    @Override
    public void update(Observable o, Object arg) {
	if (o instanceof Game) {
	    paintComponent(getGraphics());
	    } else {
	    System.out.println(o.getClass());
	}

    }

    public static void main(String[] args) {

	EngineService ue=EngineFactory.defaultEngine();
	
	JFrame fenetre=new JFrame();
	fenetre.setTitle("Sample");
	fenetre.setVisible(true);
	fenetre.setSize(ue.getWidth(),ue.getHeight());
	fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	MainFrame panel = new MainFrame(ue);
	panel.setDoubleBuffered(true);
	fenetre.add(panel);
	
	JLabel fight1 = new JLabel(new JFighter(0, 0));

	JLabel fight2 = new JLabel(new JFighter(0, 0));
	panel.add(fight1);
	panel.add(fight2);

	Controls controlleur1 = ControlsFactory.addSupportPlayer1(fight1);
	Controls controlleur2 = ControlsFactory.addSupportPlayer2(fight2);
	panel.game.getUnrealEngine().getPlayer(2)
	        .setControlleur(controlleur1);

	panel.game.getUnrealEngine().getPlayer(1)
	        .setControlleur(controlleur2);

	panel.game.Routine(20);

	

    }

}
