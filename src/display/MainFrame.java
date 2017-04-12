package display;

import javax.swing.JFrame;

public class MainFrame {

    public static void main(String[] args) {

	int frameheight = 768;
	int framewidth = 1024;

	JFrame fenetre = new JFrame("RectanglesSometimeSquaresFight");
	fenetre.setSize(framewidth, frameheight);
	fenetre.add(new FighterRepresent(0, 10, 30, framewidth, frameheight));
	fenetre.setVisible(true);
	fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
