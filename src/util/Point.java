package util;



public class Point implements General2D {
	
	public enum PointType { SCREEN, GAME };

	private float screenX, screenY;
	private float gameX, gameY;
	
	/**
	 * Sets point X and Y
	 * <p>
	 * 
	 * @param x		x position
	 * @param y		y position
	 * @param type	PointType of the x and y inputed
	 */
	public Point(float x, float y, PointType type) {
		setX(x, type);
		setY(y, type);
	}
	
	/**
	 * Manually set the coordinates of this point
	 * 
	 * @param screenX	x relative to upper left of window
	 * @param screenY	y relative to upper left of window
	 * @param gameX		x relative to (0,0) in the world
	 * @param gameY		y relative to (0,0) in the world
	 */
	public Point(float screenX, float screenY, float gameX, float gameY) {
		this.screenX = screenX;
		this.screenY = screenY;
		this.gameX = gameX;
		this.gameY = gameY;
	}
	
	/**
	 * Sets the x value of this point. Keep in mind that this
	 * recalculates the point's screen and game values
	 * 
	 * @param x	new X value
	 */
	public void setX(float x, PointType type) {
		if (type == PointType.GAME) {
			this.gameX = x;
			this.screenX = ( (this.gameX - Camera.CAM_X) / Physics.resolution ) + Camera.CAM_WIDTH/2;
		} else {
			this.screenX = x;
			this.gameX = ( (this.screenX - Camera.CAM_WIDTH/2) * Physics.resolution ) + Camera.CAM_X;
		}
	}
	
	public void setY(float y, PointType type) {
		if (type == PointType.GAME) {
			this.gameY = y;
			this.screenY = ( (this.gameY - Camera.CAM_Y) / Physics.resolution ) + Camera.CAM_HEIGHT/2;
		} else {
			this.screenY = y;
			this.gameY = ( (this.screenY - Camera.CAM_HEIGHT/2) * Physics.resolution ) + Camera.CAM_Y;
		}
	}
	
	public void setXY(float x, float y, PointType type) {
		setX(x, type);
		setY(y, type);
	}
	
	
	public float screenX() {
		return this.screenX;
	}
	
	public float screenY() {
		return this.screenY;
	}
	
	public float gameX() {
		return this.gameX;
	}
	
	public float gameY() {
		return this.gameY;
	}
	
	
	/**
	 * Adds point other to this point. Changes this point itself.
	 * 
	 * @param other		Any other Point
	 */
	public void add(General2D other) {
		
		this.gameX += other.gameX();
		this.gameY += other.gameY();
		
		this.screenX += other.screenX();
		this.screenY += other.screenY();
		
	}
	
	/**
	 * Subtracts point other from this point. Changes this point itself.
	 * 
	 * @param other		Any other Point
	 */
	public void subtract(General2D other) {
		
		this.gameX -= other.gameX();
		this.gameY -= other.gameY();
		
		this.screenX -= other.screenX();
		this.screenY -= other.screenY();
		
	}
	
	/**
	 * Multiplies a scalar by this point. Changes this point itself.
	 * 
	 * @param scalar	Any number
	 */
	public void mult(float scalar) {
	
		this.gameX *= scalar;
		this.gameY *= scalar;
		
		this.screenX *= scalar;
		this.screenY *= scalar;
		
	}
	
	/**
	 * Dot product of 2 points. Returns a new point.
	 * 
	 * @param a		first point in dot product
	 * @param b		second point in dot product
	 */
	public static Point mult(General2D a, General2D b) {
		
		float screenX = a.screenX() * b.screenX();
		float screenY = a.screenY() * b.screenY();
		float gameX = a.gameX() * b.gameX();
		float gameY = a.gameY() * b.gameY();
		
		Point newPoint = new Point(screenX, screenY, gameX, gameY);
		return newPoint;
	}
	
}
