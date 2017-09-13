package util;

import util.Point.PointType;

public class Vector implements General2D {

	private float x, y;
	
	/**
	 * Sets vector X and Y
	 * <p>
	 * 
	 * @param x		x position
	 * @param y		y position
	 */
	public Vector(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Sets the x value of this point.
	 * 
	 * @param x	new X value
	 */
	public void setX(float x) {
		this.x = x;
	}
	
	/**
	 * Sets the y value of this point.
	 * 
	 * @param y	new Y value
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	public void setXY(float x, float y) {
		setX(x);
		setY(y);
	}
	
	
	public float screenX() {
		return this.x / Physics.resolution;
	}
	
	public float screenY() {
		return this.y / Physics.resolution;
	}
	
	public float gameX() {
		return this.x;
	}
	
	public float gameY() {
		return this.y;
	}
	
	
	/**
	 * Adds vector other to this vector. Changes this vector itself.
	 * 
	 * @param other		Any other Vector
	 */
	public void add(General2D other) {
		
		this.x += other.gameX();
		this.y += other.gameY();
		
	}
	
	/**
	 * Subtracts vector other from this vector. Changes this vector itself.
	 * 
	 * @param other		Any other Vector
	 */
	public void subtract(General2D other) {
		
		this.x -= other.gameX();
		this.y -= other.gameY();
		
	}
	
	/**
	 * Multiplies a scalar by this vector. Changes this vector itself.
	 * 
	 * @param scalar	Any number
	 */
	public void mult(float scalar) {
	
		this.x *= scalar;
		this.y *= scalar;
		
	}
	
	/**
	 * Dot product of 2 vectors. Returns a new vector.
	 * 
	 * @param a		first vector in dot product
	 * @param b		second vector in dot product
	 */
	public static Vector mult(Vector a, Vector b) {
		Vector newVec = new Vector(a.gameX() * b.gameX(), a.gameX() * b.gameX());
		return newVec;
	}

}
