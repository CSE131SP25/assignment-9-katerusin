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
		color = new Color(50, 150,10);
	}
	
	public BodySegment(double x, double y, double size, Color headColor) {
		this.x = x;
		this.y = y;
		this.size = size;
		color = headColor;
	}
	
	public void setX(double newX) {
		x = newX;
	}
	
	public void setY(double newY) {
		y = newY;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	/**
	 * Draws the segment
	 */
	public void draw() {
		StdDraw.setPenColor(color);
		StdDraw.setPenRadius(size/2);
		StdDraw.point(x, y);	
		}
	
}
