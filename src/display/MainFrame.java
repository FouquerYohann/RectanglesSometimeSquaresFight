package display;

import components.factories.ControlsFactory;
import components.factories.EngineFactory;
import components.impl.game.Game;
import components.services.ActiveFighterService;
import components.services.EngineService;
import components.services.HitboxRectangleService;
import tools.Controls;

import javax.swing.*;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class MainFrame extends JPanel implements Observer {
    private static final long serialVersionUID = 1096504000554348122L;
    private final int     fighter1HealthMax;
    private final int     fighter2HealthMax;
    private       int     fighter1StunMax;
    private       int     fighter2StunMax;
    private       boolean fighter1WasStun;
    private       boolean fighter2WasStun;
    private       JLabel  chronoLab;
    private       Game    game;
    private static final int DELAY = 100;

    public MainFrame(EngineService ue) {
        super();
        game = new Game(ue);
        fighter1HealthMax = ue.getFighter(1).getLife();
        fighter2HealthMax = ue.getFighter(2).getLife();
        fighter1WasStun = false;
        fighter2WasStun = false;
        fighter1StunMax = 0;
        fighter2StunMax = 0;
        chronoLab = new JLabel();
        game.addObserver(this);
        setSize(ue.getWidth(), ue.getHeight());
        setVisible(true);
    }

    public static void main(String[] args) {

        EngineService ue = EngineFactory.defaultEngine();

        //        EngineService ue = EngineFactory.randomEngine();

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
        panel.game.getUnrealEngine().getPlayer(2).setControlleur(controlleur1);

        panel.game.getUnrealEngine().getPlayer(1).setControlleur(controlleur2);

        panel.chronoLab = new JLabel("" + ue.getTime());

        panel.chronoLab.setFont(new Font("SansSerif", Font.BOLD, 110));
        panel.add(panel.chronoLab);

        panel.game.Routine(DELAY);

        fenetre.pack();

    }

    @Override
    public Dimension getPreferredSize() {
        return (new Dimension(game.getUnrealEngine().getWidth(), game
                .getUnrealEngine().getHeight()));
    }

    @Override
    public void paintComponent(Graphics g) {


        Graphics2D g2 = (Graphics2D) g;
        // if (comP1 == CommandeMovement.NEUTRAL
        // && comP2 == CommandeMovement.NEUTRAL)
        // continue;
        EngineService ue = game.getUnrealEngine();
        int engineWidth = ue.getWidth();
        int engineHeight = ue.getHeight();
        ActiveFighterService f1 = ue.getFighter(1);
        ActiveFighterService f2 = ue.getFighter(2);


        if (!fighter1WasStun) {
            if (f1.isBlockstunned() || f1.isHitstunned()) {
                fighter1WasStun = true;
                fighter1StunMax = f1.getStunnCpt();
            }
        } else {
            if (!f1.isBlockstunned() && !f1.isHitstunned()) {
                fighter1WasStun = false;
            }
        }
        if (!fighter2WasStun) {
            if (f2.isHitstunned() || f2.isBlockstunned()) {
                fighter2WasStun = true;
                fighter2StunMax = f2.getStunnCpt();
            }
        } else {
            if (!f2.isBlockstunned() && !f2.isHitstunned()) {
                fighter1WasStun = false;
            }
        }


        g2.clearRect(0, 0, engineWidth, engineHeight);

        g2.setColor(Color.BLACK);
        g2.drawRect(20, 20, engineWidth / 3, engineHeight / 18);
        g2.drawRect(2 * engineWidth / 3 - 20, 20, engineWidth / 3,
                engineHeight / 18);
        g2.drawRect(40, 40 + engineHeight / 18, engineWidth / 4, engineHeight / 24);

        g2.drawRect(2 * engineWidth / 3, 40 + engineHeight / 18, engineWidth / 4,
                engineHeight / 24);


        fighter1StunMax=(fighter1StunMax==0)?1:fighter1StunMax;
        double stunSize1 = ((double) f1.getStunnCpt() / fighter1StunMax) * engineWidth / 4;
        System.out.println("stun size1 "+stunSize1);
        fighter2StunMax=(fighter2StunMax==0)?1:fighter2StunMax;
        double stunSize2 = ((double) f2.getStunnCpt() /  fighter2StunMax) * engineWidth / 4;
        System.out.println("stun size2 "+stunSize2);

        g2.fillRect(40, 40 + engineHeight / 18, (int)stunSize1, engineHeight / 24);
        g2.fillRect(2 * engineWidth / 3, 40 + engineHeight / 18, (int)stunSize2,
                engineHeight / 24);

        chronoLab.setText("" + ue.getTime());

        if (!f1.isTeching())
            g2.setColor(Color.BLUE);
        else {
            g2.setColor(Color.GREEN);
            if (f1.techFrame()) {
                HitboxRectangleService hb = f1.tech().getHitbox();
                g2.fillRect(hb.getPositionX(),
                        engineHeight - (hb.getPositionY() + hb.getHeight()),
                        hb.getWidth(), hb.getHeight());
            }
        }
        g2.fillRect(f1.getX(), engineHeight - (f1.getY() + f1.getHeight()),
                f1.getWidth(), f1.getHeight());

        if (!f2.isTeching())
            g2.setColor(Color.RED);
        else {
            g2.setColor(Color.ORANGE);
            if (f2.techFrame()) {
                HitboxRectangleService hb = f2.tech().getHitbox();
                g2.fillRect(hb.getPositionX(),
                        engineHeight - (hb.getPositionY() + hb.getHeight()),
                        hb.getWidth(), hb.getHeight());
            }
        }
        g2.fillRect(f2.getX(), engineHeight - (f2.getY() + f2.getHeight()),
                f2.getWidth(), f2.getHeight());

        g2.setColor(Color.BLUE);


        int longueur = (int) (((double) f1.getLife() / fighter1HealthMax) * engineWidth / 3);
        g2.fillRect(21, 21, longueur, engineHeight / 18);

        g2.setColor(Color.RED);
        longueur = (int) (((double) f2.getLife() / fighter2HealthMax) * engineWidth / 3);
        g2.fillRect(2 * engineWidth / 3 - 20, 21, longueur, engineHeight / 18);

        g2.setColor(Color.WHITE);

        g2.fillOval(f1.getX(), engineHeight - f1.getHeight(), 50, 50);
        g2.fillOval(f2.getX(), engineHeight - f2.getHeight(), 50, 50);
        g2.fillOval(f1.getX() + f1.getWidth() - 50, engineHeight - f1.getHeight(), 50, 50);
        g2.fillOval(f2.getX() + f2.getWidth() - 50, engineHeight - f2.getHeight(), 50, 50);

        g2.setColor(Color.BLACK);
        g2.fillOval(f1.getX() + 25, engineHeight - f1.getHeight() + 25, 10, 10);
        g2.fillOval(f2.getX() + 15, engineHeight - f2.getHeight() + 25, 10, 10);
        g2.fillOval(f1.getX() + f1.getWidth() - 25, engineHeight - f1.getHeight() + 25, 10, 10);
        g2.fillOval(f2.getX() + f2.getWidth() - 35, engineHeight - f2.getHeight() + 25, 10, 10);


        if (game.isGameOver()) {
            Font font = new Font("Verdana", Font.BOLD, 165);
            g.setFont(font);
            g.setColor(Color.BLACK);
            g.drawString("Game Over", 0, engineWidth / 2);
        }
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
