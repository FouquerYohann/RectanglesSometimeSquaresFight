package display;

import components.factories.ControlsFactory;
import components.factories.EngineFactory;
import components.impl.game.Game;
import components.services.EngineService;
import components.services.FighterService;
import tools.Controls;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class MainFrame extends JPanel implements Observer {
    private static final long serialVersionUID = 1096504000554348122L;
    private final int fighter1HealthMax;
    private final int fighter2HealthMax;
    private Game game;

    public MainFrame(EngineService ue) {
        super();
        game = new Game(ue);
        fighter1HealthMax = ue.getFighter(1).getLife();
        fighter2HealthMax = ue.getFighter(2).getLife();
        game.addObserver(this);
        setSize(ue.getWidth(), ue.getHeight());
        setVisible(true);
    }

    public static void main(String[] args) {

        EngineService ue = EngineFactory.defaultEngine();

        JFrame fenetre = new JFrame();
        fenetre.setTitle("RectanglesSometimesSquaresFight");
        fenetre.setVisible(true);
        fenetre.setResizable(false);
        fenetre.setSize(ue.getWidth(), ue.getHeight());
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        MainFrame panel = new MainFrame(ue);
        panel.setDoubleBuffered(true);
        fenetre.setContentPane(panel);
        fenetre.setIgnoreRepaint(true);
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

        panel.game.Routine(40);

        fenetre.pack();


    }

    @Override
    public Dimension getPreferredSize() {
        return (new Dimension(game.getUnrealEngine().getWidth(), game.getUnrealEngine().getHeight()));
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        EngineService ue = game.getUnrealEngine();
        int engineWidth = ue.getWidth();
        int engineHeight = ue.getHeight();
        FighterService f1 = ue.getFighter(1);
        FighterService f2 = ue.getFighter(2);

        g2.clearRect(0, 0, engineWidth, engineHeight);

        g2.setColor(Color.BLACK);
        g2.drawRect(20, 20, engineWidth / 3, engineHeight / 18);
        g2.drawRect(2 * engineWidth / 3 - 20, 20, engineWidth / 3,
                engineHeight / 18);

        Font timeFont = new Font("SansSerif", Font.BOLD, 120);
        g2.setFont(timeFont);

        g2.drawString("" + ue.getTime(), engineWidth / 2, engineHeight / 9);


        g2.setColor(Color.BLUE);
        g2.fillRect(f1.getX(), f1.getY(), f1.getWidth(), f1.getHeight());

        g2.setColor(Color.RED);
        g2.fillRect(f2.getX(), f2.getY(), f2.getWidth(), f2.getHeight());


        int longueur = f1.getLife() / fighter1HealthMax * engineWidth / 3;
        g2.fillRect(21, 21, longueur, engineHeight / 18);

        longueur = f2.getLife() / fighter2HealthMax * engineWidth / 3;
        g2.fillRect(2 * engineWidth / 3 - 20, 21, longueur, engineHeight / 18);
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Game) {
            repaint();
        } else {
            System.out.println(o.getClass());
        }

    }

}
