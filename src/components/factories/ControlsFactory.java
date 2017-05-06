package components.factories;

import components.enums.Commande;
import tools.Controls;

import javax.swing.*;

public class ControlsFactory {

    public static Controls addSupportPlayer1(JComponent comp) {
        Controls ct = new Controls(comp);
        ct.addAction("LEFT", Commande.LEFT);
        ct.addAction("RIGHT", Commande.RIGHT);
        ct.addAction("UP", Commande.KICK);
        ct.addAction("DOWN", Commande.CROUCH);
        ct.addAction("ENTER", Commande.PUNCH);
        ct.addAction("M", Commande.BOUMTMORT);

        return ct;
    }

    public static Controls addSupportPlayer2(JComponent comp) {
        Controls ct = new Controls(comp);
        ct.addAction("Q", Commande.LEFT);
        ct.addAction("D", Commande.RIGHT);
        ct.addAction("Z", Commande.KICK);
        ct.addAction("S", Commande.CROUCH);
        ct.addAction("SPACE", Commande.PUNCH);
        ct.addAction("X", Commande.BOUMTMORT);
        return ct;
    }

}
