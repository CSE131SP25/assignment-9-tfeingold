package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {

	private double x, y, size;
	private Color color;

	
	public BodySegment(double x, double y, double size) {
		this.x = x; 
		this.y = y; 
		this.size = size;
		this.color = StdDraw.BLUE; 
		
	}
	public void setX (double x1) {
		this.x = x1;
	}
		
	public double getX() {
		return x;
	}
	public void setY (double y1) {
		this.y = y1; 
	}
	
	public double getY() {
		return y;
	}
	
	
	/**
	 * Draws the segment
	 */
	public void draw() {
		StdDraw.setPenColor(StdDraw.MAGENTA);
		StdDraw.filledCircle(x, y, size);
	}
	
}
