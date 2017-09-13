package sprites;

import java.awt.Graphics2D;

public interface Drawable {

	/**
	 * Draws a visual representation of the object.
	 * Will use the Camera class to find
	 * Camera X, Y, Scale, and Rotation.
	 * <p>
	 * 
	 * @param ctx		context to draw the object on
	 */
	public void draw(Graphics2D ctx);
	
	
	/**
	 * Update the internal data of this object, called every physics tick.
	 */
	public void update();
	
}
