
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Box.Filler;

public class Road implements AnimatedGameArtifact {
	private int left;
	private int right;
	private int speed;
	private int height;

	public static int RODE_SIDE = 50;
	public static int LINE_WIDTH = 10;
	public static int TREES_BODYX = 10;
	public static int TREES_BODYY = 100;
	public static int TREES_CROWNX = 0;
	public static int TREES_CROWNY = 50;

	private int lineHeight = 50;
	private int lineSpace = 20;
	private int totalLineHeight = lineHeight + lineSpace;

	private int start;

	public Road(int width, int height, int speed) {
		this.height = height;
		this.speed = speed;
		this.left = RODE_SIDE - LINE_WIDTH;
		this.right = width - RODE_SIDE;
	}

	@Override
	public void animateFrame(long frameNumber) {
		start = (int) (frameNumber % totalLineHeight) * speed;
	}

	@Override
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.setColor(Color.BLACK);
		drawLine(graphics, left);
		drawLine(graphics, right);
		// Dodavanje drveca
		graphics.setColor(new Color(139, 69, 19));
		graphics.fillRect(TREES_BODYX, TREES_BODYY, 18, 80);
		graphics.fillRect(TREES_BODYX, TREES_BODYY + 200, 18, 80);
		graphics.fillRect(TREES_BODYX, TREES_BODYY + 400, 18, 80);
		graphics.fillRect(TREES_BODYX + 760, TREES_BODYY, 18, 80);
		graphics.fillRect(TREES_BODYX + 760, TREES_BODYY + 200, 18, 80);
		graphics.fillRect(TREES_BODYX + 760, TREES_BODYY + 400, 18, 80);
		graphics.setColor(new Color(0, 100, 0));
		graphics.fillOval(TREES_CROWNX, TREES_CROWNY, 35, 70);
		graphics.fillOval(TREES_CROWNX, TREES_CROWNY + 200, 35, 70);
		graphics.fillOval(TREES_CROWNX, TREES_CROWNY + 400, 35, 70);
		graphics.fillOval(TREES_CROWNX + 760, TREES_CROWNY, 35, 70);
		graphics.fillOval(TREES_CROWNX + 760, TREES_CROWNY + 200, 35, 70);
		graphics.fillOval(TREES_CROWNX + 760, TREES_CROWNY + 400, 35, 70);

	}

	private void drawLine(Graphics graphics, int position) {
		int y = start - speed * totalLineHeight;
		while (y < height + totalLineHeight) {
			graphics.drawRect(position, y, LINE_WIDTH, lineHeight);
			y += 70;
		}

	}
}
