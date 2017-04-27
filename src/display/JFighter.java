package display;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class JFighter implements Icon {

	private int	height;
	private int	width;

	public JFighter(int height, int width) {
		super();
		this.height = height;
		this.width = width;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
	}

	@Override
	public int getIconWidth() {

		return width;
	}

	@Override
	public int getIconHeight() {
		return height;
	}
}
