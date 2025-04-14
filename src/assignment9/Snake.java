package assignment9;

import java.awt.Color;
import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.07;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * .35;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		//FIXME - set up the segments instance variable
		deltaX = 0;
		deltaY = 0;
		segments = new LinkedList<>();
		segments.add(new BodySegment(.03, .05, SEGMENT_SIZE, new Color(40, 110, 5)));
	}
	
	public void addSegment() {
		segments.add(new BodySegment(segments.get(segments.size()-1).getX(), segments.get(segments.size()-1).getY(), SEGMENT_SIZE));
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		if (segments.size()>1) {
			for (int i = segments.size()-1; i>=1;i--) {
				segments.get(i).setX(segments.get(i-1).getX());
				segments.get(i).setY(segments.get(i-1).getY());	
			}
		}
		segments.get(0).setX(segments.get(0).getX()+deltaX);
		segments.get(0).setY(segments.get(0).getY()+deltaY);	
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for( int i = segments.size()-1; i>=0; i--) {
			segments.get(i).draw();
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		double headX = segments.get(0).getX();
		double headY = segments.get(0).getY();
		double dist = Math.sqrt(Math.pow(headX-f.getX(), 2) + Math.pow(headY-f.getY(), 2));
		if(dist <= f.getSize()) {
			return true;
		} else {
		return false;
		}
	}
	
	public int getSnakeLength(){
		return segments.size();
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		double headX = segments.get(0).getX();
		double headY = segments.get(0).getY();
		if(headX<1 && headX>0) {
			if(headY<1 && headY>0 ) {
				return true;
			} else {
				return false;
			}
		} else {
		return false;
		}
	}
	
	
}
