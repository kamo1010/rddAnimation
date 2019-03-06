package fr.ensma.a3.ia.CercleAgent;

public class CercleModel {
	
	private boolean bouncing;
	private int x, y;

	public void setBouncing(boolean b) {
		bouncing = b;
	}
	
	public boolean isBouncing() {
		return bouncing;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int unX) {
		x = unX;
	}
	
	public void setY(int unY) {
		y = unY;
	}
}