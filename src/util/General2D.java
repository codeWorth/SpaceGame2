package util;

public interface General2D {

	public float screenX();
	public float screenY();
	
	public float gameX();
	public float gameY();
	
	public void add(General2D other);
	public void subtract(General2D other);
	public void mult(float scalar);
}
