package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Fruit extends Food {
	private Color fruitColor;
	private static final Color RED_APPLE = new Color(160, 10,0);
	private static final Color ORANGE = new Color(255, 165,10);
	private static final Color LEMON = new Color(245, 230,10);
	private static final Color GREEN_APPLE = new Color(30, 200,10);

	public Fruit() {
		super (false);
		double fruitChance = Math.random();
		if (fruitChance<.4) {
			fruitColor = RED_APPLE;
		} else if (fruitChance<.7) {
			fruitColor = ORANGE;
		} else if (fruitChance<.9){
			fruitColor = LEMON;
		} else {
			fruitColor = GREEN_APPLE;
		}
	}
	
	public int fruitPoints() {
		if (fruitColor == RED_APPLE) {
			return 1;
		} else if (fruitColor == ORANGE) {
			return 2;
		} else if (fruitColor == LEMON){
			return 3;
		} else {
			return 4;
		}
		
	}

	public void draw() {
		StdDraw.setPenColor(fruitColor);
		StdDraw.setPenRadius(.06);
		StdDraw.point(getX(), getY());
	}
	
	public static void main(String[] args) {
		Food apple = new Fruit();
		apple.draw();
		System.out.print(apple.fruitPoints());
	}
	
}
