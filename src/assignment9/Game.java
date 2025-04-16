package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	private Snake playerSnake;
	private Food currentFood;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		playerSnake = new Snake();
		currentFood = new Fruit();
	}
	
	public Food spawnNewFood() {
		double foodChance = Math.random();
		if (foodChance < .7) {
			return new Fruit();
		}
		else {
			return new Mouse();
		}
	}
	
	public void play() {
		while (playerSnake.isInbounds()) {
			int dir = getKeypress();
			playerSnake.changeDirection(dir);
			currentFood.updateFood();
			playerSnake.move();StdDraw.setPenColor();
			StdDraw.setPenRadius();
			updateDrawing();
			if (currentFood.getY()>1.0237 ||currentFood.getX()<-.035 ||currentFood.getY()<-.04) {
				currentFood = spawnNewFood();
			}
			if (playerSnake.eatFood(currentFood)) {
				if(currentFood.isAMouse()==true) {
					playerSnake.addSegment();
					playerSnake.addSegment();
					playerSnake.addSegment();
					playerSnake.addSegment();
					playerSnake.addSegment();
					playerSnake.addSegment();
					playerSnake.addSegment();

				} else {
					if (currentFood.fruitPoints()==4) {
						playerSnake.addSegment();
						playerSnake.addSegment();
						playerSnake.addSegment();
						playerSnake.addSegment();

					} else if (currentFood.fruitPoints()==3) {
						playerSnake.addSegment();
						playerSnake.addSegment();
						playerSnake.addSegment();
					}else if (currentFood.fruitPoints()==2) {
						playerSnake.addSegment();
						playerSnake.addSegment();
					} else {
						playerSnake.addSegment();
					}
				}
				currentFood = spawnNewFood();
			}
			
		}

	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		StdDraw.clear();
		
		playerSnake.draw();
		currentFood.draw();
		StdDraw.setPenColor();
		StdDraw.text(.8, .05, "Snake Length: " + playerSnake.getSnakeLength());
		StdDraw.text(.8, .95, "Red Fruit = +1 length");
		StdDraw.text(.8, .9, "Orange Fruit = +2 length");
		StdDraw.text(.8, .85, "Yellow Fruit = +3 length");
		StdDraw.text(.8, .8, "Green Fruit = +4 length");
		StdDraw.text(.8, .75, "Mouse = +7 length");
		
		StdDraw.show(50);	
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
