package assignment9;


public class Food {

	public static final double FOOD_SIZE = 0.06;
	private double x, y;
	private Boolean isAMouse;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food(Boolean isAMouse) {
		x = Math.random()*.9+.05;
		y = Math.random()*.9+.05;	
		this.isAMouse = isAMouse;
	}
	
	//gets overriden
	public int fruitPoints() {
		return 0;
	}
	
	public Boolean isAMouse() {
		return this.isAMouse;
	}
	
	public double getSize(){
		return FOOD_SIZE;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	public void setX(double newX) {
		x = newX;
	}
	
	public void setY(double newY) {
		y = newY;
	}

	/**
	 * Draws the Food
	 * overridden
	 */
	public void draw() {
	}
	

	
	/**
	 * updates food position where fruit doesn't move
	 * method is overridden for mice
	 */
	public void updateFood() {
	}
}
