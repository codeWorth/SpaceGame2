package sprites;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import util.Point;
import util.Point.PointType;
import util.Vector;

public class BasicShip implements Drawable {

	public Point position;
	public Vector speed;
	
	/**
	 * Initialize new basic ship.
	 * 
	 * @param gameX		X position in game coordinates
	 * @param gameY		Y poisition in game coordinates
	 */
	public BasicShip(float gameX, float gameY) {
		this.position = new Point(gameX, gameY, PointType.GAME);
		this.speed = new Vector(0, 0);
	}
	
	@Override
	public void draw(Graphics2D ctx) {
		
		ctx.setPaint(Color.WHITE);
		
		Ellipse2D.Double outline = new Ellipse2D.Double(position.screenX(), position.screenY(), 100, 100);
		ctx.fill(outline);
		
	}

	@Override
	public void update() {
		this.position.add(this.speed);
	}
	
	
}
