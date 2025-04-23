package assignment9;

import java.awt.Color;
import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	private Snake snake; 
	private Food food;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		this.snake = new Snake();
		this.food = new Food(); 
		
		//FIXME - construct new Snake and Food objects
	}
	
	// Checks x and y position of head segment and returns true/false to see if it's in bounds; if out of bounds, triggers end of game loop in Game.play()
	// Check for key press (WASD) which updates direction, moves snake, checks if food was eaten (grows snake and spawns new food), redraws snake and food on screen
	public void play() {
		while (snake.isInbounds()) { 
			int dir = getKeypress();
			if (dir != -1) {
				snake.changeDirection(dir);
			}
			snake.move();
			//Testing only: you will eventually need to do more work here
			System.out.println("Keypress: " + dir);

			/*
			 * 1. Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */
			
			//Creates new object that respawns to new location after being eaten
		if(snake.eatFood(food)==true) {
			food = new Food();
			
		}
		updateDrawing();
		}
		
		gameOver();
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
		snake.draw();
		food.draw();
		StdDraw.pause(50);
		StdDraw.show();
		
		
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
	}
	
private void gameOver() {
	StdDraw.setPenColor(Color.BLACK);
	StdDraw.text(0.5,  0.6, "Game Over!");
	StdDraw.show();
}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
