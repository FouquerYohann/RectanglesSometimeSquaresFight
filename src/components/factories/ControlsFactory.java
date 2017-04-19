package components.factories;

import javax.swing.JComponent;

import tools.Controls;
import components.enums.CommandeMovement;

public class ControlsFactory {

    public static Controls addSupportPlayer1(JComponent comp) {
	Controls ct = new Controls(comp);
	ct.addAction("LEFT", CommandeMovement.LEFT);
	ct.addAction("RIGHT", CommandeMovement.RIGHT);
	ct.addAction("UP", CommandeMovement.JUMP);
	ct.addAction("DOWN", CommandeMovement.CROUCH);
	return ct;
    }

    public static Controls addSupportPlayer2(JComponent comp) {
	Controls ct = new Controls(comp);
	ct.addAction("Q", CommandeMovement.LEFT);
	ct.addAction("D", CommandeMovement.RIGHT);
	ct.addAction("Z", CommandeMovement.JUMP);
	ct.addAction("S", CommandeMovement.CROUCH);
	return ct;
    }

}
